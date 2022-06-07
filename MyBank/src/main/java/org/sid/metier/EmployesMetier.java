package org.sid.metier;


import java.util.List;

import org.sid.entities.Employes;



public interface EmployesMetier {

	public Employes addEmploye(Employes employe);


	public List<Employes> getAllEmployes();

	public Employes getEmployeById(Long codeEmploye);


	public Employes updateEmploye(Long codeEmploye, Employes emp);


	public boolean deleteEmploye(Long codeEmploye);

	public void deleteAllEmployes();
}
