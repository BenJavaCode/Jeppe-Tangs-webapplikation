package com.jeppetang.webphotoapp.Services;

import com.jeppetang.webphotoapp.Models.Cv;

import java.util.List;

public interface CvService {

    List<Cv> getAllCv();
    void addToCv(Cv cv);
    void deleteFromCv(int id);

}
