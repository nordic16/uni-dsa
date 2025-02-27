import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExceptionsExercise {

    /**
     * Le vetor de inteiros, um valor de indice e um valor de potencia.
     * Imprime o numero relativo a aquele indice elevado aquela potencia.
     * 
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(args[0]));
        int tamanho = lerTamanhoVetor(sc);
        int[] inteiros = lerInteirosVetor(sc, tamanho);
        int indice = lerValorIndice(sc);
        double potencia = lerValorPotencia(sc);
        double calculado = calculaPotencias(inteiros, indice, potencia);
        System.out.println(calculado);
    }

    /**
     * Ler um valor que representa o indice do vetor
     * 
     * @param sc - o scanner usado para a leitura
     * @return o valor obtido da leitura
     * @requires sc != null
     */
    private static int lerValorIndice(Scanner sc) {
        return Integer.parseInt(sc.nextLine());
    }

    /**
     * Ler e devolver o tamanho do vetor original
     * 
     * @param sc - o scanner usado para a leitura
     * @return o tamanho do vetor a ler
     * @requires sc != null
     */
    public static int lerTamanhoVetor(Scanner sc) {
        return Integer.parseInt(sc.nextLine());
    }

    /**
     * Ler um dado numero de inteiros e guardar num vetor
     * 
     * @param sc      - o scanner usado para a leitura
     * @param tamanho - o numero de valores a ler
     * @return o vetor de inteiros obtidos da leitura
     * @requires sc != null && tamanho > 0
     */
    public static int[] lerInteirosVetor(Scanner sc, int tamanho) {

        return null;
    }

    /**
     * Ler um valor que representa a potencia
     * 
     * @param sc - o scanner usado para a leitura
     * @return o valor obtido da leitura
     * @requires sc != null
     */
    public static double lerValorPotencia(Scanner sc) {
        return Double.parseDouble(sc.nextLine());
    }

    /**
     * Determina as potencia do valor determinado pelo indice no vector
     * 
     * @param inteiros - o vetor original
     * @param indice - o indice a ser usado no vetor
     * @param expoente - o expoente da potencia que se pretende calcular
     * @return a potencia do valor determinado pelo indice 
     * @requires inteiros != null && potencia >= 0
     */
    private static double calculaPotencias(int[] inteiros, int indice, double expoente) {
        return 0.0;
    }

}