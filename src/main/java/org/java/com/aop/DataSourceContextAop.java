package org.java.com.aop;

import java.lang.reflect.Method;  

import org.aspectj.lang.JoinPoint;  
import org.aspectj.lang.ProceedingJoinPoint;  
import org.aspectj.lang.annotation.Around;  
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.java.com.common.enums.DataSource;
import org.java.com.common.util.DataSourceTypeManager;
import org.springframework.core.annotation.Order;  
import org.springframework.stereotype.Component;  
  
  
@Aspect  
@Order(value=1)  
@Component  
public class DataSourceContextAop {  
  
    @Around("execution(* org.java.com.service..*.*(..))")
    public Object setDynamicDataSource(ProceedingJoinPoint pjp) throws Throwable {  
        Method method = this.getMethod(pjp);  
        DataSource dataSource = method.getAnnotation(DataSource.class); 
        if (dataSource != null) {  
        	DataSourceTypeManager.set(dataSource.value());  
        }  
            return pjp.proceed();  
    }  
  
      
    public Method getMethod(JoinPoint pjp) {  
        Method method = null;  
        MethodSignature signature = (MethodSignature) pjp.getSignature();  
        method = signature.getMethod();  
        return method;  
    }  
  
}  
