package com.kp.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.kp.employee.empentity.EmpEntity;
import com.kp.employee.empmodel.EmployeeModel;
import com.kp.employee.service.EmpService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class controller {
	@Autowired
	EmpService empService ;
   @GetMapping("/emp")
   public String empForm() {
	   return "emp_form";
   }
   @PostMapping("/addEmployee")
   public String getEmp(EmployeeModel employeeModel) {
	   empService.saveDetails(employeeModel);
	   System.out.println(employeeModel);
	   return "final";
   }
   @GetMapping("/allemp")
   public String getAllEmp(Model model) {
	 List<EmpEntity>Employes =empService.getAll();
	 model.addAttribute("Emplpoys",Employes);
       return "getAllEmp";
   }
   @GetMapping("/search")
   public String searchbyid() {
	   return "SearchbyId";
   }
   @PostMapping("/searchEmpById")
   public String searchbyid(@RequestParam int id, Model model ) {
	   EmpEntity employee =empService.SearchById(id);
	   model.addAttribute("employee", employee);
	   return "SearchbyId";
   }
   @GetMapping("/delete/{id}")
   public String deletebyId( @PathVariable int id) {
	   empService.deleteempbyid(id);
	   return "redirect:/allemp";
   }
   @GetMapping("/edit/{id}")
   public String editbyid(@PathVariable int id,Model model) {
	  EmpEntity employee = empService.editbyid(id);
	  model.addAttribute("id", id);
	  model.addAttribute("employee", employee);
	   return "edit";
   }
   @PostMapping("/employeeupdate/{id}")
   public String updateemp(@PathVariable int id ,EmployeeModel employeeModel) {
	   EmpEntity employee =empService.updateemp(id,employeeModel);
	   return "redirect:/allemp";
   }
   
}
   