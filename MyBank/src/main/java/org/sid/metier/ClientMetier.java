package org.sid.metier;

import java.util.List;

import org.sid.entities.Client;



public interface ClientMetier {
	// CREATE
	public Client addClient(Client client);

	
	public List<Client> getAllClients();

	//public Client getClientById(Long codeClient);

	
	//public Client updateClient(Long codeClient, String nomClient);

	
	//public boolean deleteClient(Long codeClient);

}