package com.bridgelabz.GreetingApp.cotroller;

import com.bridgelabz.GreetingApp.model.Greeting;
import com.bridgelabz.GreetingApp.model.User;
import com.bridgelabz.GreetingApp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GreetingController{

    @Autowired
    private IGreetingService greetingService;
     @GetMapping("/home")
     public Greeting greeting(@RequestParam(value = "firstName", defaultValue = "World") String firstName,
                              @RequestParam(value = "lastName", defaultValue = "") String lastName) {
         User user = new User();user.setFirstName(firstName);user.setLastName(lastName);
         return greetingService.addGreeting(user);
     }

    // @return lis of objects
    @GetMapping("/all")
    public List<Greeting> getAll(){
        return greetingService.getAll();
    }

    @GetMapping("/path/{id}")
    public Greeting getGreetingById(@PathVariable Long id){
        return greetingService.getGreetingById(id);
    }
    /**
     *
     * @param id
     * @param name
     * @return returns edited json object
     */
    @PutMapping("/edit/{id}")
    public Greeting editGreetingById(@PathVariable long id, @RequestParam String name){
        return greetingService.editGreetingById(id, name);
    }

    /**
     *
     * @param id
     * @return returns list of greetings remaining after deletion
     */
    @DeleteMapping("/delete/{id}")
    public List<Greeting> deleteGreetingById(@PathVariable Long id){
        return greetingService.deleteGreetingById(id);
    }

    }



