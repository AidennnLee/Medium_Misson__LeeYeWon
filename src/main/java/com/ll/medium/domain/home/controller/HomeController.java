package com.ll.medium.domain.home.controller;

import com.ll.medium.domain.article.entity.Article;
import com.ll.medium.domain.home.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final HomeService homeService;

    @GetMapping("/")
    public String home(Model model){
        List<Article> recentList = this.homeService.getRecentList().stream()
                                                    .limit(30)
                                                    .collect(Collectors.toList());
        model.addAttribute("recentList", recentList);

        return "domain/home/home";
    }
}