package ru.dream.vacationpaycalculation.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void getAverageSalary() {
        Double averageSalaryPerMonth = 3.5;
        Integer countDays = 28;
        assertNotNull(averageSalaryPerMonth / 29.3 * countDays);
    }
}