package org.sid.metier;

import java.util.List;

import org.sid.dao.CompteRepository;
import org.sid.entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CompteMetierImpl implements CompteMetier {
	@Autowired
	private CompteRepository compteRepository;

	@Override
	public Compte ajoutCompte(Compte cp) {
		return this.compteRepository.save(cp);
	}

	@Override
	public List<Compte> getAllAccounts() {
		return this.compteRepository.findAll();
	}

	@Override
	public Compte getCompteById(String codeCompte) {
		return this.compteRepository.compteParId(codeCompte);
	}

	@Override
	public Compte updateCompte(String codeCompte, Double solde) {
		Compte cp = getCompteById(codeCompte);
		cp.setSolde(cp.getSolde() + solde);
		return this.compteRepository.save(cp);
	}

	@Override
	public boolean deleteCompte(String codeCompte) {
		Compte cp = getCompteById(codeCompte);
		this.compteRepository.delete(cp);
		return true;
	}
}
