package spring.events.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import spring.events.model.Employee;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class EmployeeService {
    @Autowired
    private ApplicationEventPublisher eventPublisher;
    public List<Employee> list(){
        List<Employee> employees = new ArrayList<>();
        employees.add(Employee.builder().name("John").build());
        employees.add(Employee.builder().name("Sam").build());
        return employees;
    }

    public void create(Employee employee){
       log.info("Employee has been created successfully {}", employee.getName());
       eventPublisher.publishEvent(employee);
    }

    @EventListener(Employee.class)
    @Async
    public void sendEmail(Employee employee){
        log.info("Sending email post employee creation.. {}", employee.getName());
    }
}
