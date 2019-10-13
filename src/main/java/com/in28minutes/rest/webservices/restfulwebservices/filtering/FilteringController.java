package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.google.common.collect.ImmutableMap;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue retrieveSomeBean(){
        SomeBean someBean =  new SomeBean("values1", "value2",  "value3");
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "fields");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(someBean);
        mapping.setFilters(filters);
        return mapping;
    }
    @GetMapping("/filtering-list")
    public MappingJacksonValue listRetrieveSomeBean(){
        List<SomeBean> someBean =  Arrays.asList(new SomeBean("values1", "value2",  "value3"), new SomeBean("values13", "value23",  "value34"), new SomeBean("values11", "value21",  "value443"));
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
         MappingJacksonValue mapping = new MappingJacksonValue(someBean);
         mapping.setFilters(filters);
        return mapping;
    }
    @GetMapping("/alex")
    public String alex(){
        return "ALLLLLLEXXX test";
    }

}
