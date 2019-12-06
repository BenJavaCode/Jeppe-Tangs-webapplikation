package com.jeppetang.webphotoapp.Repositories.Impl;

import com.jeppetang.webphotoapp.Models.Cv;
import com.jeppetang.webphotoapp.Repositories.CvRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.logging.Logger;


@Repository
public class CvRepositoryImpl implements CvRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public Cv getCv(String title) {
        return jdbcTemplate.queryForObject(
                "select * from cv where title = ?" + title,
                (resultSet, rowNum) ->
                        new Cv(
                                resultSet.getString("title"),
                                resultSet.getString("mainText"),
                                resultSet.getString("mailAddress"),
                                resultSet.getInt("phoneNumber"),
                                resultSet.getString("previousWork"),
                                resultSet.getString("cvPicture")));
    }

    @Override
    public int saveCv(Cv cv) {
        return jdbcTemplate.update(
                "insert into cv (title, mainText, mailAddress, phoneNumber, previousWork, cvPicture) VALUES (?,?,?,?,?,?)",
                cv.getTitle(), cv.getMainText(), cv.getMainText(), cv.getPhoneNumber(), cv.getPreviousWork(), cv.getCvPicture());
    }

    @Override
    public int updateCv(Cv cv) {
        return jdbcTemplate.update(
                "update cv set title = ?, mainText = ?, mailAddress = ?, phoneNumber = ?, previousWork = ?, cvPicture = ?",
                cv.getTitle(), cv.getMainText(), cv.getMainText(), cv.getPhoneNumber(), cv.getPreviousWork(), cv.getCvPicture());

    }
}


