package com.kp.employee.empmodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 @Data
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeModel {
 private int id;
 private String name;
 private  int age;
 private double salary;
 private String gender;
 private String department;

}
