package fr.benoit.mabankService.domaine;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Classe Gerant heritee d'Employe (discriminant gerant) contenant la proriete
 * supplementaire conseillers (liste des conseillers geres par le gerant).
 * 
 * @author benoit
 *
 */
@Entity
@DiscriminatorValue("gerant")
public class Gerant extends Employe {

	/**
	 * Constructeur complet
	 * 
	 * @param idEmploye
	 * @param nom
	 * @param prenom
	 * @param tel
	 * @param email
	 * @param login
	 * @param password
	 * @param conseillers
	 */
	public Gerant(Integer idEmploye, String nom, String prenom, String tel, String email, String login, String password) {
		super(idEmploye, nom, prenom, tel, email, login, password);
	}

	/**
	 * Constructeur d'utilisation
	 * 
	 * @param idEmploye
	 * @param nom
	 * @param prenom
	 * @param tel
	 * @param email
	 * @param login
	 * @param password
	 */
	public Gerant(String nom, String prenom, String tel, String email, String login, String password) {
		super(nom, prenom, tel, email, login, password);
	}

	/**
	 * Constructeur vide
	 */
	public Gerant() {
		super();
	}

}
