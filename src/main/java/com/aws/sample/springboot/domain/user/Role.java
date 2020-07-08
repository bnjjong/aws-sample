/*
 * COPYRIGHT (c) Enliple 2019
 * This software is the proprietary of Enliple
 *
 * @author <a href="mailto:jshan@enliple.com">jshan</a>
 * @since 2020/07/08
 */
package com.aws.sample.springboot.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

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
@Getter
@RequiredArgsConstructor
public enum Role {
  GUEST("ROLE_GUEST", "손님"), // 스프링 시큐리티에서는 권한 코드에 항상 ROLE_ 이 앞에 있어야 함.
  USER("ROLE_USER", "일반 사용자");

  private final String key;
  private final String title;
}
