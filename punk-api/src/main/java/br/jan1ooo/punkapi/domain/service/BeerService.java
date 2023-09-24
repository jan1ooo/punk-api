package br.jan1ooo.punkapi.domain.service;

import br.jan1ooo.punkapi.domain.exeption.RecordNotFoundException;
import br.jan1ooo.punkapi.domain.model.beer.Beer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class BeerService {

    public Beer[] searchBeer(Long id){
        try{
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Beer[]> rest = restTemplate
                    .getForEntity((String.format("https://api.punkapi.com/v2/beers/%s", id)), Beer[].class);
            log.info("Buscando cerveja com id: " + id);
            return rest.getBody();
        }catch (HttpClientErrorException ex){
            throw new RecordNotFoundException("Não existe cerveja com este ID: " + id);
        }
    }

    public Beer[] page(Long page, Long per_page){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Beer[]> rest = restTemplate
                .getForEntity((String.format("https://api.punkapi.com/v2/beers?page=%s&per_page=%s", page, per_page)), Beer[].class);
        log.info("Buscando com paginação Página " + page + " e quantidade por página " + per_page);
        return rest.getBody();
    }

    public Beer[] random(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Beer[]> rest = restTemplate
                .getForEntity(("https://api.punkapi.com/v2/beers/random"), Beer[].class);
        log.info("Buscando uma cerveja de forma aleatória");
        return rest.getBody();
    }

    public Beer[] all(String all){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Beer[]> rest = restTemplate
                .getForEntity((String.format("https://api.punkapi.com/v2/beers?%s", all)), Beer[].class);
        log.info("Filtro personalizado");
        return rest.getBody();
    }
}
