package com.jeppetang.webphotoapp.Repositories;

import com.jeppetang.webphotoapp.Models.ArticelDrone;
import com.jeppetang.webphotoapp.Models.ArticleVideo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArtikelRepositoryImpl implements ArtikelRepository{


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<ArticleVideo> allAv() {
        return jdbcTemplate.query(
                "SELECT * FROM artikelVideo",
                (resultset, rownumber) ->
                        new ArticleVideo(
                                resultset.getInt("id"),
                                resultset.getString("titel"),
                                resultset.getString("paragraf"),
                                resultset.getString("video"),
                                resultset.getString("picture"),
                                resultset.getString("gif")
                        )

        );
    }

    @Override
    public List<ArticelDrone> allAd(){
        return jdbcTemplate.query(
                "SELECT * FROM artikelDrone",
                (resultSet, rownumber) ->
                        new ArticelDrone(
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

                "INSERT INTO artikelVideo(titel,paragraf,video,picture,gif) VALUES (?,?,?,?,?)",
                articleVideo.getTitle(),articleVideo.getParagraf(),articleVideo.getVideo(),articleVideo.getPicture(),articleVideo.getGif()

        );
    }

    @Override
    public int saveAd(ArticelDrone articelDrone){
        return jdbcTemplate.update(
                "INSERT INTO artikelDrone(titel,paragraf,video,gif) VALUES (?,?,?,?)",
                articelDrone.getTitel(),articelDrone.getParagraf(),articelDrone.getVideo(),articelDrone.getGif()
        );
    }


    @Override
    public int updateAv(ArticleVideo art) {

        return jdbcTemplate.update(
                "UPDATE artikelVideo SET titel=?, paragraf=?,video=?,picture=?,gif=? Where id=?",
                art.getTitle(),art.getParagraf(),art.getVideo(),art.getPicture(),art.getGif(),art.getId()

        );
    }

    @Override
    public int updateAd(ArticelDrone articelDrone){

        return jdbcTemplate.update(
                "UPDATE artikelDrone SET titel=?, paragraf=?, video=?, gif=? WHERE id=?",
                articelDrone.getTitel(),articelDrone.getParagraf(),articelDrone.getVideo(),articelDrone.getGif(),articelDrone.getId()
        );
    }

    @Override
    public int deleteAv(int id) {
        return jdbcTemplate.update(
                "DELETE FROM artikelVideo WHERE id=?", id
        );
    }

    @Override
    public int deleteAd(int id){
        return jdbcTemplate.update(
                "DELETE FROM artikelDrone WHERE id=?", id
        );
    }


    @Override
    public ArticleVideo getAv(int id) {
        return jdbcTemplate.queryForObject(
               "SELECT * FROM artikelVideo WHERE id=" +id,
                (resultSet, rownumber) ->

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
    public ArticelDrone getAd(int id){
        return jdbcTemplate.queryForObject(
                "SELECT * FROM artikelDrone WHERE id=" +id,
                (resultSet, rownumber) ->
                        new ArticelDrone(
                                resultSet.getInt("id"),
                                resultSet.getString("titel"),
                                resultSet.getString("paragraf"),
                                resultSet.getString("video"),
                                resultSet.getString("gif")
                        )

        );
    }


}
