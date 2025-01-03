package com.sp.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.sp.student.entity.StudentEntity;
import com.sp.student.repositorty.Studentrepository;
import com.sp.student.studentmodel.StudentModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Service
public class StudentService {
@Autowired
Studentrepository studentrepository;
public void saveStudent(StudentModel studentModel) {
     double avg;
     avg =(studentModel.getM1()+studentModel.getM2()+studentModel.getM3())/3;
     double totalmarks=studentModel.getM1()+studentModel.getM2()+studentModel.getM2();
     StudentEntity studentEntity=new StudentEntity();
     studentEntity.setId(studentModel.getId());
     studentEntity.setAvg(avg);
     studentEntity.setDepartment(studentModel.getDepartment());
     studentEntity.setTotalMarks(totalmarks);
     studentEntity.setName(studentModel.getName());
     studentEntity.setM1(studentModel.getM1());
     studentEntity.setM2(studentModel.getM2());
     studentEntity.setM3(studentModel.getM3());
     if (totalmarks>=33) {
		studentEntity.setPass("Pass");
	}
     else {
    	 studentEntity.setPass("Fail");
     }
     studentrepository.save(studentEntity);
}

  public List<StudentEntity> getallstudent(){
	  List<StudentEntity>students =studentrepository.findAll();
	  return students;
  }
  public void deletestudentbyid( int id) {
	 studentrepository.deleteById(id); 
  }

}
