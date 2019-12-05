package com.jeppetang.webphotoapp.Services.Impl;

import com.jeppetang.webphotoapp.Models.ArticleDrone;
import com.jeppetang.webphotoapp.Models.ArticleVideo;
import com.jeppetang.webphotoapp.Repositories.ArtikelRepository;
import com.jeppetang.webphotoapp.Services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArtikelRepository artikelRepository;

    @Override
    public List<ArticleVideo> getAllAv() {

        return artikelRepository.allAv();
    }

    @Override
    public List<ArticleDrone> getAllAd() {
        return artikelRepository.allAd();
    }

    @Override
    public int storeAv(ArticleVideo art) {
        return artikelRepository.saveAv(art);
    }

    @Override
    public int storeAd(ArticleDrone art) {
        return artikelRepository.saveAd(art);
    }

    @Override
    public int changeAv(ArticleVideo art) {
        return artikelRepository.updateAv(art);
    }

    @Override
    public int changeAd(ArticleDrone art) {
        return artikelRepository.updateAd(art);
    }

    @Override
    public int removeAv(int id) {
        return artikelRepository.deleteAv(id);
    }

    @Override
    public int removeAd(int id) {
        return artikelRepository.deleteAd(id);
    }

    @Override
    public ArticleVideo requestAv(int id) {
        return artikelRepository.getAv(id);
    }

    @Override
    public ArticleDrone requestAd(int id) {
        return artikelRepository.getAd(id);
    }
}
