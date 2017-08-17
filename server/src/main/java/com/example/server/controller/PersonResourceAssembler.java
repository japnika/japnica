package com.example.server.controller;

import com.example.server.domain.Person;
import com.example.server.domain.PersonResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by japnica on 8/2/2017.
 */
@Component
public class PersonResourceAssembler extends ResourceAssemblerSupport<Person, PersonResource> {

    public PersonResourceAssembler(){
        super(PersonController.class, PersonResource.class);
    }
    @Override
    public PersonResource toResource(Person person) {
        PersonResource personResource = createResourceWithId(person.getId(), person);
        Link link = ControllerLinkBuilder.linkTo(PersonController.class).withRel("people");
//        Link link = ControllerLinkBuilder.linkTo(methodOn(PersonController.class).displayAll(person.getId())).withRel("invoice");
        personResource.setPerson(person);
        personResource.add(link);

        return personResource;
    }
}
