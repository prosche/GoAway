package org.java.com.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.java.com.common.enums.DataSources;
import org.java.com.common.util.DataSourceTypeManager;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect    // for aop
@Component // for auto scan
@Order(0)  // execute before @Transactional
public class DataSourceInterceptor {    
//    @Pointcut("execution(public * org.java.com.service..*.getAllUsers(..))")
    @Pointcut("execution(org.java.com.service..*.*(..))")
    public void dataSourceSlave(){};
    
    @Before("dataSourceSlave()")
    public void before(JoinPoint jp) {
        DataSourceTypeManager.set(DataSources.SLAVE);
    }
    // ... ...
}