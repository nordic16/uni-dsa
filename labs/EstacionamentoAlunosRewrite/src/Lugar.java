import java.util.Objects;

public class Lugar {
    @Override
	public int hashCode() {
		return Objects.hash(escalao, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lugar other = (Lugar) obj;
		return escalao == other.escalao && numero == other.numero;
	}

	private final int numero;
    private int escalao;

    /**
     * 
     * @param numero
     * @param escalao
     */
    public Lugar(int numero, int escalao) {
        this.numero = numero;
        this.escalao = escalao;
    }

    public int obterNumero() {
        return numero;
    }

    public int obterEscalao() {
        return escalao;
    }
}
