package fr.gtm.proxibanquesi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.gtm.proxibanquesi.domaine.Client;

/**
 * Interface DaoClient. Elle liste les méthodes CRUD d'un client et une méthode qui retourne la liste de tous les clients
 *
 */
@Repository("dao")
public interface IDaoClient extends JpaRepository<Client, Integer> {

}
