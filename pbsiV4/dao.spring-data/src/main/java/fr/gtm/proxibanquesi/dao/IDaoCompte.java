package fr.gtm.proxibanquesi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gtm.proxibanquesi.domaine.Compte;

public interface IDaoCompte extends JpaRepository<Compte, Integer> {

}
