package com.example.batch.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@Slf4j
public class BeanUtils {

    public static Object getBean(String beanId) {

        ApplicationContext applicationContext = ApplicationContextProvider.getApplicationContext();

        if( applicationContext == null ) {
            throw new NullPointerException("Spring의 ApplicationContext초기화 안됨");
        }
        return applicationContext.getBean(beanId);
    }
}
