/*
 * COPYRIGHT (c) Enliple 2019
 * This software is the proprietary of Enliple
 *
 * @author <a href="mailto:jshan@enliple.com">jshan</a>
 * @since 2020/07/06
 */

package com.aws.sample.springboot.domain;

import java.time.LocalDateTime;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * create on 2020/07/06.
 * <p> 클래스 설명 </p>
 * <p> {@link } and {@link }관련 클래스 </p>
 *
 * @author jshan
 * @version 1.0
 * @see
 * @since 지원하는 자바버전 (ex : 5+ 5이상)
 */
@Getter
@MappedSuperclass //JPA Entity 클래스들이 BaseTimeEntity 을 상속할 경우 필드들도 컬럼으로 인식
@EntityListeners(AuditingEntityListener.class) //Auditing 기능을 포함
public abstract class BaseTimeEntity {
  @CreatedDate // Entity 가 생성되어 저장될 때 시간이 자동 저장 됨.
  private LocalDateTime createdDate;

  @LastModifiedDate // 조회한 Entity의 값을 변경할 때 시간이 자동 저장 됨.
  private LocalDateTime modifiedDate;

}
