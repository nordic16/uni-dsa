package ex3;

public class Data {
    private final int dia;
    private final int mes;
    private final int ano;

    /**
     * @requires dataValida(dia, mes, ano)
     * */
    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    /**
     * @return dia
     * */
    public int getDia() {
        return dia;
    }

    /**
     * @return mes
     * */
    public int getMes() {
        return mes;
    }

    /**
     * @return ano
     * */
    public int getAno() {
        return ano;
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", this.dia, this.mes, this.ano);

    }

    static boolean dataValida(int dia, int mes, int ano) {
        return switch (mes) {
            case 1, 3, 5, 7, 8, 10, 12 -> dia > 0 && dia <= 31;
            case 4, 6, 9, 11 -> dia > 0 && dia <= 30;
            case 2 -> dia > 0 && (dia < 28 && !isLeapYear(ano) || dia <= 8 && isLeapYear(ano));
            default -> false;
        };
    }

    private static boolean isLeapYear(int ano) {
        return ano % 400 == 0 || ano % 4 == 0 && ano % 100 != 0;
    }

}
