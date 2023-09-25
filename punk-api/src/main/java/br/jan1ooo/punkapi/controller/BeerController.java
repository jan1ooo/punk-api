package br.jan1ooo.punkapi.controller;

import br.jan1ooo.punkapi.domain.model.beer.Beer;
import br.jan1ooo.punkapi.domain.service.BeerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/beers")
@Tag(name = "Beer", description = "API Beer")
public class BeerController {

    private final BeerService beerService;

    @GetMapping
    public ResponseEntity<Beer[]> initial(){
        return ResponseEntity.ok(beerService.initial());
    }

    @GetMapping("/id={id}")
    public ResponseEntity<Beer[]> searchBeer(@PathVariable Long id){
        return ResponseEntity.ok().body(beerService.searchBeer(id));
    }

    @GetMapping("/random")
    public ResponseEntity<Beer[]> random(){
        return ResponseEntity.ok().body(beerService.random());
    }

    @GetMapping("/{all}")
    public ResponseEntity<Beer[]> all(@PathVariable String all){
        return ResponseEntity.ok().body(beerService.all(all));
    }

}
