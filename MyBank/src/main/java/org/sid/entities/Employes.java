package org.sid.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Employes implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeEmploye;
	private String nomEmploye;

	@ManyToOne
	@JoinColumn(name = "Code_emp_sup")
	private Employes employeSup;

	@ManyToMany
	@JoinTable(name = "Emp_Gr", joinColumns = @JoinColumn(name = "Num_EMP"), inverseJoinColumns = @JoinColumn(name = "Num_Groupe"))
	private List<Groupe> groupes;

	public String getnomEmploye() {
		return nomEmploye;
	}

	public void setnomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}

	public Long getcodeEmploye() {
		return codeEmploye;
	}

	@JsonIgnore
	public List<Groupe> getGroupes() {
		return groupes;
	}

	public void setGroupes(List<Groupe> groupes) {
		this.groupes = groupes;
	}

	@JsonIgnore
	public Employes getemployeSup() {
		return employeSup;
	}

	@JsonSetter
	public void setemployeSup(Employes employeSup) {
		this.employeSup = employeSup;
	}

	public void setcodeEmploye(Long codeEmploye) {
		this.codeEmploye = codeEmploye;
	}

}