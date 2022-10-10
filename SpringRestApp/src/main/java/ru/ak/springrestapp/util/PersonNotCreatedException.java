package ru.ak.springrestapp.util;

public class PersonNotCreatedException extends RuntimeException {

    public PersonNotCreatedException(String msg) {
        super(msg);
    }
}
