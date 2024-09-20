package com.example.tarea3_gtics_20206466.repository;
import com.example.tarea3_gtics_20206466.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}