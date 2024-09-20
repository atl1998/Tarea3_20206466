package com.example.tarea3_gtics_20206466.controller;
import com.example.tarea3_gtics_20206466.entity.*;
import com.example.tarea3_gtics_20206466.repository.*;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    final EmployeeRepository employeeRepository;
    final JobRepository jobRepository;
    final DepartmentRepository departmentRepository;


    public EmployeeController(EmployeeRepository employeeRepository, JobRepository jobRepository, DepartmentRepository departmentRepository) {
        this.departmentRepository=departmentRepository;
        this.employeeRepository = employeeRepository;
        this.jobRepository=jobRepository;
    }


    @GetMapping("/list")
    public String listarEmpleados(Model model) {
        List<Employee> lista = employeeRepository.findAll();
        model.addAttribute("listaEmployees", lista);
        return "Employee/empleados";
    }

    /*Agregar empleado*/

    @GetMapping("/new")
    public String nuevoEmpleadoFrm(Model model) {
        model.addAttribute("listaDepartamentos",departmentRepository.findAll());
        model.addAttribute("listaJobs",jobRepository.findAll());
        return "Employee/agregarEmpleado";
    }

    @PostMapping("/save")
    public String guardarNuevoEmpleado(Employee employee, RedirectAttributes attr) {
        employeeRepository.save(employee);
        return "redirect:/employee/list";
    }

    @GetMapping("/edit")
    public String editarEmpleado(Model model,@RequestParam("id") int id){
        Optional<Employee> optEmployee=employeeRepository.findById(id);
        if(optEmployee.isPresent()){
            Employee employee= optEmployee.get();
            model.addAttribute("employee",employee);
            model.addAttribute("listaJobs",jobRepository.findAll());
            model.addAttribute("listaDepartamentos",departmentRepository.findAll());
            return "Employee/editarEmpleado";
        }else{
            return "redirect:/employee/list";
        }
    }

    @GetMapping("/delete")
    public String borrarEmpleado(Model model,
                                      @RequestParam("id") int id,
                                      RedirectAttributes attr) {

        Optional<Employee> optEmployee = employeeRepository.findById(id);

        if (optEmployee.isPresent()) {
            employeeRepository.deleteById(id);
        }
        return "redirect:/employee/list";

    }


    @PostMapping("/buscarEmpleados")
    public String buscarEmpleado(@RequestParam("searchField") String searchField,
                                      Model model) {

        List<Employee> listaEmpleados = employeeRepository.buscarEmpPorName(searchField);
        model.addAttribute("listaEmployees", listaEmpleados);

        return "Employee/empleados";
    }

}
