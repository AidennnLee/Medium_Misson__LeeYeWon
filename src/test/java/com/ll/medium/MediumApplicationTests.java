package com.ll.medium;

import com.ll.medium.domain.article.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MediumApplicationTests {

    @Autowired
    private ArticleService articleService;

    @Test
    void testJpa() {
        for(int i = 1; i < 50; i++){
            String subject = String.format("테스트용 글:[%02d]", i);
            String content = "테스트용 글입니다.";
            this.articleService.create(subject, content);
        }
    }

}
