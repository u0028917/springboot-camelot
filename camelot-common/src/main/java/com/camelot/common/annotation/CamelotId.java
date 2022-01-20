/**
 *  Copyright (c) 2018 EA
 */
package com.camelot.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>Description: [ES主键标识]</p>
 * Created on 2018/8/30
 * @author <a href="mailto:sunshaobo60@camelotchina.com">孙少波</a>
 * @version 1.0
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CamelotId {
}
