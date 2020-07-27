/*
 * COPYRIGHT (c) Enliple 2019
 * This software is the proprietary of Enliple
 *
 * @author <a href="mailto:jshan@enliple.com">jshan</a>
 * @since 2020/07/08
 */

package com.aws.sample.springboot.domain.config.auth.dto;

import com.aws.sample.springboot.domain.user.Role;
import com.aws.sample.springboot.domain.user.User;
import java.util.Map;
import lombok.Builder;
import lombok.Getter;

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
public class OAuthAttributes {

  private Map<String, Object> attributes;
  private String nameAttributeKey;
  private String name;
  private String email;
  private String picture;

  @Builder
  public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey,
      String name, String email, String picture) {
    this.attributes = attributes;
    this.nameAttributeKey = nameAttributeKey;
    this.name = name;
    this.email = email;
    this.picture = picture;
  }

  // OAuth2User 에서 반환하는 사용자 정보는 Map이기 때문에 값 하나하나를 변환해야만 한다.
  public static OAuthAttributes of(String registrationId, String userNameAttributeName
      , Map<String, Object> attributes) {
    if ("naver".equals(registrationId)) {
      return ofNaver("id", attributes);
    }
    return ofGoogle(userNameAttributeName, attributes);

  }

  private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
    return OAuthAttributes.builder()
        .name((String) attributes.get("name"))
        .email((String) attributes.get("email"))
        .picture((String) attributes.get("picture"))
        .attributes(attributes)
        .nameAttributeKey(userNameAttributeName)
        .build();
  }

  private static OAuthAttributes ofNaver(String userNameAttributeName, Map<String, Object> attributes) {
    Map<String, Object> response = (Map<String, Object>) attributes.get("response");

    return OAuthAttributes.builder()
        .name((String) response.get("name"))
        .email((String) response.get("email"))
        .picture((String) response.get("profile_image"))
        .attributes(response)
        .nameAttributeKey(userNameAttributeName)
        .build();
  }

  // User Entity를 생성한다.
  // OAuthAttributes 에서 엔티티를 생성하는 시점은 처음 가입할 때 입니다.
  // 가입할 때의 기본 권한을 GUEST로 주기 위해서 role 빌더값에는 Role.GUEST 를 사용
  public User toEntity() {
    return User.builder()
        .name(name)
        .email(email)
        .picture(picture)
        .role(Role.GUEST)
        .build();
  }




}
