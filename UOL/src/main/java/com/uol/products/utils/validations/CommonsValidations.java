package com.uol.products.utils.validations;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class CommonsValidations {

    public void validatePriceValue(Double value){
        if(value < 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ValidationsMensagens.POSITIVE_NUMBER_REQUIRED.getDescricao());
        }
    }

    public void stringIsDiffOfEmpty(String item){
        if(item.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ValidationsMensagens.POSITIVE_NUMBER_REQUIRED.getDescricao());
    }

    public void nullObject(Object objct, String label){

        if(objct == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("%s: %s",ValidationsMensagens.NULL_LABEL.getDescricao(), label));
    }
}
