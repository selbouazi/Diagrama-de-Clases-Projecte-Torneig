package toreno.Model;

/**
 * Representa una persona con NIF, nombre y fecha de nacimiento.
 */
public class Persona {

	/* -- Attributes --*/
	private Nif nif;
	private String nom;
	private Data dataNaixement;
	
	/* -- Getters / Setters -- */
	public Nif getNif() {
		return nif;
	}
	public void setNif(Nif nif) {
		this.nif = nif;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		if(!nom.isBlank() || !nom.isEmpty() || nom != null) {
			this.nom = nom;			
		}
	}
	public Data getDataNaixement() {
		return dataNaixement;
	}
	public void setDataNaixement(Data dataNaixement) {
		this.dataNaixement = dataNaixement;
	}
	
	/* -- Constructor -- */
	/** Constructor de persona */
	public Persona(Nif nif, String nom, Data dataNaixement) {
		setNif(nif);
		setNom(nom);
		setDataNaixement(dataNaixement);
	}
	
	/* -- toString --*/
	/** @return información de la persona como cadena */
	@Override
	public String toString() {
		return "Nom: " + getNom() + ", Nif: " + getNif() + ", data de naixement: " + getDataNaixement() + ".";
	}
}
