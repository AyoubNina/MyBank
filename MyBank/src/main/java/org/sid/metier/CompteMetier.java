package org.sid.metier;


import java.util.List;

import org.sid.entities.Compte;



public interface CompteMetier {
	
	public Compte ajoutCompte(Compte cp);


	public List<Compte> getAllAccounts();

	public Compte getCompteById(String code);


	public Compte updateCompte(String code, Double solde);


	public boolean deleteCompte(String code);
}
