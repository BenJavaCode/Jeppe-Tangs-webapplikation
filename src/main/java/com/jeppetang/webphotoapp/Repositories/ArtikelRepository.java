package com.jeppetang.webphotoapp.Repositories;

import com.jeppetang.webphotoapp.Models.ArticelDrone;
import com.jeppetang.webphotoapp.Models.ArticleVideo;

import java.util.List;

public interface ArtikelRepository {


   public  List<ArticleVideo> allAv();
   public List<ArticelDrone> allAd();

   public int saveAv(ArticleVideo art);
   public int saveAd(ArticelDrone art);

   public int updateAv(ArticleVideo art);
   public int updateAd(ArticelDrone art);

   public  int deleteAv(int id);
   public int deleteAd (int id);

   public ArticleVideo getAv(int id);
   public ArticelDrone getAd(int id);



}
