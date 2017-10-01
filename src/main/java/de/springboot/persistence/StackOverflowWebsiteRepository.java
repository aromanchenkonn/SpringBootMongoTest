package de.springboot.persistence;

import de.springboot.model.StackoverflowWebsite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.cassandra.CassandraRepositoriesAutoConfiguration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface StackOverflowWebsiteRepository
        extends MongoRepository<StackoverflowWebsite, String> {

 //List<StackoverflowWebsite> findByWebsite(String website);

 //@Autowired
 //private MongoTemplate mongoTemplate;

// public List<StackoverflowWebsite> findAll() {
//  return mongoTemplate.findAll(StackoverflowWebsite.class);
 //}
}
