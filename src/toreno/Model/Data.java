package toreno.Model;

public class Data {

    private int dia;
    private int mes;
    private int any;

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        if (getMes() < 1 || getMes() > 12 || getAny() < 1) {
            throw new IllegalStateException("Mes y año deben estar establecidos antes del día");
        }
        if (dia < 1 || dia > diesMes()) {
            throw new IllegalArgumentException("Día no válido para este mes y año");
        }
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        if (mes < 1 || mes > 12) {
            throw new IllegalArgumentException("Mes no válido");
        }
        this.mes = mes;
    }

    public int getAny() {
        return any;
    }

    public void setAny(int any) {
        if (any < 1) {
            throw new IllegalArgumentException("Año no válido");
        }
        this.any = any;
    }

    public Data(int dia, int mes, int any) {
        setMes(mes);
        setAny(any);
        setDia(dia);
    }

    private int diesMes() {
        int[] mesos31 = {1, 3, 5, 7, 8, 10, 12};
        int[] mesos30 = {4, 6, 9, 11};

        for (int m : mesos31) {
            if (getMes() == m) {
                return 31;
            }
        }

        for (int m : mesos30) {
            if (getMes() == m) {
                return 30;
            }
        }

        if (getMes() == 2) {
            return esAnyDeTraspas() ? 29 : 28;
        }

        return 0;
    }

    private boolean esAnyDeTraspas() {
        return (getAny() % 4 == 0 && getAny() % 100 != 0) || (getAny() % 400 == 0);
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", getDia(), getMes(), getAny());
    }
}
