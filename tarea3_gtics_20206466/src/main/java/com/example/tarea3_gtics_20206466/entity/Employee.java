package com.example.tarea3_gtics_20206466.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employee_id", nullable=false)
    private Integer employeeId;

    @Column(name="first_name", nullable=false)
    private String firstName;

    @Column(name="last_name", nullable=false)
    private String lastName;

    @Column(name="email", nullable=false)
    private String email;

    @Column(name="salary", nullable=false)
    private float salary;

    @Column(name = "hire_date")
    private LocalDate hireDate;

    // Método que se ejecuta antes de insertar en la base de datos
    @PrePersist
    public void prePersist() {
        this.hireDate = LocalDate.now();  // Asigna la fecha actual solo si hireDate es null
    }


    @ManyToOne
    @JoinColumn(name="department_id")
    private Department department;

    //relación con la tabla jobs
    @ManyToOne
    @JoinColumn(name="job_id")
    private Job job;

}


