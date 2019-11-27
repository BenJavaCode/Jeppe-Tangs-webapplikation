package com.jeppetang.webphotoapp.Repositories;

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
    public List<ArticleVideo> getAllArticles() {
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
    public int save(ArticleVideo articleVideo) {


        return jdbcTemplate.update(

                "INSERT INTO artikelVideo(titel,paragraf,video,picture,gif) VALUES (?,?,?,?,?)",
                articleVideo.getTitle(),articleVideo.getParagraf(),articleVideo.getVideo(),articleVideo.getPicture(),articleVideo.getGif()


        );


    }


    @Override
    public int update(ArticleVideo art) {

        return jdbcTemplate.update(
                "UPDATE artikelVideo SET titel=?, paragraf=?,video=?,picture=?,gif=?, Where id=?",
                art.getTitle(),art.getParagraf(),art.getVideo(),art.getPicture(),art.getGif(),art.getId()

        );
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update(
                "DELETE FROM artikelVideo WHERE id=?", id
        );
    }


    @Override
    public ArticleVideo getArtikel(int id) {
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



}
