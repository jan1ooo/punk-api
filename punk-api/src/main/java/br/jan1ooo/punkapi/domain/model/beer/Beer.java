package br.jan1ooo.punkapi.domain.model.beer;

import br.jan1ooo.punkapi.domain.model.beer.ingredients.Ingredients;
import br.jan1ooo.punkapi.domain.model.beer.method.Method;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Beer {
    private Long id;
    private String name;
    private String tagline;
    private String first_brewed;
    private String description;
    private String image_url;
    private Double abv;
    private Integer ibu;
    private Integer target_fg;
    private Integer target_og;
    private Integer ebc;
    private Integer srm;
    private Double ph;
    private Integer attenuation_level;
    private Volume volume;
    private BoilVolume boil_volume;
    private Method method;
    private Ingredients ingredients;
    private List<String> food_pairing;
    private String brewers_tips;
}
