package com.example.examplejpa;
import com.example.examplejpa.entities.Employee;
import com.example.examplejpa.repo.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
class ExamplejpaApplicationTests {
	@Autowired
	EmployeeRepository repository;
	@Test
	void contextLoads() {
	}
	@Test
	public void testCreate(){
		Employee employee = new Employee();
		employee.setId(1);
		employee.setName("Abhishek");
		employee.setAge(23);
		employee.setLocation("new Delhi");
		repository.save(employee);
	}
	@Test
	public void testUpdate(){
	Employee employee= repository.findById(1).get();
	assertNotNull(employee);
	employee.setName("Abhi");
	repository.save(employee);
	}
	@Test
	public void testDelete(){
	repository.deleteById(1);
	}
	@Test
	public void testRead(){
		Employee employee= repository.findById(1).get();
		assertNotNull(employee);
		assertEquals("Abhi",employee.getName());
	}
	@Test
	public void testCount(){
		System.out.println("Number of records in Table: "+repository.count());
	}
	@Test
	public void testFindByName(){
		List<Employee> employees=repository.findByName("Abhishek");
		employees.forEach(e->System.out.println(e.getId()+" "+e.getLocation()));
	}
	@Test
	public void testFindByNameStartingWith(){
		List<Employee> employees=repository.findByNameStartingWith("A");
		employees.forEach(e->System.out.println(e.getName()));
	}
	@Test
	public void testFindByAgeBetween(){
		List<Employee> employees=repository.findByAgeBetween(28,32);
		employees.forEach(e->System.out.println(e.getName()));
	}
	@Test
	public void testFindAllPagingAndSortingOnAge(){
		Pageable pageable= PageRequest.of(0,3, Sort.Direction.DESC,"age");
		Page<Employee> result=repository.findAll(pageable);
		result.forEach(p->System.out.println(p.getName()));
	}
}
