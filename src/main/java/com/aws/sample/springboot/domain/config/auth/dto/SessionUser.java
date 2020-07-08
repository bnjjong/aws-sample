/*
 * COPYRIGHT (c) Enliple 2019
 * This software is the proprietary of Enliple
 *
 * @author <a href="mailto:jshan@enliple.com">jshan</a>
 * @since 2020/07/08
 */

package com.aws.sample.springboot.domain.config.auth.dto;

import com.aws.sample.springboot.domain.user.User;
import java.io.Serializable;
import lombok.Getter;

/**
 * 인증된 사용자 정보만 필요로 함. 그 외에 필요한 정보들은 없으니 name, email, picture만 선언 한다.
 * <p> {@link } and {@link }관련 클래스 </p>
 *
 * @author jshan
 * @version 1.0
 * @see
 * @since 지원하는 자바버전 (ex : 5+ 5이상)
 */
@Getter
public class SessionUser implements Serializable {
  private String name;
  private String email;
  private String picture;

  public SessionUser(User user) {
    this.name = user.getName();
    this.email = user.getEmail();
    this.picture = user.getPicture();
  }
}
