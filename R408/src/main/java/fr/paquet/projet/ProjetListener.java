package fr.paquet.projet;

import java.util.List;

public interface ProjetListener {

	public void changeTitre(String nouveauTitre);

	public void changeClient(Client nouveauClient);

	public void changeChantiers(List<Chantier> nouveauChantier);

	public void changeResponsable(Responsable nouveauResp);

}
