package com.wy.spring.bean;

/**
 * TODO
 *
 * @author WangYu
 * @date 2023/11/28 16:01
 */

public class BeanDefinition {
    private Class<?> type;
    private String scope;

    public Class<?> getType() {
        return type;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
