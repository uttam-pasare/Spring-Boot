package spring.events.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Employee {
    private String name;
    private String department;
    private Double salary;
    private Integer age;
}
