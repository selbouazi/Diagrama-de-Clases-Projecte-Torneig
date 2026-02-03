package toreno.Model;

public class Partit {

	/* -- Attributes --*/
	/**
	 * Representa un partido entre dos jugadores.
	 */
	private Jugador participant1;
	private Jugador participant2;
	private Jugador guanyador;
	private Marcador puntuacions;
	
	/* -- Getters / Setters --*/
	public Jugador getParticipant1() {
		return participant1;
	}
	public void setParticipant1(Jugador participant1) {
		this.participant1 = participant1;
	}
	public Jugador getParticipant2() {
		return participant2;
	}
	public void setParticipant2(Jugador participant2) {
		this.participant2 = participant2;
	}
	public Jugador getGuanyador() {
		return guanyador;
	}
	public void setGuanyador(Jugador guanyador) {
		this.guanyador = guanyador;
	}
	public Marcador getPuntuacions() {
		return puntuacions;
	}
	public void setPuntuacions(Marcador puntuacions) {
		this.puntuacions = puntuacions;
	}
	
	/* -- Constructor -- */
	/** Constructor de partido */
	public Partit(Jugador participant1, Jugador participant2, Jugador guanyador, Marcador puntucaions) {
		setParticipant1(participant1);
		setParticipant2(participant2);
		setGuanyador(guanyador);
		setPuntuacions(puntucaions);
	}
	
	/* -- toString --*/
	/** @return información del partido como cadena */
    @Override
	public String toString() {
		return "Participants: " + getParticipant1() + " i " + getParticipant2() + ", el guanyador es: " + getGuanyador() + ", Puntuació: " + getPuntuacions() + ".";
	}
}
