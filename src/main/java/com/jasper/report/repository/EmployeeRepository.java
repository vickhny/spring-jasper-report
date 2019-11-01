package com.jasper.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jasper.report.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
