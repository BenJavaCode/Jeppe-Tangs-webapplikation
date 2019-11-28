package com.jeppetang.webphotoapp.Services;

import com.jeppetang.webphotoapp.Models.ArticelDrone;
import com.jeppetang.webphotoapp.Models.ArticleVideo;
import com.jeppetang.webphotoapp.Repositories.ArtikelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtikelServiceImpl implements ArtikelService{

    @Autowired
    ArtikelRepository artikelRepository;

    @Override
    public List<ArticleVideo> getAllAv() {

        return artikelRepository.allAv();
    }

    @Override
    public List<ArticelDrone> getAllAd() {
        return artikelRepository.allAd();
    }

    @Override
    public int storeAv(ArticleVideo art) {
        return artikelRepository.saveAv(art);
    }

    @Override
    public int storeAd(ArticelDrone art) {
        return artikelRepository.saveAd(art);
    }

    @Override
    public int changeAv(ArticleVideo art) {
        return artikelRepository.updateAv(art);
    }

    @Override
    public int changeAd(ArticelDrone art) {
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
    public ArticelDrone requestAd(int id) {
        return artikelRepository.getAd(id);
    }
}
