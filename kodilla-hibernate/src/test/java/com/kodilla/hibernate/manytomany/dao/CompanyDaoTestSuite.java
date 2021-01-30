package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class CompanyDaoTestSuite {
    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMasters = new Company("Data Masters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMasters.getEmployees().add(stephanieClarckson);
        dataMasters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMasters);
        lindaKovalsky.getCompanies().add(dataMasters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMasters);
        int dataMastersId = dataMasters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        try {
            assertNotEquals(0, softwareMachineId);
            assertNotEquals(0, dataMastersId);
        //    assertNotEquals(0, greyMatterId);
        } catch (Exception e) {
            //do nothing
        } finally {
            //CleanUp
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMastersId);
            companyDao.deleteById(greyMatterId);
        }
    }

    @Test
    void testSearchEmployeeWithGivenName() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");
        Employee ralphSmith = new Employee("Ralph", "Smith");
        Employee emmaClarckson = new Employee("Emma", "Clarckson");
        Employee johnKovalsky = new Employee("John", "Kovalsky");

        employeeDao.save(johnKovalsky);
        int johnKovalskyId = johnKovalsky.getId();
        employeeDao.save(johnSmith);
        int johnSmithId = johnSmith.getId();
        employeeDao.save(stephanieClarckson);
        int stephanieClarcksonId = stephanieClarckson.getId();
        employeeDao.save(lindaKovalsky);
        int lindaKovalskyId = lindaKovalsky.getId();
        employeeDao.save(ralphSmith);
        int ralphSmithId = ralphSmith.getId();
        employeeDao.save(emmaClarckson);
        int emmaClarcksonId = emmaClarckson.getId();

        //When
        List<Employee> employees = employeeDao.searchEmployeeWithGivenName("Smith");

        //Then
        try {
            assertEquals(2, employees.size());
        } finally {
            //CleanUp
            employeeDao.deleteById(johnKovalskyId);
            employeeDao.deleteById(johnSmithId);
            employeeDao.deleteById(stephanieClarcksonId);
            employeeDao.deleteById(lindaKovalskyId);
            employeeDao.deleteById(ralphSmithId);
            employeeDao.deleteById(emmaClarcksonId);
        }
    }

    @Test
    void testSelectCompaniesWhoseNameBeginsWith() {
        //Given
        Company softwareMachine = new Company("Software Machine");
        Company dataMasters = new Company("Data Masters");
        Company greyMatter = new Company("Grey Matter");
        Company softwareHouse = new Company("Software House");
        Company geckoDynamics = new Company("Gecko Dynamics");
        Company softwareMill = new Company("SoftwareMill");
        companyDao.save(softwareMachine);
        companyDao.save(dataMasters);
        companyDao.save(greyMatter);
        companyDao.save(softwareHouse);
        companyDao.save(geckoDynamics);
        companyDao.save(softwareMill);
        int softwareMachineId = softwareMachine.getId();
        int dataMastersId = dataMasters.getId();
        int greyMatterId = greyMatter.getId();
        int softwareHouseId = softwareHouse.getId();
        int geckoDynamicsId = geckoDynamics.getId();
        int softwareMillId = softwareMill.getId();

        //When
        List<Company> companies = companyDao.selectCompaniesWhoseNameBeginsWith("Sof");

        //Then
        try {
            assertEquals(3, companies.size());
        } finally {
            //CleanUp
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMastersId);
            companyDao.deleteById(greyMatterId);
            companyDao.deleteById(softwareHouseId);
            companyDao.deleteById(geckoDynamicsId);
            companyDao.deleteById(softwareMillId);
        }
    }
}
