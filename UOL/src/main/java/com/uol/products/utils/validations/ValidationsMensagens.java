package com.uol.products.utils.validations;

public enum ValidationsMensagens {

    POSITIVE_NUMBER_REQUIRED("Campo price deve ser positivo"),
    NULL_LABEL("Campo nulo"),
    NOT_FOUND_PRODUCT("Produto não encontrado");

    private String description;


    ValidationsMensagens(String description) {
        this.description = description;
    }

    public String getDescricao() {
        return description;
    }

}
