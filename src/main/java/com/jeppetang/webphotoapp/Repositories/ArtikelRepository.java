package com.jeppetang.webphotoapp.Repositories;

import com.jeppetang.webphotoapp.Models.Article;

import java.util.List;

public interface ArtikelRepository {


    List<Article> getAllArticles();
    int save(Article art);
    int update(Article art);
    int delete(int id);
}
