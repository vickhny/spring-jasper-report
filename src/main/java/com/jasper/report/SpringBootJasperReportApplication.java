package com.jasper.report;

import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jasper.report.entity.Employee;
import com.jasper.report.repository.EmployeeRepository;
import com.jasper.report.service.ReportService;

import java.io.FileNotFoundException;
import java.util.List;

@SpringBootApplication
@RestController
public class SpringBootJasperReportApplication {

    @Autowired
    private EmployeeRepository repository;
    @Autowired
    private ReportService service;

    @GetMapping("/getEmployees")
    public List<Employee> getEmployees() {

        return repository.findAll();
    }

    @GetMapping("/report/{format}")
    public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
        return service.exportReport(format);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJasperReportApplication.class, args);
    }

}
