package com.jeppetang.webphotoapp.Repositories.Impl;

import com.jeppetang.webphotoapp.Models.Cv;
import com.jeppetang.webphotoapp.Repositories.CvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CvRepositoryImpl implements CvRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Cv> getAllCvs() {
        return jdbcTemplate.query(

                "select * from cv",
                (resultSet, rowNum) ->
                        new Cv(
                                resultSet.getInt("id"),
                                resultSet.getInt("year"),
                                resultSet.getString("title"),
                                resultSet.getString("role")
                        ));
    }

    @Override
    public int addToCv(Cv cv) {
        return jdbcTemplate.update(
                "insert into cv(year, title, role) VALUE (?,?,?)",
                cv.getYear(), cv.getTitle(), cv.getRole());
    }

    @Override
    public int removeFromCv(int id) {
        return jdbcTemplate.update(
                "delete from cv where id = ?", id);
    }
}