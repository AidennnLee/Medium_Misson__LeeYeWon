package com.ll.medium.domain.article.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleForm {
    @NotEmpty(message="제목을 작성하세요.")
    @Size(max=100)
    private String title;

    @NotEmpty(message="본문을 작성하세요.")
    private String body;
}
