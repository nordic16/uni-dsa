import java.util.Collection;
import java.util.HashMap; //Dica
import java.util.Map;
import java.util.Set;

/**
 * Tabela bidirecional.
 */
public class BidirectionalHashMap<K, V> {
    private final Map<K, V> map;

    /**
     * Construtor
     */
    public BidirectionalHashMap() {
        map = new HashMap<>();
    }

    /**
     * Dado um valor, obter a chave correspondente
     * @param value - o valor
     * @return K - a chave
     */
    public K getKey(V value) {
        for (K k : map.keySet()) {
            if (map.get(k).equals(value)) {
                return k;
            }
        }
        return null;
    }

    /**
     * Dada uma chave, obter o valor correspondente
     * @param key - a chave
     * @return V - o valor
     */
    public V getValue(K key) {
        return map.get(key);
    }

    /**
     * Adicionar um par chave-valor
     * @param key - a chave
     * @param value - o valor
     */
    public void put(K key, V value) {
        map.put(key, value);
    }

    /**
     * Verificar se a tabela contem uma dada chave
     * @param key - a chave
     * @return true se contem a chave, false caso contrario
     */
    public boolean containsKey(K key) {
        return map.containsKey(key);
    }

    /**
     * Verificar se a tabela contem um dado valor
     * @param value - o valor
     * @return true se contem o valor, false caso contrario
     */
    public boolean containsValue(V value) {
        return map.containsValue(value);
    }

    /**
     * Remover um par chave-valor, dada a chave
     * @param key - a chave
     * @return V - o valor previamente associado a chave
     */
    public V removeByKey(K key) {
        return map.remove(key);
    }

    /**
     * Remover um par chave-valor, dado o valor
     * @param value - o valor
     * @return K - a chave previamente associada ao valor
     */
    public K removeByValue(V value) {
        K key = getKey(value);
        map.remove(key);
        return key;
    }

    /**
     * Retornar o tamanho da tabela (numero de pares chave-valor contidos)
     * @return o tamanho da tabela
     */
    public int size() {
        return map.size();
    }

    public Collection<V> values() {
        return map.values();
    }

    public Set<K> keySet() {
        return map.keySet();
    }

}
