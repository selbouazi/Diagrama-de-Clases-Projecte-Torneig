package toreno.Model;

/**
 * Representa un NIF con número y letra.
 */
public class Nif {
	
	/* -- Attributes -- */
	private int dni;
	private String lletra;
	
	public int getDni() {
		return dni;
	}

	
	/* -- Getters / Setters -- */
	public void setDni(int dni) {
		if (String.valueOf(dni).length() != 8) {
	        throw new IllegalArgumentException("¡El DNI debe tener 8 dígitos!");
	    }
	    this.dni = dni;
	}

	public String getLletra() {
		return lletra;
	}

	public void setLletra(String lletra) {
		if(!lletra.isBlank() || !lletra.isEmpty() || lletra != null) {
			this.lletra = lletra;			
		}
	}

	/* -- Constructor -- */
	public Nif(int dni, String lletra) {
		setDni(dni);
		setLletra(lletra);
	}
	
	@Override
	/** @return NIF como cadena */
	public String toString() {
		return getDni() + getLletra();
	}
}
