package com.example.tarea3_gtics_20206466.repository;
import com.example.tarea3_gtics_20206466.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByFirstName(String nombre);

    @Query(value = "select * from employees where first_name = ?1",
            nativeQuery = true)
    List<Employee> buscarEmpPorName(String nombre);

}
