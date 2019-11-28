package com.jeppetang.webphotoapp.Repositories;

import com.jeppetang.webphotoapp.Models.Cv;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.logging.Logger;


@Repository
public class CvRepositoryImpl implements CvRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private final Logger log = (Logger) LoggerFactory.getLogger(this.getClass());



    @Override
    public int saveCv(Cv cv) {

        log.info("Saving Cv..");

        return jdbcTemplate.update(
                "insert into cv(title, mainText, mailAddress, phoneNumber, previousWork, cvPicture) values (?,?,?,?,?,?)"
        );


    }

    @Override
    public int updateCv(Cv cv){

        log.info("Updating Cv..");

        return jdbcTemplate.update(
                "update cv set  mainText = ?, mailAddress = ?, phoneNumber = ?, previousWork = ?, cvPicture = ? where title=?"
        );
    }


}
