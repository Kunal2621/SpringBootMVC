package com.kp.employee.emprepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kp.employee.empentity.EmpEntity;
@Repository

public interface EmpRepository extends JpaRepository<EmpEntity, Integer> {

}
