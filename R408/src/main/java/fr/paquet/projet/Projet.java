package fr.paquet.projet;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.persistence.*;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("projet")
@Entity
@Table(name = "PROJET")
public class Projet {

	/**
	 * @author Nathanaël
	 * 
	 *         Class qui gere un projet<br/>
	 */

	@XStreamOmitField
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private long id = 0;

	@Column(name = "PRPRTI", length = 20)
	private String titre = null;

	@ManyToOne(fetch = FetchType.LAZY)
	private Client client = null;

	@OneToOne(mappedBy = "projet", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Chantier chantier = null;

	@ManyToOne(fetch = FetchType.LAZY)
	private Responsable resp = null;

	@XStreamOmitField
	@Transient
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
	 * @throws Exception
	 */
	public Projet(PropertyChangeListener listener, String titre, Client client, Chantier chantier, Responsable resp) {
		this(listener);
		addPropertyChangeListener(listener);
		setTitre(titre);
		setClient(client);
		setChantier(chantier);
		setResp(resp);

	}

	private PropertyChangeSupport getChangeSupport() {
		if (changeSupport == null)
			changeSupport = new PropertyChangeSupport(this);
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

	/**
	 * 
	 * @param titre
	 * @throws Exception
	 *             pas de titre<br/>
	 */
	public synchronized void setTitre(String titre) {

		if (!titre.equals("") && titre != null) {
			titre = titre.toLowerCase().trim();
			titre = titre.substring(0, 1).toUpperCase() + titre.substring(1).toLowerCase();

			String oldValeur = this.titre;
			this.titre = titre;
			getChangeSupport().firePropertyChange("titre", oldValeur, titre);
		}

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

	public void setChantier(Chantier chantier) {
		this.chantier = chantier;
	}

	public Responsable getResp() {
		return resp;
	}

	public void setResp(Responsable resp) {

		if (getResp() != null)
			removeRespProjet(getResp(), this);

		this.resp = resp;
		addRespProjet(getResp(), this);

	}

	private void addRespProjet(Responsable resp, Projet projet) {
		if (!resp.getProjets().contains(projet))
			resp.getProjets().add(projet);
	}

	private void removeRespProjet(Responsable resp, Projet projet) {
		if (resp.getProjets().contains(projet))
			resp.getProjets().remove(projet);
	}

	public synchronized void addPropertyChangeListener(PropertyChangeListener l) {

		getChangeSupport().addPropertyChangeListener(l);
	}

	public synchronized void removePropertyChangeListener(PropertyChangeListener l) {

		getChangeSupport().addPropertyChangeListener(l);

	}

	public String toString() {
		return getTitre();
	}

}
