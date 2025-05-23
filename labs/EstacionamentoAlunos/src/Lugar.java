import java.util.Objects;

public class Lugar {

    private final int numero;
    private final int escalao;

    /**
     * 
     * @param numero
     * @param escalao
     */
    public Lugar(int numero, int escalao) {
        this.numero = numero;
        this.escalao = escalao;
    }

    public String obterNumero() {
        return "%d".formatted(numero);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Lugar lugar)){
            return false;
        }
        return numero == lugar.numero && escalao == lugar.escalao;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, escalao);
    }

    public String obterEscalao() {
        return "%d".formatted(escalao);
    }
}
