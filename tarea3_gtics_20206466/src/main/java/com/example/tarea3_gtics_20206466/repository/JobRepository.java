package com.example.tarea3_gtics_20206466.repository;
import com.example.tarea3_gtics_20206466.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, String> {

}
