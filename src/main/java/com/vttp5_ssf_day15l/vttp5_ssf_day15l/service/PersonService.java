package com.vttp5_ssf_day15l.vttp5_ssf_day15l.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vttp5_ssf_day15l.vttp5_ssf_day15l.model.Person;
import com.vttp5_ssf_day15l.vttp5_ssf_day15l.repo.ListRepo;

@Service
public class PersonService {

    @Autowired
    ListRepo personRepo;

    List<Person> persons = new ArrayList<>();

    public void addPerson(String redisKey, Person person) {
        personRepo.rightPush(redisKey, person.toString());
    }

    public List<Person> findAll(String redisKey) {
        List<String> listData = personRepo.getList(redisKey);
        List<Person> persons = new ArrayList<>();

        for (String data : listData) {
            try {
                // Split the string by comma
                String[] fields = data.split(",");

                // Validate that all fields are present
                if (fields.length == 3) {
                    Integer id = Integer.parseInt(fields[0].trim()); // First field: id
                    String fullName = fields[1].trim(); // Second field: fullName
                    String email = fields[2].trim(); // Third field: email

                    System.out.println(id);
                    System.out.println(fullName);
                    System.out.println(email);

                    // Add new Person to the list
                    persons.add(new Person(id, fullName, email));
                } else {
                    System.err.println("Invalid data format: " + data);
                }
            } catch (NumberFormatException e) {
                System.err.println("Error parsing person ID: " + data + " - " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Unexpected error parsing data: " + data + " - " + e.getMessage());
            }
        }

        return persons;
    }

    public Boolean delete(String redisKey, Person person) {
        return personRepo.deleteItem(redisKey, person);
    }
}