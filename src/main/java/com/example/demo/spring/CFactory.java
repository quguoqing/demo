package com.example.demo.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author: chunmu
 * @Date: 2020/5/19 23:34
 * @Description:
 */
@Component
public class CFactory implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        return new CFactory();
    }

    @Override
    public Class<?> getObjectType() {
        return CFactory.class;
    }
}
