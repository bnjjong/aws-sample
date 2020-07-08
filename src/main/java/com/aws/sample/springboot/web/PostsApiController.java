/*
 * COPYRIGHT (c) Enliple 2019
 * This software is the proprietary of Enliple
 *
 * @author <a href="mailto:jshan@enliple.com">jshan</a>
 * @since 2020/07/06
 */

package com.aws.sample.springboot.web;

import com.aws.sample.springboot.service.PostsService;
import com.aws.sample.springboot.web.dto.PostsResponseDto;
import com.aws.sample.springboot.web.dto.PostsSaveRequestDto;
import com.aws.sample.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
@RequiredArgsConstructor
@RestController
public class PostsApiController {
  private final PostsService postsService;

  @PostMapping("/api/v1/posts")
  public Long save(@RequestBody PostsSaveRequestDto requestDto) {
    return postsService.save(requestDto);
  }

  @PutMapping("/api/v1/posts/{id}")
  public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
    return postsService.update(id, requestDto);
  }

  @GetMapping("/api/v1/posts/{id}")
  public PostsResponseDto findById (@PathVariable Long id) {
    return postsService.findById(id);
  }

  @DeleteMapping("/api/v1/posts/{id}")
  public Long delete (@PathVariable Long id) {
    postsService.delete(id);
    return id;
  }

}
