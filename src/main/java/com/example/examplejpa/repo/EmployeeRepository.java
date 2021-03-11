package com.example.examplejpa.repo;

import com.example.examplejpa.entities.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Integer > {
    List<Employee> findByName (String name);
    List<Employee> findByNameStartingWith (String name);
    List<Employee> findByAgeBetween(int age,int age1);
}
