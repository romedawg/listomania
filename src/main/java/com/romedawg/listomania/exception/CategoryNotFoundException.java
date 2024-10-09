package com.romedawg.listomania.exception;

public class CategoryNotFoundException extends RuntimeException{

    public CategoryNotFoundException(String category){
        super("Category " + category + " does not exists");
    }
}
