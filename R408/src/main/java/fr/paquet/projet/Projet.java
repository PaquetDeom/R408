package fr.paquet.projet;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "PROJET")
public class Projet implements ProjetListener {

	/**
	 * @author Nathanaël
	 * 
	 *         Class qui gere un projet<br/>
	 */

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private long id = 0;

	@Column(name = "PRPRTI", length = 20)
	private String titre = null;

	@ManyToOne
	private Client client = null;

	@ManyToMany
	private List<Chantier> chantiers = null;

	@ManyToOne
	private Responsable resp = null;

	private ArrayList<ProjetListener> listenerList = null;

	public void addProjetListener(ProjetListener listener) {
		getListener().add(listener);
	}

	/**
	 * 
	 * @return La liste des listener qui ecoute Projet<br/>
	 */
	private ArrayList<ProjetListener> getListener() {
		if (listenerList == null)
			listenerList = new ArrayList<ProjetListener>();
		return listenerList;
	}

	/**
	 * Constructeur vide pour la gestion de la DB<br/>
	 */
	public Projet() {
		super();
	}

	/**
	 * Constructeur de la class<br/>
	 * 
	 * @param listener
	 *            de type ProjetListener<br/>
	 */
	public Projet(ProjetListener listener) {
		this();
		if (listener != null)
			addProjetListener(listener);
	}

	/**
	 * Constructeur de la class<br/>
	 * 
	 * @param listener
	 *            de type ProjetListener<br/>
	 * @param titre
	 *            de type String<br/>
	 * @param client
	 *            de type Client<br/>
	 * @param chantier
	 *            de type Chantier<br/>
	 * @param resp
	 *            de Type Reponsable<br/>
	 */
	public Projet(ProjetListener listener, String titre, Client client, Chantier chantier, Responsable resp) {
		this(listener);
		setTitre(titre);
		setClient(client);
		addChantier(chantier);
		setResp(resp);

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		if (!titre.equals("")) {
			titre = titre.toLowerCase().trim();
			titre = titre.substring(0, 1).toUpperCase() + titre.substring(1).toLowerCase();
		}
		this.titre = titre;
		changeTitre(titre);
	}

	public Client getClient() {

		return client;
	}

	private void setClient(Client client) {
		this.client = client;
		changeClient(client);
	}

	public List<Chantier> getChantiers() {
		if (chantiers == null)
			chantiers = new ArrayList<Chantier>();
		return chantiers;
	}

	private void addChantier(Chantier chantier) {
		getChantiers().add(chantier);
	}

	public Responsable getResp() {
		return resp;
	}

	public void setResp(Responsable resp) {
		resp.addProjet(this);
		this.resp = resp;
		changeResponsable(resp);
	}

	@Override
	public void changeTitre(String nouveauTitre) {
		if (getListener() == null || getListener().isEmpty()) {
			nouveauTitre = null;
		} else {
			for (ProjetListener l : getListener()) {
				l.changeTitre(nouveauTitre);
			}
		}

	}

	@Override
	public void changeClient(Client nouveauClient) {
		if (getListener() == null || getListener().isEmpty()) {
			nouveauClient = null;
		} else {
			for (ProjetListener l : getListener()) {
				l.changeClient(nouveauClient);
			}
		}

	}

	@Override
	public void changeChantiers(List<Chantier> nouveauChantier) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changeResponsable(Responsable nouveauResp) {
		if (getListener() == null || getListener().isEmpty()) {
			nouveauResp = null;
		} else {
			for (ProjetListener l : getListener()) {
				l.changeResponsable(nouveauResp);
			}
		}
	}

}
