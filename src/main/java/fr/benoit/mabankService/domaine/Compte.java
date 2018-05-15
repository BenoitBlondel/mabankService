package fr.benoit.mabankService.domaine;

import java.time.LocalDate;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

/**
 * Classe Abstraite Compte contenant les proprietes id, numeroCompte (le numero
 * de compte), solde (le solde actule du compte), ouvertureCompte (la date
 * d'ouverture du compte) et client (le client associe au compte) et possedant
 * un discriminant typeCompte.
 * 
 * @author benoit
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "typeCompte")
public abstract class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer idCompte;

	protected String numeroCompte;
	protected Float solde;
	protected LocalDate ouvertureCompte;
	@OneToOne(fetch = FetchType.EAGER)
	protected Client client;

	/**
	 * Constructeur complet
	 * 
	 * @param idCompte
	 * @param numeroCompte
	 * @param solde
	 * @param ouvertureCompte
	 * @param client
	 */
	public Compte(Integer idCompte, String numeroCompte, Float solde, LocalDate ouvertureCompte, Client client) {
		super();
		this.idCompte = idCompte;
		this.numeroCompte = numeroCompte;
		this.solde = solde;
		this.ouvertureCompte = ouvertureCompte;
		this.client = client;
	}

	/**
	 * Constructeur vide
	 */
	public Compte() {
		super();
	}

	public Integer getIdCompte() {
		return this.idCompte;
	}

	public void setIdCompte(Integer idCompte) {
		this.idCompte = idCompte;
	}

	public String getNumeroCompte() {
		return this.numeroCompte;
	}

	public void setNumeroCompte(String numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public Float getSolde() {
		return this.solde;
	}

	public void setSolde(Float solde) {
		this.solde = solde;
	}

	public LocalDate getOuvertureCompte() {
		return this.ouvertureCompte;
	}

	public void setOuvertureCompte(LocalDate ouvertureCompte) {
		this.ouvertureCompte = ouvertureCompte;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
