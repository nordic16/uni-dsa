public class Gestor {

    // será necessário que todas as keys sejam inteiros?
    private final BidirectionalHashMap<Funcionario, Integer> lugares; // funcionario -> numero
    private final BidirectionalHashMap<String, Integer> funcionarios; // nome -> escalao
    private final BidirectionalHashMap<Integer, Integer> atribuidos; // escalao -> nº de atribuidos.

    private final int nrEscaloes;
    private final int nrLugares;
    private final int estrategia;

    /**
     * 
     * @param nrEscaloes
     * @param nrLugares
     * @param estrategia
     */
    public Gestor(int nrEscaloes, int nrLugares, int estrategia) {
        this.lugares = new BidirectionalHashMap<>();
        this.funcionarios = new BidirectionalHashMap<>();
        this.atribuidos = new BidirectionalHashMap<>();
        this.nrEscaloes = nrEscaloes;
        this.nrLugares = nrLugares;
        this.estrategia = estrategia;
    }

    public String totalAtribuidos() {
        int total = 0;
        for (int i = 1; i <= nrEscaloes; i++) {
            total += atribuidos.getOrDefault(i, 0);
        }
        return "%d".formatted(total);
    }

    public boolean registar(String nome, int escalao) {
        if (funcionarios.containsKey(nome)) {
            return false;
        }
        funcionarios.put(nome, escalao);
        return true;
    }

    public boolean atribuir(String nome) {
        int escalao = funcionarios.getValue(nome);
        Funcionario f = new Funcionario(nome, escalao);

        // can't attribute a spot to someone who already has one.
        if (lugares.containsKey(f)) {
            return false;
        }

        final int firstPermissible = (nrEscaloes - escalao)*(nrLugares / nrEscaloes) + 1; // primeiro lugar permissivel para um dado escalao.
        final int nextFirstPermissible = (nrEscaloes - escalao + 1)*(nrLugares / nrEscaloes) + 1;
        int seat = firstPermissible + atribuidos.getOrDefault(escalao, 0);

        // caso não existam mais lugares disponiveis.
        if (seat == nextFirstPermissible) {
            return false;
        }

        lugares.put(f, seat);
        atribuidos.put(escalao, atribuidos.getOrDefault(escalao, 0) + 1);

        return true;
    }

    public Funcionario obterDono(int numero) {
        return lugares.getKey(numero);
    }

    public String atribuidosNoEscalao(int escalao) {
        return atribuidos.getOrDefault(escalao, 0).toString();
    }

    public int obterNumero(String nome) {
        for (Funcionario f : lugares.keySet()) {
            if (f.obterNome().equals(nome)) {
                return lugares.getValue(f);
            }
        }
        return -1;
    }

    public Lugar removerAtribuicaoPorNome(String nome) {
        for (Funcionario f : lugares.keySet()) {
            if (f.obterNome().equalsIgnoreCase(nome)) {
                int escalao = funcionarios.getValue(f.obterNome());
                int lugar = lugares.removeByKey(f);
                // 0 - 1 = -1, so default MUST be 1.
                atribuidos.put(escalao, atribuidos.getOrDefault(escalao, 1) - 1);
                return new Lugar(lugar, funcionarios.getValue(nome));
            }
        }
        return null;
    }

    public Lugar removerAtribuicaoPorNumero(int numero) {
        Lugar lugar = null;

        for (Funcionario f : lugares.keySet()) {
            if (numero == lugares.getValue(f)) {
                int escalao = funcionarios.getValue(f.obterNome());
                lugar = new Lugar(numero, escalao);
                lugares.removeByKey(f);
                // 0 - 1 = -1, so default MUST be 1.
                atribuidos.put(escalao, atribuidos.getOrDefault(escalao, 1) - 1);
                break;
            }
        }
        return lugar;
    }
}