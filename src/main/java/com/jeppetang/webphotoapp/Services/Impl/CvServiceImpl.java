package com.jeppetang.webphotoapp.Services.Impl;

import com.jeppetang.webphotoapp.Models.Cv;
import com.jeppetang.webphotoapp.Repositories.CvRepository;
import com.jeppetang.webphotoapp.Services.CvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CvServiceImpl implements CvService {

    @Autowired
    CvRepository cvRepository;

    @Override
    public void saveCv(Cv cv) {
        cvRepository.saveCv(cv);
    }

    @Override
    public void updateCv(Cv cv) {
        cvRepository.updateCv(cv);
    }

    @Override
    public Cv getCv(String title) {
        return cvRepository.getCv(title);
    }
}