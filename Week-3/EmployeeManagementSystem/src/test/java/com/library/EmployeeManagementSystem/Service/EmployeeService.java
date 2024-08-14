package com.library.EmployeeManagementSystem.Service;

import com.library.EmployeeManagementSystem.model.Employee;
import com.library.EmployeeManagementSystem.Repository.EmployeeRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public void batchSaveEmployees(List<Employee> employees) {
        int batchSize = 25;
        for (int i = 0; i < employees.size(); i++) {
            employeeRepository.save(employees.get(i));
            if (i > 0 && i % batchSize == 0) {
                // Flush and clear to avoid memory issues
                employeeRepository.flush();
                employeeRepository.clear();
            }
        }
    }
}

