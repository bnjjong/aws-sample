/*
 * COPYRIGHT (c) Enliple 2019
 * This software is the proprietary of Enliple
 *
 * @author <a href="mailto:jshan@enliple.com">jshan</a>
 * @since 2020/07/08
 */
package com.aws.sample.springboot.domain.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * create on 2020/07/08.
 * <p> 클래스 설명 </p>
 * <p> {@link } and {@link }관련 클래스 </p>
 *
 * @author jshan
 * @version 1.0
 * @see
 * @since 지원하는 자바버전 (ex : 5+ 5이상)
 */

/**
 * 이 어노테이션이 생성될 수 있는 위치를 지정합니다.
 * PARAMETER로 지정했으니 메소드의 파라미터로 선언된 객체에서만 사용 가능
 * 이 외에도 클래스 선언문에 쓸 수 있는 TYPE 등이 있음.
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser { // 어노테이션 클래스 LoginUser라는 이름을 가진 어노테이션이 생성되었다고 보면 된다.

}
