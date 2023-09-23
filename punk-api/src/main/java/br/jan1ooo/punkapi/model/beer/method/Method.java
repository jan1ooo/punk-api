package br.jan1ooo.punkapi.model.beer.method;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Method {
    private List<MashTemp> mash_temp;
    private Fermentation fermentation;
    private String twist;
}