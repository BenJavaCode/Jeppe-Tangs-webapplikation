package com.jeppetang.webphotoapp.Services;

import com.jeppetang.webphotoapp.Models.ArticleDrone;
import com.jeppetang.webphotoapp.Models.ArticleVideo;

import java.util.List;

public interface ArticleService {

    public List<ArticleVideo> getAllAv();
    public List<ArticleDrone> getAllAd();

    public int storeAv(ArticleVideo art);
    public int storeAd(ArticleDrone art);

    public int changeAv(ArticleVideo art);
    public int changeAd(ArticleDrone art);

    public  int removeAv(int id);
    public int removeAd (int id);

    public ArticleVideo requestAv(int id);
    public ArticleDrone requestAd(int id);
}
