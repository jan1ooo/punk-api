package br.jan1ooo.punkapi.domain.model.beer.ingredients;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Hop {
    private String name;
    private Amount amount;
    private String add;
    private String attribute;
}
