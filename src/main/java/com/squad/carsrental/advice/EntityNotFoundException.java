package com.squad.carsrental.advice;

import lombok.Value;

@Value
public class EntityNotFoundException extends RuntimeException {
    String name;
    long id;
}
