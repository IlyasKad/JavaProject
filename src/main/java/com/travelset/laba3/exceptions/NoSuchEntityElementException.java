package com.travelset.laba3.exceptions;

import java.util.NoSuchElementException;

public class NoSuchEntityElementException extends NoSuchElementException {
    public NoSuchEntityElementException(Class entityClass, Integer id) {
        super(entityClass.getName() + " with id=" + id + " was not found.");
    }
}
