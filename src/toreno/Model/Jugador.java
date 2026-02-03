package toreno.Model;

public class Jugador extends Persona {
	
	/* -- Attributes -- */
	private int numLlicencia;
	
	/* -- Getters / Setters --*/
	public int getNumLlicencia() {
		return numLlicencia;
	}

	public void setNumLlicencia(int numLlicencia) {
		this.numLlicencia = numLlicencia;
	}

	/* -- Constructor -- */
	public Jugador(Nif nif, String nom, Data dataNaixement, int numLlicencia) {
		super(nif, nom, dataNaixement);
		setNumLlicencia(numLlicencia);
	}

	/* -- toString --*/
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Jugador: " + getNom() + ", Nif: " + getNif() + ", data de naixement: " + getDataNaixement() + ", numero de llicencia: " + getNumLlicencia() + ".";
	}
	
}
