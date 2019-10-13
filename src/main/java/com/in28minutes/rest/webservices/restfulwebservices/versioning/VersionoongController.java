package com.in28minutes.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionoongController {

    @GetMapping(value = "/person/param", params ="version=1")
    public PersonV1 personV1(){
        return new PersonV1("Bob Charlie");
    }
    @GetMapping(value = "/person/param", params ="version=2")
    public PersonV2 personV2(){
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    //2nd way
    @GetMapping(value = "/person/header", headers ="Xversion=1")
    public PersonV1 headerV1(){
        return new PersonV1("Bob Charlie");
    }
    @GetMapping(value = "/person/header", headers ="Xversion=2")
    public PersonV2 headerV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    //3d way
    @GetMapping(value = "/person/produces", produces ="application/vnd.ompany.app-v1+json")
    public PersonV1 producesV1(){
        return new PersonV1("Bob Charlie");
    }
    @GetMapping(value = "/person/produces", produces ="application/vnd.ompany.app-v2+json")
    public PersonV2 producesV2(){
        return new PersonV2(new Name("Bob", "Charlie"));
    }
}
