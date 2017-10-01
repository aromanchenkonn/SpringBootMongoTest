package de.springboot.web;

import de.springboot.service.StackoverflowService;
import de.springboot.model.StackoverflowWebsite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
* т.к. используем рест контроллер,
* то все методы класса - это response body и
* потому дополнительная аннотация @ResponceBody
* возле метода не нужна
* */
@RestController
@RequestMapping("/api/stackoverflow")
public class StackoverflowController {
    @Autowired
    private StackoverflowService stackoverflowService;
    @RequestMapping
    public List<StackoverflowWebsite> getListOfProviders(){
        return stackoverflowService.findAll();
    }

}
