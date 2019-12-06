package com.jeppetang.webphotoapp.Repositories;

import com.jeppetang.webphotoapp.Models.Cv;

import javax.validation.constraints.Max;
import java.util.List;

public interface CvRepository {


    List<Cv> getAllCvs();
    int addToCv(Cv cv);
    int removeFromCv(int id);

}
