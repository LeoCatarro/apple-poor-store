package com.example.poorstore.controller;

import com.example.poorstore.models.Person;
import com.example.poorstore.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/")
public class MainController
{
    @Autowired
    private PersonRepository personRepository;

    //@ResponseBody -> return is a Response not a view name
    @PostMapping(path="/register")      //shorcut para @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody String addPerson(@RequestParam String username, @RequestParam String password)
    {
        Person p = new Person(username, password);
        p.setUsername(username);
        p.setPassword(password);

        return "Saved";
    }

    @GetMapping(path="/all")        //shortcut para @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Iterable<Person> getAllPersons() {
        return personRepository.findAll();
    }
}
