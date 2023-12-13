package com.ll.medium.domain.article.service;

import com.ll.medium.domain.article.entity.Article;
import com.ll.medium.domain.article.repository.ArticleRepository;
import com.ll.medium.domain.member.entity.Member;
import com.ll.medium.global.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public List<Article> getList(){
        return this.articleRepository.findAll();
    }

    public Article getArticle(Integer id){
        Optional<Article> article = this.articleRepository.findById(id);
        if(article.isPresent()){
            return article.get();
        } else{
            throw new DataNotFoundException("question not found");
        }
    }

    public void create(String title, String body, Member writer){
        Article a = new Article();
        a.setTitle(title);
        a.setBody(body);
        a.setCreateDate(LocalDateTime.now());
        a.setWriter(writer);

        this.articleRepository.save(a);
    }

    public Page<Article> getList(int page){
        Pageable pageable = PageRequest.of(page, 15);
        return this.articleRepository.findAll(pageable);
    }

    public void modify(Article article, String title, String body){
        article.setTitle(title);
        article.setBody(body);
        this.articleRepository.save(article);
    }

    public void delete(Article article){
        this.articleRepository.delete(article);
    }
}
