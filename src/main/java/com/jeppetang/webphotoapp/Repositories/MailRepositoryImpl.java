package com.jeppetang.webphotoapp.Repositories;

import com.jeppetang.webphotoapp.Models.Mail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class MailRepositoryImpl implements MailRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<Mail> getAllMail() {
        log.info("Fetching all mail");
        return jdbcTemplate.query(
                "select * from mail",
                (resultSet, rowNum) ->
                        new Mail(
                                resultSet.getInt("id"),
                                resultSet.getString("sender"),
                                resultSet.getString("content"),
                                resultSet.getString("date"),
                                resultSet.getInt("phoneNumber"),
                                resultSet.getString("mail")
                        )
        );
    }

    @Override
    public int saveMail(Mail mail) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public Mail findById(int id) {
        return null;
    }
}
