package com.aws.sample.springboot.domain.posts;

import java.time.LocalDateTime;
import java.util.List;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
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
@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

  @Autowired
  PostsRepository postsRepository;

  @After
  public void cleanUp() {
    postsRepository.deleteAll();
  }

  @Test
  public void 게시글저장_불러오기() {
    String title = "테스트 게시글";
    String content = "테스트 본문";

    postsRepository.save(Posts.builder()
        .title(title)
        .content(content)
        .author("dogfootmaster@gmail.com")
        .build());

    List<Posts> postsList = postsRepository.findAll();

    Posts posts = postsList.get(0);
    assertThat(posts.getTitle()).isEqualTo(title);
    assertThat(posts.getContent()).isEqualTo(content);
  }

  @Test
  public void BaseTimeEntity_등록() {
    LocalDateTime now = LocalDateTime.of(2020,07,06,20,0,0);
    postsRepository.save(
        Posts.builder()
        .title("title")
        .content("content")
        .author("jshan")
        .build()
    );

    // when
    List<Posts> postsList = postsRepository.findAll();

    //then
    Posts posts = postsList.get(0);
    System.out.println(">>>>>>>>>>>> createdDate = "+ posts.getCreatedDate());
    System.out.println(">>>>>>>>>>>> modifiedDate = "+ posts.getModifiedDate());

    assertThat(posts.getCreatedDate()).isAfter(now);
    assertThat(posts.getModifiedDate()).isAfter(now);

    System.out.println("김은지 사랑해요!");
  }

}