package com.wy.spring.bean;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * TODO
 *
 * @author WangYu
 * @date 2023/11/28 16:01
 */
public class WyApplicationContext implements BeanFactory {

    public WyApplicationContext() {

    }

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    private Map<String, Object> objectMap = new ConcurrentHashMap<>();

    public WyApplicationContext(Class<?> c) {
        ComponentScan componentScan = c.getAnnotation(ComponentScan.class);
        String scan = componentScan != null ? componentScan.value().replace(".", "/") : "";
        this.doScan(scan);

    }

    private void doScan(String packageUrl) {
        // 扫描类路径
        URL url = ClassLoader.getSystemResource("");
        File file = new File(url.getPath() + packageUrl);
        List<File> classFiles = new ArrayList<File>();
        tree(file, classFiles);
        ClassLoader classLoader = this.getClass().getClassLoader();
        for (File classFile : classFiles) {
            String absolutePath = classFile.getAbsolutePath();
            String className = absolutePath.substring(absolutePath.indexOf("com"), absolutePath.indexOf(".class"))
                    .replace("\\", ".");
            try {
                Class<?> loadClass = classLoader.loadClass(className);
                if (loadClass.getAnnotation(Component.class) != null) {
                    // 构建BeanDefinition对象
                    BeanDefinition beanDefinition = new BeanDefinition();
                    beanDefinition.setType(loadClass);
                    Component annotation = loadClass.getAnnotation(Component.class);
                    String s = annotation.value().isEmpty()
                            ? this.toLowerCaseFirst(className.substring(className.lastIndexOf(".") + 1))
                            : annotation.value();
                    beanDefinitionMap.put(s, beanDefinition);
                }

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private String toLowerCaseFirst(String str) {
        char c = str.charAt(0);
        return Character.toLowerCase(c) + str.substring(1);
    }


    private static void tree(File file, List<File> classFile) {
        if (file.listFiles() == null) {
            return;
        }
        for (File listFile : Objects.requireNonNull(file.listFiles())) {
            if (!listFile.isDirectory()) {
                classFile.add(listFile);
            } else {
                tree(listFile, classFile);
            }
        }
    }

    @Override
    public Object getBean(String beanName) {
        if (!beanDefinitionMap.containsKey(beanName)) {
            return null;
        }

        if (objectMap.containsKey(beanName)) {
            return objectMap.get(beanName);
        } else {
            try {
                Class<?> type = beanDefinitionMap.get(beanName).getType();
                Object o = type.newInstance();
                boolean b = false;
                for (Method method : type.getMethods()) {
                    if (method.isAnnotationPresent(Transactional.class)) {
                        b = true;
                        break;
                    }
                }
                if (b) {
                    Enhancer enhancer = new Enhancer();
                    enhancer.setSuperclass(type);
                    enhancer.setCallback(new MethodInterceptor() {
                        @Override
                        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                            System.out.println("代理执行方法执行前..........");
                            Object result = methodProxy.invokeSuper(o, objects);
                            System.out.println("代理执行方法执行后..........");
                            return result;
                        }
                    });
                    o = enhancer.create();
                }

                for (Field declaredField : type.getDeclaredFields()) {
                    if (declaredField.isAnnotationPresent(Autowired.class)) {
                        Object bean = getBean(declaredField.getName());
                        declaredField.setAccessible(Boolean.TRUE);
                        declaredField.set(o, bean);
                    }
                }
                if (o instanceof BeanNameAware) {
                    ((BeanNameAware)o).setBeanName(beanName);
                }
                objectMap.put(beanName, o);
                return o;
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Object getBean(Class<?> type) {
        return null;
    }
}
