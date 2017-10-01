package de.springboot.service;

import de.springboot.model.StackoverflowWebsite;
import de.springboot.persistence.StackOverflowWebsiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class StackoverflowService {
    @Autowired
    private StackOverflowWebsiteRepository repository;


        private static List<StackoverflowWebsite> items = new ArrayList<>();
//    static {
//        items.add(
//                new StackoverflowWebsite(
//                        "#1"
//                        , "https://www.santouka.co.jp/wp/wp-content/themes/santouka/img/home/icon-mark.png"
//                        , "http://www.google.com"
//                        , "google"
//                        , "google home page"));
//
//        items.add(
//                new StackoverflowWebsite(
//                        "#2"
//                        , "https://www.santouka.co.jp/wp/wp-content/themes/santouka/img/home/icon-mark.png"
//                        , "http://www.yandex.ru"
//                        , "yandex"
//                        , "yandex home page"));
//
//        items.add(
//                new StackoverflowWebsite(
//                        "#3"
//                        , "https://www.santouka.co.jp/wp/wp-content/themes/santouka/img/home/icon-mark.png"
//                        , "http://www.mail.ru"
//                        , "mail.ru"
//                        , "mail.ru home page"));
//
//        items.add(
//                new StackoverflowWebsite(
//                        "#4"
//                        , "https://www.santouka.co.jp/wp/wp-content/themes/santouka/img/home/icon-mark.png"
//                        , "https://www.sputnik.ru/"
//                        , "sputnik"
//                        , "sputnik home page"));
//
//        items.add(
//                new StackoverflowWebsite(
//                        "#5"
//                        , "https://www.santouka.co.jp/wp/wp-content/themes/santouka/img/home/icon-mark.png"
//                        , "https://www.rambler.ru/"
//                        , "rambler"
//                        , "rambler home page"));
//
//    }
//
//    @PostConstruct
//    public void init(){
//        repository.save(items);
//    }


    public List<StackoverflowWebsite> findAll() {
        return repository.findAll();
    }
}
