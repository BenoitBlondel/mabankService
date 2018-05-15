package fr.benoit.mabankService.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.benoit.mabankService.domaine.Epargne;

/**
 * Classe repository de Spring pour le compte Epargne permettant de r�aliser un
 * DAO �volu� qui manipule une entit� JPA/Hibernate.
 * 
 * @author benoit
 *
 */
public interface EpargneRepository extends JpaRepository<Epargne, Integer> {

}
