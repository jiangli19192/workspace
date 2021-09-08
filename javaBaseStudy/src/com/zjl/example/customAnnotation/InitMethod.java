package com.zjl.example.customAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// @Target指定了注解运用的地方
@Target(ElementType.METHOD)
// @Retention
@Retention(RetentionPolicy.RUNTIME)
public @interface InitMethod {
}
