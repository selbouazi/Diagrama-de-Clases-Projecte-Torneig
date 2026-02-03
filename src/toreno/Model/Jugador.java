package toreno.Model;

/**
 * Representa un jugador con licencia, hereda de Persona.
 */
public class Jugador extends Persona {
	
	/* -- Attributes -- */
	 /** Número de licencia del jugador */
	private int numLlicencia;
	
	/* -- Getters / Setters --*/
	public int getNumLlicencia() {
		return numLlicencia;
	}

	public void setNumLlicencia(int numLlicencia) {
		this.numLlicencia = numLlicencia;
	}

	/* -- Constructor -- */
	 /** Constructor del jugador */
	public Jugador(Nif nif, String nom, Data dataNaixement, int numLlicencia) {
		super(nif, nom, dataNaixement);
		setNumLlicencia(numLlicencia);
	}

	/* -- toString --*/
	 /** @return información del jugador como cadena */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Jugador: " + getNom() + ", Nif: " + getNif() + ", data de naixement: " + getDataNaixement() + ", numero de llicencia: " + getNumLlicencia() + ".";
	}
	
}
