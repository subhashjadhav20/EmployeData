package com.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Employe;

public interface EmployeRepository extends JpaRepository <Employe ,Integer> {

}
