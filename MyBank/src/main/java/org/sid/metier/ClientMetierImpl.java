package org.sid.metier;

import java.util.List;

import org.sid.dao.ClientRepository;
import org.sid.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientMetierImpl implements ClientMetier {
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public Client addClient(Client client) {
		return this.clientRepository.save(client);
	}

	@Override
	public List<Client> getAllClients() {
		return this.clientRepository.findAll();
	}

	/*@Override
	public Client getClientById(Long code) {
		return this.clientRepository.findBycodeClient(code);
	}

	@Override
	public Client updateClient(Long code, String nom) {
		Client clientExistant = getClientById(code);
		clientExistant.setNom(nom);
		return this.clientRepository.save(clientExistant);
	}

	@Override
	public boolean deleteClient(Long code) {
		Client clientExistant = getClientById(code);
		this.clientRepository.delete(clientExistant);
		return true;
	}*/

}
