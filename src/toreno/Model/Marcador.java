package toreno.Model;

/**
 * Representa el marcador de un partido.
 */
public class Marcador {

	/* -- Attributes -- */
	private int puntsJugador1;
	private int puntsJugador2;
	
	/* -- Getters / Setters */
	public int getPuntsJugador1() {
		return puntsJugador1;
	}
	
	public void setPuntsJugador1(int puntsJugador1) {
		if(puntsJugador1 < 0 || puntsJugador1 > 21) {
	        throw new IllegalArgumentException("¡No puede tener menos de 0 puntos o más de 21!");
		}
		this.puntsJugador1 = puntsJugador1;
	}
	
	public int getPuntsJugador2() {
		return puntsJugador2;
	}
	
	public void setPuntsJugador2(int puntsJugador2) {
		if(puntsJugador2 < 0 || puntsJugador2 > 21) {
	        throw new IllegalArgumentException("¡No puede tener menos de 0 puntos o más de 21!");
		}
		this.puntsJugador2 = puntsJugador2;
	}
	
	/* -- Constructor -- */
	/** Constructor con los puntos de cada jugador */
	public Marcador(int puntsJugador1, int puntsJugador2) {
		setPuntsJugador1(puntsJugador1);
		setPuntsJugador2(puntsJugador2);
	}
	
	/** @return puntos de ambos jugadores como cadena */
	@Override
	public String toString() {
		return "Jugador 1: " + getPuntsJugador1() + " | Jugador 2: " + getPuntsJugador2();
	}
	
}
