package com.example_spring.blog.controllers;

import com.example_spring.blog.models.Article;
import com.example_spring.blog.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class BlogController {

    // todo https://www.youtube.com/watch?v=R3YNPm7ZmYY

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/blog")
    public String blogMain(Model model) {
        Iterable<Article> articles = articleRepository.findAll();
        model.addAttribute("articles", articles);
        return "blog-main";
    }

    @GetMapping("/blog/add")
    public String blogAdd(Model model) {
        return "blog-add";
    }

    @PostMapping("/blog/add")
    public String blogArticleAdd(@RequestParam String title,
                              @RequestParam String anons,
                              @RequestParam String full_text,
                              Model model) {
        Article article = new Article(title, anons, full_text);
        articleRepository.save(article);
        return "redirect:/blog";
    }

    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable(value = "id") long id, Model model) {
        if (!articleRepository.existsById(id)) {
            return "redirect:/blog";
        }
        Optional<Article> article = articleRepository.findById(id);
        ArrayList<Article> res = new ArrayList<>();
        article.ifPresent(res::add);
        model.addAttribute("article", res);
        return "blog-details";
    }

    @GetMapping("/blog/{id}/edit")
    public String blogDetailsEdit(@PathVariable(value = "id") long id, Model model) {
        if (!articleRepository.existsById(id)) {
            return "redirect:/blog";
        }
        Optional<Article> article = articleRepository.findById(id);
        ArrayList<Article> res = new ArrayList<>();
        article.ifPresent(res::add);
        model.addAttribute("article", res);
        return "blog-edit";
    }

    @PostMapping("/blog/{id}/edit")
    public String blogArticleUpdate(@PathVariable(value = "id") long id,
                                 @RequestParam String title,
                                 @RequestParam String anons,
                                 @RequestParam String full_text,
                                 Model model) throws Exception {
        Article article = articleRepository.findById(id).orElseThrow(() -> new Exception("Article not found - " + id));
        article.setTitle(title);
        article.setAnons(anons);
        article.setFull_text(full_text);
        articleRepository.save(article);
        return "redirect:/blog";
    }

    @PostMapping("/blog/{id}/delete")
    public String blogArticleDelete(@PathVariable(value = "id") long id,
                                 Model model) throws Exception {
        Article article = articleRepository.findById(id).orElseThrow(() -> new Exception("Article not found - " + id));
        articleRepository.delete(article);
        return "redirect:/blog";
    }

}
