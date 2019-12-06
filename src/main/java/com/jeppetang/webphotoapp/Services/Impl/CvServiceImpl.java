package com.jeppetang.webphotoapp.Services.Impl;

import com.jeppetang.webphotoapp.Models.Cv;
import com.jeppetang.webphotoapp.Repositories.CvRepository;
import com.jeppetang.webphotoapp.Services.CvService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CvServiceImpl implements CvService {

    @Autowired
    CvRepository cvRepository;

    @Override
    public List<Cv> getAllCv() {
        return cvRepository.getAllCvs();
    }

    @Override
    public void addToCv(Cv cv) {
        cvRepository.addToCv(cv);

    }

    @Override
    public void deleteFromCv(int id) {
        cvRepository.removeFromCv(id);

    }
}
