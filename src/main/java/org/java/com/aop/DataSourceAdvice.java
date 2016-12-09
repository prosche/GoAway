package org.java.com.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.java.com.common.enums.DataSources;
import org.java.com.common.util.DataSourceTypeManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect    // for aop
@Component // for auto scan
@Order(0)  // execute before @Transactional
public class DataSourceAdvice {
	private static final Logger logger = LoggerFactory.getLogger(DataSourceAdvice.class);
	
	@Pointcut("execution(* org.java.com.common.dao..*.*(..))")
    public void aspect(){
		logger.debug("AOP Start!");
	};

	// service方法执行之前被调用
    @Before("aspect()")
    public void before(JoinPoint jp) {
    	logger.debug("set dataSources slave");
        DataSourceTypeManager.set(DataSources.SLAVE);
    }
//   
//    public void before(Method method, Object[] args, Object target) throws Throwable {
//        System.out.println("切入点: " + target.getClass().getName() + "类中" + method.getName() + "方法");
//        if(method.getName().startsWith("add")
//            || method.getName().startsWith("create")
//            || method.getName().startsWith("save")
//            || method.getName().startsWith("edit")
//            || method.getName().startsWith("update")
//            || method.getName().startsWith("delete")
//            || method.getName().startsWith("remove")){
//            System.out.println("切换到: master");
//            DataSourceTypeManager.set(DataSources.MASTER);
//        }
//        else  {
//            System.out.println("切换到: slave");
//            DataSourceTypeManager.set(DataSources.SLAVE);
//        }
//    }
//
//    // service方法执行完之后被调用
//	@AfterReturning(pointcut="aspect()",returning="result")
//    public void afterReturning(Object result) throws Throwable {
//    }
//
//    // 抛出Exception之后被调用
//	@AfterThrowing(pointcut="aspect()",throwing="e")
//    public void afterThrowing(Exception e) throws Throwable {
//    	DataSourceTypeManager.set(DataSources.SLAVE);
//        System.out.println("出现异常,切换到: slave");
//    }

}
