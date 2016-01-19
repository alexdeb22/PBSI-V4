package fr.gtm.proxibanquesi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.gtm.proxibanquesi.domaine.Client;

@Repository("dao")
public interface IDaoClient extends JpaRepository<Client, Integer> {

}
