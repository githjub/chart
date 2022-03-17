package com.example.springboot.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @program: springboot
 * @description:
 * @author: llz
 * @date: 2021/7/28 16:01
 */
@Component
@Aspect
public class LAspect {
    Logger logger = LoggerFactory.getLogger(LAspect.class);
}
