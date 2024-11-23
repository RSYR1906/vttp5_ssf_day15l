package com.vttp5_ssf_day15l.vttp5_ssf_day15l.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vttp5_ssf_day15l.vttp5_ssf_day15l.model.Person;
import com.vttp5_ssf_day15l.vttp5_ssf_day15l.service.PersonService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("")
    public String personListPage(Model model) {
        model.addAttribute("persons", personService.findAll("persons"));
        return "personslist";
    }

    @GetMapping("/create")
    public String showCreatePage(Model model) {
        model.addAttribute("persons", new Person());
        return "personForm";
    }

    @PostMapping("/create")
    public String createPersonRecord(@Valid @ModelAttribute("persons") Person person, BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            return "personForm";
        }
        personService.addPerson("persons", person);
        return "redirect:/persons";
    }

    @GetMapping("/delete/{person-id}")
    public String deletePersonRecord(@PathVariable("person-id") String personId) {
        // logic here (currently, simply do it here)
        // or shift the logic to service layer
        List<Person> persons = personService.findAll("persons");
        Person foundPerson = persons.stream().filter(p -> p.getId().equals(Integer.parseInt(personId))).findFirst()
                .get();
        System.out.println("foundPerson : " + foundPerson.toString());

        personService.delete("persons", foundPerson);

        return "redirect:/persons";
    }
}
