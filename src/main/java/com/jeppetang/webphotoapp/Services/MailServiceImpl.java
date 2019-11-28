package com.jeppetang.webphotoapp.Services;

import com.jeppetang.webphotoapp.Models.Mail;
import com.jeppetang.webphotoapp.Repositories.MailRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.amazonaws.regions.ServiceAbbreviations.Email;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    MailRepository mailRepository;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<Mail> fetchAllMails() {
        return mailRepository.getAllMail();
    }

    @Override
    public void saveMail(Mail mail) {
        mailRepository.saveMail(mail);
    }

    @Override
    public void delete(int id) {
        mailRepository.delete(id);
    }

    @Override
    public Mail findById(int id){
        return mailRepository.findById(id);

    }
}
