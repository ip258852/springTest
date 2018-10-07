package org.test.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class appContextIml implements ApplicationContextAware {

    private static ApplicationContext context;

    public static ApplicationContext getContext() throws Exception {
        if(context!=null)
            return context;
        else
            throw new Exception("No context");
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static Object getBean(String beanId){
        return  context.getBean(beanId);
    }
}
