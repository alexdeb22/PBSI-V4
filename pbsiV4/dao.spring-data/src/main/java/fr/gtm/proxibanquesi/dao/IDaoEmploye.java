package fr.gtm.proxibanquesi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.gtm.proxibanquesi.domaine.Employe;

/** Spring data Repository pour les employes
 * @author Adminl
 *
 */
@Repository("daoEmploye")
public interface IDaoEmploye extends JpaRepository<Employe, Integer> {

}
