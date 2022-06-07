package org.sid.metier;

import java.util.List;

import org.sid.dao.EmployesRepository;
import org.sid.entities.Employes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class EmployesMetierImpl implements EmployesMetier {
	@Autowired
	private EmployesRepository employesRepository;

	@Override
	public Employes addEmploye(Employes employe) {
		return this.employesRepository.save(employe);
	}

	@Override
	public List<Employes> getAllEmployes() {
		return this.employesRepository.findAll();
	}

	@Override
	public Employes getEmployeById(Long codeEmploye) {
		return this.employesRepository.findBycodeEmploye(codeEmploye);
	}

	@Override
	public Employes updateEmploye(Long codeEmploye, Employes emp) {
		Employes employeExistant = this.employesRepository.findBycodeEmploye(codeEmploye);
		return this.employesRepository.save(employeExistant);
	}

	@Override
	public boolean deleteEmploye(Long codeEmploye) {
		Employes employeExistant = this.employesRepository.findBycodeEmploye(codeEmploye);
		this.employesRepository.delete(employeExistant);
		return true;
	}

	@Override
	public void deleteAllEmployes() {
		this.employesRepository.deleteAll();

	}

}
