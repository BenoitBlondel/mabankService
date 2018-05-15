package fr.benoit.mabankService.domaine;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Classe Courant heritee de Compte (discriminant courant) et possedant les
 * propietes supplementaires decouvertAutorise (le decouvert autorise pour ce
 * compte) et typeCarte (le type de carte associe au compte).
 * 
 * @author benoit
 *
 */
@Entity
@DiscriminatorValue("courant")
public class Courant extends Compte {

	private Float decouvertAutorise;
	private String typeCarte;

	/**
	 * Constructeur complet
	 * 
	 * @param idCompte
	 * @param numeroCompte
	 * @param solde
	 * @param ouvertureCompte
	 * @param client
	 * @param decouvertAutorise
	 * @param typeCarte
	 */
	public Courant(Integer idCompte, String numeroCompte, Float solde, LocalDate ouvertureCompte, Client client, Float decouvertAutorise, String typeCarte) {
		super(idCompte, numeroCompte, solde, ouvertureCompte, client);
		this.decouvertAutorise = decouvertAutorise;
		this.typeCarte = typeCarte;
	}

	/**
	 * Constructeur vide
	 */
	public Courant() {
		super();
	}

	public Float getDecouvertAutorise() {
		return this.decouvertAutorise;
	}

	public void setDecouvertAutorise(Float decouvertAutorise) {
		this.decouvertAutorise = decouvertAutorise;
	}

	public String getTypeCarte() {
		return this.typeCarte;
	}

	public void setTypeCarte(String typeCarte) {
		this.typeCarte = typeCarte;
	}

}
