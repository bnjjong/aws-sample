/*
 * COPYRIGHT (c) Enliple 2019
 * This software is the proprietary of Enliple
 *
 * @author <a href="mailto:jshan@enliple.com">jshan</a>
 * @since 2020/07/06
 */

package com.aws.sample.springboot.service;

import com.aws.sample.springboot.domain.posts.Posts;
import com.aws.sample.springboot.domain.posts.PostsRepository;
import com.aws.sample.springboot.web.dto.PostsResponseDto;
import com.aws.sample.springboot.web.dto.PostsSaveRequestDto;
import com.aws.sample.springboot.web.dto.PostsUpdateRequestDto;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
@Service
public class PostsService {

  private final PostsRepository postsRepository;

  @Transactional
  public Long save(PostsSaveRequestDto requestDto) {
    return postsRepository.save(requestDto.toEntity()).getId();
  }

  @Transactional
  public Long update(Long id, PostsUpdateRequestDto requestDto) {
    Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
    // update 하는 쿼리가 없지만 JPA 영속성 컨텍스트로 인해 업데이트가 된다. 영속성이란? 엔티티를 영구 저장하는 환경
    // jpa의 핵심은 엔티티가 영속성 컨텍스트에 포함되어 있냐 아니냐로 갈림.
    // 트랜잭션이 끝나는 시점에 해당 update가 수행됨.
    // entity의 객체의 값만 변경하면 별도로 update 쿼리를 날릴 필요가 없음 -> 더티체킹(dirty checking)
    posts.update(requestDto.getTitle(), requestDto.getContent());
    return id;
  }

  public PostsResponseDto findById(Long id) {
    Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
    return new PostsResponseDto(entity);
  }

}
