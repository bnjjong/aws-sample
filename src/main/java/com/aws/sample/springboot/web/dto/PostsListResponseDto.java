/*
 * COPYRIGHT (c) Enliple 2019
 * This software is the proprietary of Enliple
 *
 * @author <a href="mailto:jshan@enliple.com">jshan</a>
 * @since 2020/07/07
 */

package com.aws.sample.springboot.web.dto;

import com.aws.sample.springboot.domain.posts.Posts;
import java.time.LocalDateTime;

/**
 * create on 2020/07/07.
 * <p> 클래스 설명 </p>
 * <p> {@link } and {@link }관련 클래스 </p>
 *
 * @author jshan
 * @version 1.0
 * @see
 * @since 지원하는 자바버전 (ex : 5+ 5이상)
 */
public class PostsListResponseDto {
  private Long id;
  private String title;
  private String author;
  private LocalDateTime modifiedDate;

  public PostsListResponseDto(Posts entity) {
    this.id = entity.getId();
    this.title = entity.getTitle();
    this.author = entity.getAuthor();
    this.modifiedDate = entity.getModifiedDate();
  }


}
