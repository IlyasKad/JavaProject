package com.travelset.laba3.exceptions;

public class EntityElementAlreadyExistsException extends RuntimeException {
    public EntityElementAlreadyExistsException(Class entityClass, Integer id) {
        super(entityClass.getName() + " with id=" + id + " Already Exists.");
    }
}
