package com.jeppetang.webphotoapp.Repositories;

import com.jeppetang.webphotoapp.Models.Cv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CvRepositoryImpl implements CvRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int saveCv(Cv cv) {

        return jdbcTemplate.update(
                "insert into cv(title, mainText, mailAddress, phoneNumber, previousWork, cvPicture) values (?,?,?,?,?,?)"
        );


    }

    @Override
    public int updateCv(Cv cv){

        return jdbcTemplate.update(
                "update cv set  mainText = ?, mailAddress = ?, phoneNumber = ?, previousWork = ?, cvPicture = ? where title=?"
        );
    }


}
