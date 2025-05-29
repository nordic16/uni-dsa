import java.util.Objects;

public class Funcionario {
    private final String nome;
    private final int escalao;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Funcionario funcionario)) {
            return false;
        }
        return escalao == funcionario.escalao && nome.equals(funcionario.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, escalao);
    }

    /**
     * 
     * @param nome
     * @param escalao 
     */
    public Funcionario(String nome, int escalao) {
        this.nome = nome;
        this.escalao = escalao;
    }

    public String obterNome() {
        return nome;
    }

    public int obterEscalao() {
        return escalao;
    }
}
