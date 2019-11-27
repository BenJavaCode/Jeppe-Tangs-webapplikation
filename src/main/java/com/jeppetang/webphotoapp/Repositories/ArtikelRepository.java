package com.jeppetang.webphotoapp.Repositories;

import com.jeppetang.webphotoapp.Models.ArticleVideo;

import java.util.List;

public interface ArtikelRepository {


   public  List<ArticleVideo> getAllArticles();
   public int save(ArticleVideo art);
   public int update(ArticleVideo art);
   public  int delete(int id);
   public ArticleVideo getArtikel(int id);



}
