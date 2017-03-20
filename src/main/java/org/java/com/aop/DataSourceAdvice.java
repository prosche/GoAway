package org.java.com.aop;

import java.lang.reflect.Method;

import org.java.com.common.enums.DataSources;
import org.java.com.common.util.DataSourceTypeManager;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

public class DataSourceAdvice implements MethodBeforeAdvice, AfterReturningAdvice, ThrowsAdvice{

	// service����ִ��֮ǰ������
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("�����: " + target.getClass().getName() + "����" + method.getName() + "����");
        if(method.getName().startsWith("add")
            || method.getName().startsWith("create")
            || method.getName().startsWith("save")
            || method.getName().startsWith("edit")
            || method.getName().startsWith("update")
            || method.getName().startsWith("delete")
            || method.getName().startsWith("remove")){
            System.out.println("�л���: master");
            DataSourceTypeManager.set(DataSources.MASTER);
        }
        else  {
            System.out.println("�л���: slave");
            DataSourceTypeManager.set(DataSources.SLAVE);
        }
    }

    // service����ִ����֮�󱻵���
    public void afterReturning(Object arg0, Method method, Object[] args, Object target) throws Throwable {
    }

    // �׳�Exception֮�󱻵���
    public void afterThrowing(Method method, Object[] args, Object target, Exception ex) throws Throwable {
    	DataSourceTypeManager.set(DataSources.SLAVE);
        System.out.println("�����쳣,�л���: slave");
    }


}
