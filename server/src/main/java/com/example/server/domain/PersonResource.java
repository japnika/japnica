package com.example.server.domain;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by japnica on 8/2/2017.
 */
public class PersonResource extends ResourceSupport {

    @JsonUnwrapped
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
