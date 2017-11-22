package com.wha.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wha.springmvc.model.Client;
import com.wha.springmvc.service.UtilisateurService;

@RestController
public class UtilisateurController {
	
	@Autowired
	UtilisateurService utilisateurService;
	
	//#region client

	@RequestMapping(value = "/utilisateurbyid/{identifiant}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Client> getUser(@PathVariable("identifiant") long id) {
		System.out.println("Fetching User with id " + id);
		Client user = utilisateurService.findById(id);
		if (user == null) {
			System.out.println("Client avec identifiant " + id + " est inexistant");
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Client>(user, HttpStatus.OK);
	}
	
	//Client findByCompte(Long noCompte);
	
	@RequestMapping(value = "/utilisateurbycompte/{noCompte}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Client> getUser2(@PathVariable("noCompte") long noCompte){
		System.out.println("Fetching User with noCompte " + noCompte);
		Client user = utilisateurService.findByCompte(noCompte);
		if (user == null) {
			System.out.println("Client avec NoCompte " + noCompte + " est inexistant");
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Client>(user, HttpStatus.OK);
	}
	
	
	//List<Client> findAllClients(Long mle);
	
	@RequestMapping(value = "/utilisateurss/{mle}", method = RequestMethod.GET)
	public ResponseEntity<List<Client>> getUser3(@PathVariable("mle") long mle){
		System.out.println("Fetching User with mle " + mle);
		List<Client> user = utilisateurService.findAllClients(mle);
		if (user == null) {
			System.out.println("Client avec mle " + mle + " est inexistant");
			return new ResponseEntity<List<Client>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Client>>(user, HttpStatus.OK);
	}
		
}