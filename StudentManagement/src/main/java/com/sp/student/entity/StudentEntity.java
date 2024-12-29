package com.sp.student.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentEntity {
@Id
private int id;
private String name;
private int m1;
private int m2;
private int m3;
private double avg;
private String pass;
private String department;
private double totalMarks;

}
