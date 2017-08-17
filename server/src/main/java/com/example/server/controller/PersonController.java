package com.example.server.controller;

import com.example.server.domain.Person;
import com.example.server.domain.PersonResource;
import com.example.server.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created by japnica on 8/2/2017.
 */
@Controller
@RequestMapping("api/person")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonResourceAssembler personResourceAssembler;

    @RequestMapping(method= RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<PersonResource>> displayAll() throws URISyntaxException {
        List<Person> persons=personRepository.findAll();
        List<PersonResource> personResources = new ArrayList<>();
        for(Person person : persons){
            PersonResource personResource =  personToResource(person);
            personResources.add(personResource);
        }

        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.ALL);
//        headers.setContentLength(500);

        return new ResponseEntity<List<PersonResource>>(personResources, headers, HttpStatus.CREATED);
    }

    private PersonResource personToResource(Person person){
        return personResourceAssembler.toResource(person);
    }
}
