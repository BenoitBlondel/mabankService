package fr.benoit.mabankService.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.benoit.mabankService.domaine.Courant;

/**
 * Classe repository de Spring pour le compte Courant permettant de r�aliser un
 * DAO �volu� qui manipule une entit� JPA/Hibernate.
 * 
 * @author benoit
 *
 */
public interface CourantRepository extends JpaRepository<Courant, Integer> {

}
