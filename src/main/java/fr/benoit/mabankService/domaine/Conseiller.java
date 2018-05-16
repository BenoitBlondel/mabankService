package fr.benoit.mabankService.domaine;

import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Classe Conseiller heritee d'Employe (discriminant conseiller) contenant les
 * prorietes supplementaires clients (liste des clients geres par le conseiller)
 * et gerant (le gerant associe au conseiller).
 * 
 * @author benoit
 *
 */
@Entity
@DiscriminatorValue("conseiller")
public class Conseiller extends Employe {

	@OneToMany(mappedBy = "conseiller", fetch = FetchType.EAGER)
	private Collection<Client> clients;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	private Gerant gerant;

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
	 * @param clients
	 * @param gerant
	 */
	public Conseiller(Integer idEmploye, String nom, String prenom, String tel, String email, String login, String password, Collection<Client> clients, Gerant gerant) {
		super(idEmploye, nom, prenom, tel, email, login, password);
		this.clients = clients;
		this.gerant = gerant;
	}

	/**
	 * Constructeur d'utilisation
	 * 
	 * @param nom
	 * @param prenom
	 * @param tel
	 * @param email
	 * @param login
	 * @param password
	 * @param idGerant
	 */
	public Conseiller(String nom, String prenom, String tel, String email, String login, String password, Integer idGerant) {
		super(nom, prenom, tel, email, login, password);
		this.gerant.idEmploye = idGerant;
	}

	/**
	 * Constructeur vide
	 */
	public Conseiller() {
		super();
	}

	public Collection<Client> getClients() {
		return this.clients;
	}

	public void setClients(Collection<Client> clients) {
		this.clients = clients;
	}

	public Gerant getGerant() {
		return this.gerant;
	}

	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}

	@Override
	public String toString() {
		return "Conseiller [nom : " + this.nom + "prenom : " + this.prenom + "tel : " + this.tel + "email : " + this.email + "clients=" + this.clients + ", gerant=" + this.gerant + "]";
	}

}
