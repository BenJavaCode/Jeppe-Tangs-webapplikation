package com.jeppetang.webphotoapp.Repositories.Impl;

import com.jeppetang.webphotoapp.Models.ArticleDrone;
import com.jeppetang.webphotoapp.Models.ArticleVideo;
import com.jeppetang.webphotoapp.Repositories.ArtikelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArtikelRepositoryImpl implements ArtikelRepository {


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<ArticleVideo> allAv() {
        return jdbcTemplate.query(
                "SELECT * FROM articleVideo",
                (resultSet, rowNum) ->
                        new ArticleVideo(
                                resultSet.getInt("id"),
                                resultSet.getString("titel"),
                                resultSet.getString("paragraf"),
                                resultSet.getString("video"),
                                resultSet.getString("picture"),
                                resultSet.getString("gif")
                        )

        );
    }

    @Override
    public List<ArticleDrone> allAd(){
        return jdbcTemplate.query(
                "SELECT * FROM articleDrone",
                (resultSet, rowNum) ->
                        new ArticleDrone(
                                resultSet.getInt("id"),
                                resultSet.getString("titel"),
                                resultSet.getString("paragraf"),
                                resultSet.getString("video"),
                                resultSet.getString("gif")
                        )
        );
    }


    @Override
    public int saveAv(ArticleVideo articleVideo) {


        return jdbcTemplate.update(

                "INSERT INTO articleVideo(titel,paragraf,video,picture,gif) VALUES (?,?,?,?,?)",
                articleVideo.getTitle(),articleVideo.getParagraf(),articleVideo.getVideo(),articleVideo.getPicture(),articleVideo.getGif()

        );
    }

    @Override
    public int saveAd(ArticleDrone articleDrone){
        return jdbcTemplate.update(
                "INSERT INTO articleDrone(titel,paragraf,video,gif) VALUES (?,?,?,?)",
                articleDrone.getTitle(), articleDrone.getParagraf(), articleDrone.getVideo(), articleDrone.getGif()
        );
    }


    @Override
    public int updateAv(ArticleVideo art) {

        return jdbcTemplate.update(
                "UPDATE articleVideo SET titel=?, paragraf=?,video=?,picture=?,gif=? Where id=?",
                art.getTitle(),art.getParagraf(),art.getVideo(),art.getPicture(),art.getGif(),art.getId()

        );
    }

    @Override
    public int updateAd(ArticleDrone articleDrone){

        return jdbcTemplate.update(
                "UPDATE articleDrone SET titel=?, paragraf=?, video=?, gif=? WHERE id=?",
                articleDrone.getTitle(), articleDrone.getParagraf(), articleDrone.getVideo(), articleDrone.getGif(), articleDrone.getId()
        );
    }

    @Override
    public int deleteAv(int id) {
        return jdbcTemplate.update(
                "DELETE FROM articleVideo WHERE id=?", id
        );
    }

    @Override
    public int deleteAd(int id){
        return jdbcTemplate.update(
                "DELETE FROM articleDrone WHERE id=?", id
        );
    }


    @Override
    public ArticleVideo getAv(int id) {
        return jdbcTemplate.queryForObject(
               "SELECT * FROM articleVideo WHERE id=" +id,
                (resultSet, rowNum) ->

                        new ArticleVideo(
                                resultSet.getInt("id"),
                                resultSet.getString("titel"),
                                resultSet.getString("paragraf"),
                                resultSet.getString("video"),
                                resultSet.getString("picture"),
                                resultSet.getString("gif")
                        )


        );
    }

    @Override
    public ArticleDrone getAd(int id){
        return jdbcTemplate.queryForObject(
                "SELECT * FROM articleDrone WHERE id=" +id,
                (resultSet, rowNum) ->
                        new ArticleDrone(
                                resultSet.getInt("id"),
                                resultSet.getString("titel"),
                                resultSet.getString("paragraf"),
                                resultSet.getString("video"),
                                resultSet.getString("gif")
                        )

        );
    }


}
