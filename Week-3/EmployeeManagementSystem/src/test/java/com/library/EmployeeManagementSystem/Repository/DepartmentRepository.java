package com.library.EmployeeManagementSystem.Repository;

import com.library.EmployeeManagementSystem.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}

