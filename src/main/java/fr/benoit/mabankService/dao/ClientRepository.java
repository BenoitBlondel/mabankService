package fr.benoit.mabankService.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.benoit.mabankService.domaine.Client;

/**
 * Classe repository de Spring pour le Client permettant de réaliser un DAO
 * évolué qui manipule une entité JPA/Hibernate.
 * 
 * @author benoit
 *
 */
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
