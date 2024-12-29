package com.kp.employee.empentity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name = "EMP")
public class EmpEntity {
	@Id
	 private int id;
	 private String name;
	 private  int age;
	 private double salary;
	 private String gender;
	 private String department;
	 private double hra;
	 private double da;
	 private double finalsalary;
}
