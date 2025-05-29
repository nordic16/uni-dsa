public class Gestor {
    private final BidirectionalHashMap<Funcionario, Lugar> lugares; // funcionario -> Lugar
    private final BidirectionalHashMap<String, Integer> funcionarios; // nome -> escalao
    private final BidirectionalHashMap<Integer, Integer> lugaresAtribuidos; // escalao -> nº de lugaresAtribuidos.
    private final BidirectionalHashMap<Integer, Integer> funcionariosAtribuidos; // escalao -> nº de funcionarios atribuidos;

    private final int nrEscaloes;
    private final int nrLugares;
    private final int estrategia;

    /**
     * @param nrEscaloes
     * @param nrLugares
     * @param estrategia
     */
    public Gestor(int nrEscaloes, int nrLugares, int estrategia) {
        this.funcionariosAtribuidos = new BidirectionalHashMap<>();
        this.lugares = new BidirectionalHashMap<>();
        this.funcionarios = new BidirectionalHashMap<>();
        this.lugaresAtribuidos = new BidirectionalHashMap<>();
        this.nrEscaloes = nrEscaloes;
        this.nrLugares = nrLugares;
        this.estrategia = estrategia;
    }

    public int totalAtribuidos() {
        int total = 0;
        for (int i = 1; i <= nrEscaloes; i++) {
            total += lugaresAtribuidos.getOrDefault(i, 0);
        }
        return total;
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

        // strategy 1 is pretty much this.
        int spot = getFirstFreeSpot(escalao);

        // caso estrategia seja 1 e não existam lugares disponíveis...
        if (spot == -1 && estrategia == 1) {
            return false;
        }

        if (estrategia == 2) {
            if (spot == -1) {
                escalao = menorEscalaoLivre(f.obterEscalao());
                if (escalao == -1) { // nao ha escaloes <= max com lugares livres.
                    return false;
                }
                spot = getFirstFreeSpot(escalao);
            }
        }

        lugares.put(f, new Lugar(spot, escalao));
        funcionariosAtribuidos.put(f.obterEscalao(), funcionariosAtribuidos.getOrDefault(f.obterEscalao(), 0)+1);
        lugaresAtribuidos.put(escalao, lugaresAtribuidos.getOrDefault(escalao, 0) + 1);
        return true;
    }

    private int menorEscalaoLivre(int max) {
        for (int i = 1; i < max && i < nrEscaloes; i++) {
            if (atribuidosNoEscalao(i) < nrLugares/nrEscaloes) {
                return i;
            }
        }
        return -1;
    }

    public Funcionario obterDono(int numero) {
        for (Funcionario f : lugares.keySet()) {
            if (lugares.getValue(f).obterNumero() == numero) {
                return f;
            }
        }

        return null;
    }

    public int atribuidosNoEscalao(int escalao) {
        return funcionariosAtribuidos.getOrDefault(escalao, 0);
    }

    public int obterNumero(String nome) {
        for (Funcionario f : lugares.keySet()) {
            if (f.obterNome().equals(nome)) {
                return lugares.getValue(f).obterNumero();
            }
        }
        return -1;
    }

    public Lugar removerAtribuicaoPorNome(String nome) {
        for (Funcionario f : lugares.keySet()) {
            if (f.obterNome().equalsIgnoreCase(nome)) {
                Lugar lugar = lugares.removeByKey(f);
                int escalao = lugar.obterEscalao();
                // 0 - 1 = -1, so default MUST be 1.
                lugaresAtribuidos.put(escalao, lugaresAtribuidos.getOrDefault(escalao, 1) - 1);
                funcionariosAtribuidos.put(f.obterEscalao(), funcionariosAtribuidos.getOrDefault(f.obterEscalao(), 1) - 1);
                return lugar;
            }
        }
        return null;
    }

    public Lugar removerAtribuicaoPorNumero(int numero) {
        Lugar lugar = null;

        for (Funcionario f : lugares.keySet()) {
            if (numero == lugares.getValue(f).obterNumero()) {
                lugar = lugares.removeByKey(f);
                int escalao = lugar.obterEscalao();
                // 0 - 1 = -1, so default MUST be 1.
                funcionariosAtribuidos.put(f.obterEscalao(), funcionariosAtribuidos.getOrDefault(escalao, 1) - 1);
                lugaresAtribuidos.put(escalao, lugaresAtribuidos.getOrDefault(escalao, 1) - 1);
                break;
            }
        }
        return lugar;
    }

    /**
     * Calcula o primeiro lugar permitido.
     * */
    private int calculateFirstPermissible(int escalao) {
        return (nrEscaloes - escalao)*(nrLugares/nrEscaloes) + 1;
    }


    /**
     * finds a discrepancy.
     * */
    private int getFirstFreeSpot(int escalao) {
        int i = calculateFirstPermissible(escalao);
        int max = i + (nrLugares/nrEscaloes);

        for (; i < max; i++) {
            if (!lugares.containsValue(new Lugar(i, escalao))) {
                return i;
            }
        }
        return -1;
    }
}