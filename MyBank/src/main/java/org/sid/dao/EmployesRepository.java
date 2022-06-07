package org.sid.dao;
import org.sid.entities.Employes;
import org.springframework.data.jpa.repository.JpaRepository;





public interface EmployesRepository extends JpaRepository<Employes, Long> {
	public Employes findBycodeEmploye(Long codeEmploye);
}
