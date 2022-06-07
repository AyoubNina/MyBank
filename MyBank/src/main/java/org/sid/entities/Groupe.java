package org.sid.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Groupes")
public class Groupe implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeGroupe;

	private String nomGroupe;

	@ManyToMany(mappedBy = "groupes")
	private List<Employes> employes;

	public Groupe() {
		super();
	}

	public Groupe(String nomGroupe) {
		super();
		this.nomGroupe = nomGroupe;
	}

	public Long getcodeGroupe() {
		return codeGroupe;
	}

	public void setcodeGroupe(Long codeGroupe) {
		this.codeGroupe = codeGroupe;
	}

	public String getnomGroupe() {
		return nomGroupe;
	}

	public void setnomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}

	public List<Employes> getEmployees() {
		return employes;
	}

}