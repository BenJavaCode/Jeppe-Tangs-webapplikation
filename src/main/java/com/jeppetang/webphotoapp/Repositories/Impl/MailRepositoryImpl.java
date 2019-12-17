package com.jeppetang.webphotoapp.Repositories.Impl;

import com.jeppetang.webphotoapp.Models.Mail;
import com.jeppetang.webphotoapp.Repositories.MailRepository;
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

    /**
     * Denne metode vælger alle columns fra mail hvor status ikke er 4(4 er hvis det er en Admin besked)
     * @return Metoden returnere disse som en liste.
     */
    @Override
    public List<Mail> getAllMail() {
        log.info("Fetching all mail..");
        return jdbcTemplate.query(
                "select* from mail WHERE status !=4",
                (resultSet, rowNum) ->
                        new Mail(
                                resultSet.getInt("id"),
                                resultSet.getString("sender"),
                                resultSet.getString("content"),
                                resultSet.getString("date"),
                                resultSet.getInt("phoneNumber"),
                                resultSet.getString("mail"),
                                resultSet.getInt("status")
                        )
        );
    }

    @Override
    public int saveMail(Mail mail) {
        log.info("Saving mail..");
        return jdbcTemplate.update(
                "insert into mail(sender, content, date, phoneNumber, mail,status) VALUES (?,?,?,?,?,?)",
                mail.getSender(), mail.getContent(), mail.getDate(), mail.getPhoneNumber(), mail.getMail(),mail.getStatus());
    }

    @Override
    public int delete(int id) {
        log.info("Deleting mail..");
        return jdbcTemplate.update(
                "delete from mail where id = ?",
                id);

    }

    @Override
    public Mail findById(int id) {
        log.info("Finding mail..");
        return jdbcTemplate.queryForObject("select * from mail where id = ?",
                new Object[]{id}, (resultSet, rowNum) ->
                        new Mail(
                                resultSet.getInt("id"),
                                resultSet.getString("sender"),
                                resultSet.getString("content"),
                                resultSet.getString("date"),
                                resultSet.getInt("phoneNumber"),
                                resultSet.getString("mail"),
                                resultSet.getInt("status")
                        ));

    }

    @Override
    public List<Mail> findByMail(String mail) {
        log.info("Fetching all mail..");
        return jdbcTemplate.query(
                "select* from mail WHERE mail = ?",
                new Object[]{mail},  (resultSet, rowNum) ->
                        new Mail(
                                resultSet.getInt("id"),
                                resultSet.getString("sender"),
                                resultSet.getString("content"),
                                resultSet.getString("date"),
                                resultSet.getInt("phoneNumber"),
                                resultSet.getString("mail"),
                                resultSet.getInt("status")
                        )
        );
    }


    /**
     * Denne metode vælger alt fra mail hvor status er 0(ulæst kundebesked) og bruger count til at tælle disse,
     * herefter sættes en vatiabel lig med dette reultat.
     * @return metoden returnere unaswered, som har værdien der svarer til antallet af ulæste beskeder.
     */
    @Override
    public int countUnseen(){

        log.info("counting unseen..");
        String sql = "SELECT count(*) AS NUMBEROFCOLUMNS FROM mail WHERE status = 0";
        int unanswered = jdbcTemplate.queryForObject(sql, Integer.class);

        return unanswered;
    }

    /**
     * Denne metode tager fra controlleren der bruger den indirekte, parametret mail
     * og fra answered metoden i mailServiceImpl int'en 1(svarende til en læst kundebesked)
     * hernest opdateres en kollone der har det samme id som mailen fra parametret,
     * og status bliver sat til int'en fra answred(1)
     * @param mail1
     * @param sec
     * @return
     */
    @Override
    public int flipStatus(Mail mail1, int sec){
        log.info("flipping status to 1(seen)");

        return jdbcTemplate.update(
                "UPDATE mail SET status=? WHERE id=?",
        sec,mail1.getId()
        );
    }
}