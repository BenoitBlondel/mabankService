package fr.benoit.mabankService.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.benoit.mabankService.domaine.Gerant;

/**
 * Classe repository de Spring pour le Gerant permettant de r�aliser un DAO
 * �volu� qui manipule une entit� JPA/Hibernate.
 * 
 * @author benoit
 *
 */
public interface GerantRepository extends JpaRepository<Gerant, Integer> {

}
