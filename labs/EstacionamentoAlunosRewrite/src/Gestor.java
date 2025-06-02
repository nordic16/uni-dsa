import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Gestor {
    private final int nrLugares;
    private final int nrEscaloes;
    private final int estrategia;

    private final BidirectionalHashMap<Funcionario, Lugar> atribuidos;
    private final Map<Integer, Integer> atribuidosPorEscalao; // escalao -> nº de funcionarios atribuidos.
    private final Map<Integer, Integer> lugaresAtribuidos; // escalao -> nº de lugares atribuidos
    private final Map<String, Funcionario> funcionarios; 

    /**
     * 
     * @param nrEscaloes
     * @param nrLugares
     * @param estrategia
     */
    public Gestor(int nrEscaloes, int nrLugares, int estrategia) {
        this.nrEscaloes = nrEscaloes;
        this.nrLugares = nrLugares;
        this.estrategia = estrategia;

        this.atribuidos = new BidirectionalHashMap<>();
        this.atribuidosPorEscalao = new HashMap<>();
        this.funcionarios = new HashMap<>();
        this.lugaresAtribuidos = new HashMap<>();
    }

    public int totalAtribuidos() {
        int sum = 0;
        for (int s : lugaresAtribuidos.values()) {
            sum += s;
        }
        return sum;
    }

    public int atribuidosNoEscalao(int escalao) {
        return atribuidosPorEscalao.getOrDefault(escalao, 0);
    }

    public boolean registar(String nome, int escalao) {
        if (funcionarios.containsKey(nome)) {
            return false;
        }

        Funcionario f = new Funcionario(nome, escalao);
        funcionarios.put(nome, f);
        return true;
    }

    public boolean atribuir(String nome) {
        Funcionario f = funcionarios.get(nome);
        int escalao = f.obterEscalao();

        if (atribuidos.containsKey(f)) {
            return false;
        }

        int spot = getFirstFreeSpot(f.obterEscalao());

        if (estrategia == 1) {
            if (spot == -1) {
                return false;
            }
            
        
        } else {
        	if (spot == -1) {
        		escalao = menorEscalaoLivre(escalao);
        		if (escalao == -1) { return false; }
        	}
    		spot = getFirstFreeSpot(escalao);		

        }
        atribuidos.put(f, new Lugar(spot, escalao));
        atribuidosPorEscalao.put(f.obterEscalao(), atribuidosPorEscalao.getOrDefault(f.obterEscalao(), 0)+1);
        lugaresAtribuidos.put(escalao, lugaresAtribuidos.getOrDefault(escalao, 0)+1);
        return true;
    }

    public Funcionario obterDono(int numero) {
        for (Lugar l : atribuidos.values()) {
            if (l.obterNumero() == numero) {
                return atribuidos.getKey(l);
            }
        }
        return null;
    }

    public int obterNumero(String nome) {
        Funcionario f = funcionarios.get(nome);
        Lugar l = atribuidos.getValue(f);
        return l == null ? -1 : l.obterNumero();
    }

    public Lugar removerAtribuicaoPorNome(String nome) {
        Funcionario f = funcionarios.get(nome);
        int escalao = f.obterEscalao();
        if (atribuidos.containsKey(f)) {
        	int x = atribuidos.getValue(f).obterEscalao();
            atribuidosPorEscalao.put(escalao, atribuidosPorEscalao.getOrDefault(escalao, 1)-1);
            lugaresAtribuidos.put(x, lugaresAtribuidos.getOrDefault(x, 1)-1);
        }
        return atribuidos.removeByKey(f);
    }

    public Lugar removerAtribuicaoPorNumero(int numero) {
        for (Lugar lugar : atribuidos.values()) {
            if (lugar.obterNumero() == numero) {
            	int escalao = lugar.obterEscalao();
            	int x = atribuidos.getKey(lugar).obterEscalao();
                atribuidosPorEscalao.put(x, atribuidosPorEscalao.getOrDefault(x, 1)-1);
                lugaresAtribuidos.put(escalao, lugaresAtribuidos.getOrDefault(escalao, 1)-1);
                atribuidos.removeByValue(lugar);
                return lugar;
            }
        }
        return null;
    }

    private int calculateFirstPermissible(int escalao) {
        return (nrEscaloes - escalao)*(nrLugares/nrEscaloes) + 1;
    }

    private int getFirstFreeSpot(int escalao) {
        int first = calculateFirstPermissible(escalao);
        int next = first + nrLugares/nrEscaloes;

        for (int i = first; i < next; i++) {
            if (!atribuidos.containsValue(new Lugar(i, escalao))) {
                return i;
            }
        }

        return -1;
    }
    
    private int menorEscalaoLivre(int max) {
    	for (int i = 1; i < max && i < nrEscaloes; i++) {
    		int spot = getFirstFreeSpot(i);
    		if (spot != -1) {
    			return i;
    		}
    	}
    	return -1;
    }
}