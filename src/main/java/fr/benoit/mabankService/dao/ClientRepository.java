package fr.benoit.mabankService.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.benoit.mabankService.domaine.Client;

/**
 * Classe repository de Spring pour le Client permettant de r�aliser un DAO
 * �volu� qui manipule une entit� JPA/Hibernate.
 * 
 * @author benoit
 *
 */
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
