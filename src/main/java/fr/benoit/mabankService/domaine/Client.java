package fr.benoit.mabankService.domaine;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Classe Client possedant les proprietes id, nom prenom, tel, email, rue
 * (numero et nom de rue), codePostal, ville, entreprise (indiquant si le client
 * est une entreprise ou non), fortunne (indiquant si le client est fortunee),
 * soldeTotalCompte (somme des soldes des differents comptes du client,
 * conseiller (conseiller associe au client), courant (compte courant associe au
 * client), epargne (compte epargne associe au client).
 * 
 * @author benoit
 *
 */
@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idClient;

	private String nom;
	private String prenom;
	private String tel;
	private String email;
	private String rue;
	private String codePostal;
	private String ville;
	private Boolean entreprise;
	private Boolean fortunee;
	private Float soldeTotalComptes;
	@ManyToOne(fetch = FetchType.EAGER)
	private Conseiller conseiller;
	@OneToOne(mappedBy = "client", fetch = FetchType.EAGER)
	private Courant courant;
	@OneToOne(mappedBy = "client", fetch = FetchType.EAGER)
	private Epargne epargne;

	/**
	 * Constructeur complet
	 * 
	 * @param idClient
	 * @param nom
	 * @param prenom
	 * @param tel
	 * @param email
	 * @param rue
	 * @param codePostal
	 * @param ville
	 * @param entreprise
	 * @param fortunee
	 * @param soldeTotalComptes
	 * @param conseiller
	 * @param courant
	 * @param epargne
	 */
	public Client(Integer idClient, String nom, String prenom, String tel, String email, String rue, String codePostal, String ville, Boolean entreprise, Boolean fortunee, Float soldeTotalComptes,
			Conseiller conseiller, Courant courant, Epargne epargne) {
		super();
		this.idClient = idClient;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.email = email;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.entreprise = entreprise;
		this.fortunee = fortunee;
		this.soldeTotalComptes = soldeTotalComptes;
		this.conseiller = conseiller;
		this.courant = courant;
		this.epargne = epargne;
	}

	/**
	 * Constructeur d'utilisation
	 * 
	 * @param nom
	 * @param prenom
	 * @param tel
	 * @param email
	 * @param rue
	 * @param codePostal
	 * @param ville
	 * @param entreprise
	 * @param conseiller
	 */
	public Client(String nom, String prenom, String tel, String email, String rue, String codePostal, String ville, Boolean entreprise, Integer idConseiller) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.email = email;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.entreprise = entreprise;
		this.conseiller.idEmploye = idConseiller;
	}

	/**
	 * Constructeur vide
	 */
	public Client() {
		super();
	}

	public Integer getIdClient() {
		return this.idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
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

	public String getRue() {
		return this.rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return this.codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Boolean getEntreprise() {
		return this.entreprise;
	}

	public void setEntreprise(Boolean entreprise) {
		this.entreprise = entreprise;
	}

	public Boolean getFortunee() {
		return this.fortunee;
	}

	public void setFortunee(Boolean fortunee) {
		this.fortunee = fortunee;
	}

	public Float getSoldeTotalComptes() {
		return this.soldeTotalComptes;
	}

	public void setSoldeTotalComptes(Float soldeTotalComptes) {
		this.soldeTotalComptes = soldeTotalComptes;
	}

	public Conseiller getConseiller() {
		return this.conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	public Courant getCourant() {
		return this.courant;
	}

	public void setCourant(Courant courant) {
		this.courant = courant;
	}

	public Epargne getEpargne() {
		return this.epargne;
	}

	public void setEpargne(Epargne epargne) {
		this.epargne = epargne;
	}

}
