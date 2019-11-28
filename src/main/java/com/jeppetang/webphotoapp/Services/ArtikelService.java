package com.jeppetang.webphotoapp.Services;

import com.jeppetang.webphotoapp.Models.ArticelDrone;
import com.jeppetang.webphotoapp.Models.ArticleVideo;

import java.util.List;

public interface ArtikelService {

    public List<ArticleVideo> getAllAv();
    public List<ArticelDrone> getAllAd();

    public int storeAv(ArticleVideo art);
    public int storeAd(ArticelDrone art);

    public int changeAv(ArticleVideo art);
    public int changeAd(ArticelDrone art);

    public  int removeAv(int id);
    public int removeAd (int id);

    public ArticleVideo requestAv(int id);
    public ArticelDrone requestAd(int id);
}
