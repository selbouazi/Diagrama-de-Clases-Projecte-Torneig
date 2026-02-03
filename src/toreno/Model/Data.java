package toreno.Model;

public class Data {

    private int dia;
    private int mes;
    private int any;

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        if (dia < 1 || dia > diesMes(this.mes, this.any)) {
            throw new IllegalArgumentException("Día no válido");
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

    private int diesMes(int mes, int any) {
        return switch (mes) {
            case 1,3,5,7,8,10,12 -> 31;
            case 4,6,9,11 -> 30;
            case 2 -> if esAnyDeTraspas(any) ? 29 : 28;
            default -> 0;
        };
    }

    private boolean esAnyDeTraspas(int any) {
        return (any % 4 == 0 && any % 100 != 0) || (any % 400 == 0);
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + any;
    }
}
