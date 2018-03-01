package fr.paquet.projet;

import java.util.*;

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
	
	@ManyToMany
	private List<Chantier> chantiers = null;
	
	@ManyToOne
	private Responsable resp = null;

	public Projet() {
		super();
	}
	
	public Projet(String titre, Client client, Chantier chantier, Responsable resp) {
		this();
		setTitre(titre);
		setClient(client);
		addChantier(chantier);
		setResp(resp);
	}

	public long getId() {
		return id;
	}

	private void setId(long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	private void setTitre(String titre) {
		this.titre = titre;
	}

	public Client getClient() {
		return client;
	}

	private void setClient(Client client) {
		this.client = client;
	}

	public List<Chantier> getChantiers() {
		if(chantiers == null)
			chantiers = new ArrayList<Chantier>();
		return chantiers;
	}

	private void addChantier(Chantier chantier) {
		getChantiers().add(chantier);
	}

	public Responsable getResp() {
		return resp;
	}

	private void setResp(Responsable resp) {
		this.resp = resp;
	}

}
