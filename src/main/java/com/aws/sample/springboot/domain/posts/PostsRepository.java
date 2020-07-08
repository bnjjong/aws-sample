/*
 * COPYRIGHT (c) Enliple 2019
 * This software is the proprietary of Enliple
 *
 * @author <a href="mailto:jshan@enliple.com">jshan</a>
 * @since 2020/07/06
 */
package com.aws.sample.springboot.domain.posts;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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
public interface PostsRepository extends JpaRepository<Posts, Long> { // Entity 클래스, PK 타입

  @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
  List<Posts> findAllDesc();

}
