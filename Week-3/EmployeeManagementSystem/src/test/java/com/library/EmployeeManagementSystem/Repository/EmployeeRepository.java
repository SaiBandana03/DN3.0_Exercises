package com.library.EmployeeManagementSystem.Repository;

import com.library.EmployeeManagementSystem.DTO.EmployeeDTO;
import com.library.EmployeeManagementSystem.model.Employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT new com.example.employeemanagementsystem.dto.EmployeeDTO(e.id, e.name, e.email) FROM Employee e")
    List<EmployeeDTO> findAllEmployeeDTOs();

    void clear();
}

