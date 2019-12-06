package com.jeppetang.webphotoapp.Repositories;

import com.jeppetang.webphotoapp.Models.Cv;

import java.util.List;

public interface CvRepository {

    public Cv getCv(String title);
    public int saveCv(Cv cv);
    public int updateCv(Cv cv);
}
