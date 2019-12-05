package com.jeppetang.webphotoapp.Repositories;

import com.jeppetang.webphotoapp.Models.ArticleDrone;
import com.jeppetang.webphotoapp.Models.ArticleVideo;

import java.util.List;

public interface ArtikelRepository {


   public  List<ArticleVideo> allAv();
   public List<ArticleDrone> allAd();

   public int saveAv(ArticleVideo art);
   public int saveAd(ArticleDrone art);

   public int updateAv(ArticleVideo art);
   public int updateAd(ArticleDrone art);

   public  int deleteAv(int id);
   public int deleteAd (int id);

   public ArticleVideo getAv(int id);
   public ArticleDrone getAd(int id);



}
