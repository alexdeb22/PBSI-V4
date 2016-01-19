package fr.gtm.proxibanquesi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gtm.proxibanquesi.domaine.Client;

public interface IDaoClient extends JpaRepository<Client, Integer> {

}
