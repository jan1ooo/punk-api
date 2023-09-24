package br.jan1ooo.punkapi.controller;

import br.jan1ooo.punkapi.domain.model.beer.Beer;
import br.jan1ooo.punkapi.domain.service.BeerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/beers")
@Tag(name = "Beer", description = "API Beer")
public class BeerController {

    private final BeerService beerService;

    @GetMapping("/{id}")
    public ResponseEntity<Beer[]> searchBeer(@PathVariable Long id){
        return ResponseEntity.ok().body(beerService.searchBeer(id));
    }

    @GetMapping("/page={page}/per_page={per_page}")
    public ResponseEntity<Beer[]> page(@PathVariable Long page, @PathVariable Long per_page ){
        return ResponseEntity.ok().body(beerService.page(page, per_page));
    }

}
