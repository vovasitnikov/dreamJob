package ru.dream.vacationpaycalculation.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dream.vacationpaycalculation.entity.User;
import ru.dream.vacationpaycalculation.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/calculacte")
    public ResponseEntity<Double> getAverageSalary(@RequestParam(value = "averageSalaryPerMonth") Double averageSalaryPerMonth,
                                 @RequestParam(value = "countDays") Integer countDays){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getAverageSalary(averageSalaryPerMonth, countDays));
    }

    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <List<User>> getAllUsers(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getAllUsers());
    }

    @RequestMapping(value = "/getUserById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<User>> getUserById(@RequestParam(value = "id") Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getUserById(id));
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <User> addUser(@RequestBody User newUser){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.addUser(newUser));
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)
    public ResponseEntity <User> deleteUser(@RequestParam(value = "id") Long userId){
        userService.deleteUser(userId);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(null);
    }
}