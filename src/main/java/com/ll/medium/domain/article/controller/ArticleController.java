package com.ll.medium.domain.article.controller;

import com.ll.medium.domain.article.entity.Article;
import com.ll.medium.domain.article.form.ArticleForm;
import com.ll.medium.domain.article.service.ArticleService;
import com.ll.medium.domain.member.entity.Member;
import com.ll.medium.domain.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class ArticleController {

    private final ArticleService articleService;
    private final MemberService memberService;

    @GetMapping("/list")
    public String list(Model model, @RequestParam(value = "page", defaultValue = "0") int page){
        Page<Article> paging = this.articleService.getList(page);
        model.addAttribute("paging", paging);

        return "domain/article/article_list";
    }

    @GetMapping("/{id}")
    public String detail(Model model, @PathVariable("id") Integer id){
        Article article = this.articleService.getArticle(id);
        model.addAttribute("article", article);

        return "domain/article/article_detail";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/write")
    public String write(ArticleForm articleForm){
        return "domain/article/article_form";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/write")
    public String write(@Valid ArticleForm articleForm, BindingResult bindingResult, Principal principal){
        if(bindingResult.hasErrors()){
            return "domain/article/article_form";
        }
        Member writer = this.memberService.getMember(principal.getName());
        this.articleService.create(articleForm.getTitle(), articleForm.getBody(), writer);

        return "redirect:/post/list";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/{id}/modify")
    public String modify(ArticleForm articleForm, @PathVariable("id") Integer id, Principal principal){
        Article article = this.articleService.getArticle(id);
        if(!article.getWriter().getUsername().equals(principal.getName())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }
        articleForm.setTitle(article.getTitle());
        articleForm.setBody(article.getBody());

        return "domain/article/article_form";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/{id}/modify")
    public String modify(@Valid ArticleForm articleForm, BindingResult bindingResult, Principal principal, @PathVariable("id") Integer id){
        if(bindingResult.hasErrors()){
            return "domain/article/article_form";
        }
        Article article = this.articleService.getArticle(id);
        if(!article.getWriter().getUsername().equals(principal.getName())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정 권한이 없습니다.");
        }
        this.articleService.modify(article, articleForm.getTitle(), articleForm.getBody());

        return String.format("redirect:/post/%s", id);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/{id}/delete")
    public String delete(Principal principal, @PathVariable("id") Integer id){
        Article article = this.articleService.getArticle(id);
        if(!article.getWriter().getUsername().equals(principal.getName())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제 권한이 없습니다.");
        }
        this.articleService.delete(article);

        return "redirect:/post/list";
    }
}
