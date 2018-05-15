package fr.benoit.mabankService.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.benoit.mabankService.domaine.Conseiller;

/**
 * Classe repository de Spring pour le Conseiller permettant de r�aliser un DAO
 * �volu� qui manipule une entit� JPA/Hibernate.
 * 
 * @author benoit
 *
 */
public interface ConseillerRepository extends JpaRepository<Conseiller, Integer> {

}
