package fr.benoit.mabankService.domaine;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Classe Abstraite Employe contenant les proprietes id, nom, prenom, telephone,
 * et mail des employes possedant un discriminant typeEmploye.
 * 
 * @author benoit
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "typeEmploye")
public abstract class Employe {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer idEmploye;

	protected String nom;
	protected String prenom;
	protected String tel;
	protected String email;
	protected String login;
	protected String password;

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
	 */
	public Employe(Integer idEmploye, String nom, String prenom, String tel, String email, String login, String password) {
		super();
		this.idEmploye = idEmploye;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.email = email;
		this.login = login;
		this.password = password;
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
	 */
	public Employe(String nom, String prenom, String tel, String email, String login, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.email = email;
		this.login = login;
		this.password = password;
	}

	/**
	 * Constructeur vide
	 */
	public Employe() {
		super();
	}

	public Integer getIdEmploye() {
		return this.idEmploye;
	}

	public void setIdEmploye(Integer idEmploye) {
		this.idEmploye = idEmploye;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
