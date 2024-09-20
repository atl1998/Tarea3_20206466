package com.example.tarea3_gtics_20206466.entity;
import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="department_id")
    private Integer departmentId;

    @Column(name="department_name", nullable=false)
    private String departmentName;

    @ManyToOne
    @JoinColumn(name="location_id", nullable=false)
    private Location location;
}
