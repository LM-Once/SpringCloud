package com.it.controller;

import com.alibaba.fastjson.JSON;
import com.it.common.activemq.MqProducer;
import com.it.domain.Person;
import com.it.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    MqProducer mqProducer;



    @RequestMapping(value = "hello")
    public String helloWorld(String name){
        System.out.println(name);

        return name +"--SUCCESS";
    }

    @RequestMapping(value = "/api/person" ,method = RequestMethod.GET)
    public List<Person> findAll(){
        return personService.findAll();
    }

    @RequestMapping(value = "/api/person/{id}", method = RequestMethod.GET)
    public Person findOne(@PathVariable("id") Integer id){
        Person per = personService.findOne(id);
        String strPerson = JSON.toJSONString(per);
        mqProducer.sendMessage(strPerson);
        return personService.findOne(id);
    }

    @RequestMapping(value = "/api/person", method = RequestMethod.POST)
    public void savePerson(@RequestBody Person person){
        personService.savePerson(person);
    }

    @RequestMapping(value = "/api/person", method = RequestMethod.PUT)
    public void updatePerson(@RequestBody Person person){
        personService.updatePerson(person);
    }

    @RequestMapping(value = "/api/person/{id}", method = RequestMethod.DELETE)
    public void deletePerson(@PathVariable("id") Integer id){
        personService.deletePerson(id);
    }
}
