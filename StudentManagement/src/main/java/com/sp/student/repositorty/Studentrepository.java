package com.sp.student.repositorty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sp.student.entity.StudentEntity;

public interface Studentrepository extends JpaRepository<StudentEntity, Integer> {

}
