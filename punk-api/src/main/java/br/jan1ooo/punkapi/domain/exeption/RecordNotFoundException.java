package br.jan1ooo.punkapi.domain.exeption;

public class RecordNotFoundException extends RuntimeException{
    public RecordNotFoundException(String msg){
        super(msg);
    }
}
