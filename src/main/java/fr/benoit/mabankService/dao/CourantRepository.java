package fr.benoit.mabankService.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.benoit.mabankService.domaine.Courant;

/**
 * Classe repository de Spring pour le compte Courant permettant de réaliser un
 * DAO évolué qui manipule une entité JPA/Hibernate.
 * 
 * @author benoit
 *
 */
public interface CourantRepository extends JpaRepository<Courant, Integer> {

}
