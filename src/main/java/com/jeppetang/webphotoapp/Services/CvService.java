package com.jeppetang.webphotoapp.Services;

import com.jeppetang.webphotoapp.Models.Cv;

public interface CvService {


    void saveCv(Cv cv);
    void updateCv(Cv cv);
    Cv getCv(String title);
}
