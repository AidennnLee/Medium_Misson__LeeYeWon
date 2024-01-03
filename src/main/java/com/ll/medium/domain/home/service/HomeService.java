package com.ll.medium.domain.home.service;

import com.ll.medium.domain.article.entity.Article;
import com.ll.medium.domain.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeService {

    private final ArticleRepository articleRepository;
    public List<Article> getRecentList(){
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(new Sort.Order(Sort.Direction.DESC, "createDate"));
        Sort sort = Sort.by(sorts);

        return this.articleRepository.findAll(sort);
    }
}
