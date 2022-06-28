package com.demo.ser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.demo.model.Employe;
import com.demo.repo.EmployeRepository;
import com.demo.repo.Helper;

@Service
public class EmployeService {

	@Autowired
	private EmployeRepository emprepo;
	
	public void save(MultipartFile file) {
		try {
			List<Employe> employe= Helper.convertExcelToListofemploye(file.getInputStream());
			this.emprepo.saveAll(employe);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
