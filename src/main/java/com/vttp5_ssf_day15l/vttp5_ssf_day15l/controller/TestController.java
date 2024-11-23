// package com.vttp5_ssf_day15l.vttp5_ssf_day15l.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.ResponseBody;

// import com.vttp5_ssf_day15l.vttp5_ssf_day15l.model.Person;
// import com.vttp5_ssf_day15l.vttp5_ssf_day15l.service.PersonService;

// @Controller
// @RequestMapping("/tests")
// public class TestController {

//     @Autowired
//     PersonService personService;

//     @ResponseBody
//     @GetMapping("/add")
//     public String addPerson() {
//         Person p = new Person(1, "darryl", "darryl@nus.edu.sg");
//         personService.addPerson("persons", p);
//         p = new Person(2, "john", "john@nus.edu.sg");
//         personService.addPerson("persons", p);
//         p = new Person(3, "mary", "mary@nus.edu.sg");
//         personService.addPerson("persons", p);

//         return "added persons successfully";
//     }

//     @ResponseBody
//     @GetMapping("/persons")
//     public List<Person> personFindAll() {
//         return personService.findAll("persons");
//     }

//     // @ResponseBody
//     // @GetMapping("/delete")
//     // public void deletePerson(Person person) {
//     //     personService.deleteById("persons", person);
//     // }
// }
