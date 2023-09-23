package br.jan1ooo.punkapi.controller;

import br.jan1ooo.punkapi.model.beer.Beer;
import br.jan1ooo.punkapi.service.BeerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/beers")
@Tag(name = "Beer", description = "API Beer")
public class BeerController {

    private final BeerService beerService;

    @GetMapping
    public ResponseEntity<Beer[]> AllBeers(){
        return ResponseEntity.ok().body(beerService.AllBeers());
    }
}
