package de.springboot.web;

import com.google.common.collect.ImmutableList;
import de.springboot.Application;
import de.springboot.model.StackoverflowWebsite;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.*;
/*
*
* Интеграционные тесты
* */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebIntegrationTest
public class StackoverflowControllerTestIT {
    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private MongoTemplate mongoTemplate;
    @Before
    public void before(){
        mongoTemplate.dropCollection(StackoverflowWebsite.class);
        mongoTemplate.save(new StackoverflowWebsite(
                "website1"
                , "icon"
                , "website"
                , "title"
                , "description"));
        mongoTemplate.save(new StackoverflowWebsite(
                "website2"
                , "icon"
                , "website"
                , "title"
                , "description"));
    }
    @Test
    public void getListOfProviders() throws Exception {
        ResponseEntity<List<StackoverflowWebsite>> responseEntity =
        restTemplate.exchange("http://localhost:8882/api/stackoverflow"
                , HttpMethod.GET
                , null
                , new ParameterizedTypeReference<List<StackoverflowWebsite>>() {
                });

        List<StackoverflowWebsite> actualListOfProviders = responseEntity.getBody();
        //validate
        assertThat(actualListOfProviders.size(), is(2));
        List<String> actualId = actualListOfProviders.stream()
                .map(stackoverflowWebsite -> stackoverflowWebsite.getId())
                .collect(collectingAndThen(toList(), ImmutableList::copyOf));
        assertThat(actualId, containsInAnyOrder("website1", "website2"));

        /*
        *
        *   валидируем по названию id в БД,
        *   если нет совпадения, то будет сообщение
        *
        *   java.lang.AssertionError:
        *   Expected: iterable over ["website1", "website3"] in any order
        *   but: Not matched: "website2"
	    *   at org.hamcrest.MatcherAssert.assertThat(MatcherAssert.java:20)
        *
        * */
    }
}