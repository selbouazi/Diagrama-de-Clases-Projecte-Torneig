package toreno.Model;

/**
 * Representa un torneo con fecha, partidos y ganador.
 */
public class Torneig {

    /* -- Attributes -- */
    private Data data;
    private int partitsJugats;
    private Partit[] partits;
    private Jugador guanyador;

    /* -- Getters / Setters -- */
    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public int getPartitsJugats() {
        return partitsJugats;
    }

    public void setPartitsJugats(int partitsJugats) {
        this.partitsJugats = partitsJugats;
    }

    public Partit[] getPartits() {
        return partits;
    }

    public void setPartits(Partit[] partits) {
        this.partits = partits;
    }

    public Jugador getGuanyador() {
        return guanyador;
    }

    public void setGuanyador(Jugador guanyador) {
        this.guanyador = guanyador;
    }

    /* -- Constructor -- */
    /** Constructor del torneo */
    public Torneig(Data data, int partitsJugats, Partit[] partits, Jugador guanyador) {
        setData(data);
        setPartitsJugats(partitsJugats);
        setPartits(partits);
        setGuanyador(guanyador);
    }

    /* -- toString -- */
    /** @return información del torneo como cadena */
    @Override
    public String toString() {
        return "Torneig{" +
                "data=" + data +
                ", partitsJugats=" + partitsJugats +
                ", partits=" + java.util.Arrays.toString(partits) +
                ", guanyador=" + guanyador +
                '}';
    }
}
