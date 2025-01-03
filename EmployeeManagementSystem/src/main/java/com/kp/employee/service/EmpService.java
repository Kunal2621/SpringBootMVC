package com.kp.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kp.employee.empentity.EmpEntity;
import com.kp.employee.empmodel.EmployeeModel;
import com.kp.employee.emprepository.EmpRepository;

import lombok.Data;

@Data
@Service

public class EmpService {
@Autowired
EmpRepository empRepository;
public void saveDetails(EmployeeModel employeeModel) {
	double hra=20.00;
	double da =10.00;
    double hravalue =employeeModel.getSalary()*hra/100;
    double davaluse =employeeModel.getSalary()*da/100;
    double finalsalary =hravalue+davaluse +employeeModel.getSalary();
    EmpEntity empEntity =new EmpEntity();
    empEntity.setName(employeeModel.getName());
    empEntity.setAge(employeeModel.getAge());
    empEntity.setFinalsalary(finalsalary);
    empEntity.setGender(employeeModel.getGender());
    empEntity.setId(employeeModel.getId());
    empEntity.setDepartment(employeeModel.getDepartment());
    empEntity.setHra(hravalue);
    empEntity.setDa(davaluse);
    empEntity.setSalary(employeeModel.getSalary());
    
    empRepository.save(empEntity);	 	
}
public List<EmpEntity>getAll(){
	List<EmpEntity>Employees=empRepository.findAll();
	return Employees;			
}
public EmpEntity SearchById(int id) {
	Optional<EmpEntity> Emp =empRepository.findById(id);
	if(Emp.isPresent()) {
		EmpEntity Employee= Emp.get();
		return Employee;
	}
	else {
		return null;
	}
}
public void deleteempbyid(int id) {
	empRepository.deleteById(id);
}
//public EmpEntity editbyid(int id) {
//	Optional<EmpEntity> employee =empRepository.findById(id);
//	if (employee.isPresent()) {
//		 return employee.get();
//	} else {
//        return null;
//	}
//     	
//}
public EmpEntity editbyid(int id) {
	Optional<EmpEntity> employee =empRepository.findById(id);
	if (employee.isPresent()) {
		 return employee.get();
	} else {
        return null;
	}
}
public EmpEntity updateemp(int id, EmployeeModel employeeModel) {
	double hra=20.00;
	double da =10.00;
    double hravalue =employeeModel.getSalary()*hra/100;
    double davaluse =employeeModel.getSalary()*da/100;
    double finalsalary =hravalue+davaluse +employeeModel.getSalary();
    EmpEntity empEntity =new EmpEntity();
    empEntity.setName(employeeModel.getName());
    empEntity.setAge(employeeModel.getAge());
    empEntity.setFinalsalary(finalsalary);
    empEntity.setGender(employeeModel.getGender());
    empEntity.setId(employeeModel.getId());
    empEntity.setDepartment(employeeModel.getDepartment());
    empEntity.setHra(hravalue);
    empEntity.setDa(davaluse);
    empEntity.setSalary(employeeModel.getSalary());
    
  return   empRepository.save(empEntity);	 	
    
	
}

}
