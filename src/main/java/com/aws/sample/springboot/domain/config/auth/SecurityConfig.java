/*
 * COPYRIGHT (c) Enliple 2019
 * This software is the proprietary of Enliple
 *
 * @author <a href="mailto:jshan@enliple.com">jshan</a>
 * @since 2020/07/08
 */

package com.aws.sample.springboot.domain.config.auth;

import com.aws.sample.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

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
@RequiredArgsConstructor
@EnableWebSecurity // spring security 설정들을 활성화 해준다.
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  private final CustomOAuth2UserService customOAuth2UserService;

  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable().headers().frameOptions().disable() // h2-console 환면을 사용하기 위해 해당 옵션들을 disabled 한다.
        .and()
          .authorizeRequests() // url별 권한 관리를 설정하는 옵션의 시작점.
          .antMatchers("/","/css/**", "/images/**","/js/**","/h2-console/**")
          .permitAll()
          .antMatchers("/api/v1/**").hasRole(Role.USER.name())
          .anyRequest().authenticated() //위에 설정한 url 외의 url들은 모두 인증된 사용자들에게만 허용하게 한다.
        .and()
          .logout() // 로그아웃 기능에 대한 여러 설정의 진입점
            .logoutSuccessUrl("/") //로그아웃 성공 시 / 주소로 이동
        .and()
          .oauth2Login() // oauth2 로그인 기능에 대한 여러 설정의 진입점
            .userInfoEndpoint() // oauth2 로그인 성공 이후 사용자 정보를 가져올 때의 설정을 담당
            // 소셜 로그인 성공 시 후속 조치를 진행할 인터페이스 구현체를 등록
            // 리소스 서버(즉, 소셜 서비스들)에서 사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능을 명시할 수 있다.
            .userService(customOAuth2UserService);
  }
}
