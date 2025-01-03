package com.sp.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.sp.student.entity.StudentEntity;
import com.sp.student.service.StudentService;
import com.sp.student.studentmodel.StudentModel;

@Controller
public class StudentController {
@Autowired
StudentService studentService;
@GetMapping("/form")
public String getStudent() {
	return "student";
}
@PostMapping("/submit")
public String submit(@ModelAttribute StudentModel studentModel) {
	studentService.saveStudent(studentModel);
	return "submit";
}
@GetMapping("/students")
public String getall(Model model) {
	List<StudentEntity>student =studentService.getallstudent();
	model.addAttribute("students",student);
	return "all";
}

@GetMapping("/delete/{id}") 
public String deleteById(@PathVariable("id") int id) {
    studentService.deletestudentbyid(id);
    return "redirect:/students";
}


	
}
