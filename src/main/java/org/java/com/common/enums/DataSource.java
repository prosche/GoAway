package org.java.com.common.enums;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据库annotation定义
 * @DataSource('master') / @DataSource('slave')
 *
 */

@Retention(RetentionPolicy.RUNTIME)  
@Target(ElementType.METHOD)  
@Documented  
public @interface DataSource {
	DataSources value() default DataSources.MASTER;
}