package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
@Transactional
class SearchEngineFacadeTest {

    @Autowired
    private SearchEngineFacade searchEngineFacade;

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void findEmployee() {
        //Given
        Employee employeeEmma = new Employee("Emma", "Matterhorn");
        Employee employeeJohn = new Employee("John", "Potter");
        Employee employeeMarcus = new Employee("Marcus", "Ter-Asaturow");
        Employee employeeOther = new Employee("Other", "Temporary");
        employeeDao.save(employeeEmma);
        int id = employeeEmma.getId();
        employeeDao.save(employeeJohn);
        employeeDao.save(employeeMarcus);
        employeeDao.save(employeeOther);
        //When
        List<Employee> foundEmployees = searchEngineFacade.findEmployee("%ter%");
        //Then
        assertEquals(3, foundEmployees.size(), "Three employees was found");
        assertNotEquals(0, id, "employeeEmma was saved to the database under id " + id);
    }

    @Test
    void findCompany() {
        //Given
        Company anyCo = new Company("Le");
        Company bigCo = new Company("Parole");
        Company smallCo = new Company("Lexmark");
        Company coalCo = new Company("Silesia");
        Company otherCo = new Company("Eldom");

        Employee anna = new Employee("Anna", "Dziewanna");
        anna.getCompanies().add(anyCo);
        anna.getCompanies().add(bigCo);
        anna.getCompanies().add(smallCo);
        anna.getCompanies().add(coalCo);
        anna.getCompanies().add(otherCo);
        employeeDao.save(anna);
        int id = anna.getId();
        //When
        List<Company> foundCompany = searchEngineFacade.findCompany("%le%");
        //Then
        assertNotEquals(0, id, "employee anna was saved to the database with id " + id);
        assertEquals(4, foundCompany.size(), "Found 4 companies with part of name \"le\"");
    }
}