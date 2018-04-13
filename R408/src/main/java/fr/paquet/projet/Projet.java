package fr.paquet.projet;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.persistence.*;

@Entity
@Table(name = "PROJET")
public class Projet {

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

	@OneToOne
	private Chantier chantier = null;

	@ManyToOne
	private Responsable resp = null;

	PropertyChangeSupport changeSupport = null;

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
	public Projet(PropertyChangeListener listener) {
		this();
		setChangeSupport(new PropertyChangeSupport(this));
		addPropertyChangeListener(listener);
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
	public Projet(PropertyChangeListener listener, String titre, Client client, Chantier chantier, Responsable resp) {
		this(listener);
		setChangeSupport(new PropertyChangeSupport(this));
		addPropertyChangeListener(listener);
		setTitre(titre);
		setClient(client);
		setChantier(chantier);
		setResp(resp);

	}

	public void setChangeSupport(PropertyChangeSupport pCS) {
		this.changeSupport = pCS;
	}

	private PropertyChangeSupport getChangeSupport() {
		return changeSupport;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public synchronized String getTitre() {
		return titre;
	}

	public synchronized void setTitre(String titre) {

		if (!titre.equals("") && titre != null) {
			titre = titre.toLowerCase().trim();
			titre = titre.substring(0, 1).toUpperCase() + titre.substring(1).toLowerCase();
		}

		String oldValeur = this.titre;
		this.titre = titre;
		getChangeSupport().firePropertyChange("titre", oldValeur, titre);

		this.titre = titre;

	}

	public Client getClient() {

		return client;
	}

	public void setClient(Client client) {

		this.client = client;
	}

	public Chantier getChantier() {

		return chantier;
	}

	private void setChantier(Chantier chantier) {
		this.chantier = chantier;
	}

	public Responsable getResp() {
		return resp;
	}

	public void setResp(Responsable resp) {

		resp.addProjet(this);
		this.resp = resp;

	}

	public synchronized void addPropertyChangeListener(PropertyChangeListener l) {

		getChangeSupport().addPropertyChangeListener(l);
	}

	public synchronized void removePropertyChangeListener(PropertyChangeListener l) {

		getChangeSupport().addPropertyChangeListener(l);

	}

}
