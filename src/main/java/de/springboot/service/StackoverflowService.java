package de.springboot.service;

import com.google.common.collect.ImmutableList;
import de.springboot.model.SiteDto;
import de.springboot.model.SitesDto;
import de.springboot.model.StackoverflowWebsite;
import de.springboot.persistence.StackOverflowWebsiteRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

@Service
public class StackoverflowService {
    @Autowired
    private StackOverflowWebsiteRepository repository;
    @Autowired
    private StackExchangeClient stackExchangeClient;
    public List<StackoverflowWebsite> findAll() {
        return stackExchangeClient.getSites().stream()
                .map(this::toStackoverflowWebsite)
                .filter(this::ignoreMeta)
                .collect(collectingAndThen(toList(), ImmutableList::copyOf));
    }

    private boolean ignoreMeta(@NonNull StackoverflowWebsite stackoverflowWebsite) {
        return !stackoverflowWebsite.getId().contains("meta.");
    }


    private StackoverflowWebsite toStackoverflowWebsite(@NonNull SiteDto input){
        return new StackoverflowWebsite(
                  input.getSite_url().substring("https://".length(), input.getSite_url().length() - ".com".length())
                , input.getFavicon_url()
                , input.getSite_url()
                , input.getName()
                , input.getAudience()
        );
    }
}
