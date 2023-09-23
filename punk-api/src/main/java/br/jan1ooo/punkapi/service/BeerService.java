package br.jan1ooo.punkapi.service;

import br.jan1ooo.punkapi.model.beer.Beer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class BeerService {

    public Beer[] AllBeers(){
        RestTemplate restTemplate = new RestTemplate();
        String URL = "https://api.punkapi.com/v2/beers";
        ResponseEntity<Beer[]> rest = restTemplate
                .getForEntity((URL), Beer[].class);
        log.info("Find All Beers");
        return rest.getBody();
    }
}
