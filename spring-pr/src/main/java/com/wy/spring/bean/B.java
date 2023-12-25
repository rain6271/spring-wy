package com.wy.spring.bean;

import org.springframework.core.Ordered;

/**
 * TODO
 *
 * @author WangYu
 * @date 2023/12/2 19:28
 */
public class A implements Ordered {

    @Override
    public int getOrder() {
        return 1;
    }
}
