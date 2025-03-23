package ex1;

public class NovaClasse {
    public static void main(String[] args) {
        int [] devedores = { 142537498, 176483908, 210023492, 198361023 };
        int [] clientes = { 219826341, 210023492, 187232409, 198361023, 198436129 };
        listaLivre(devedores, clientes);
    }

    private static void listaLivre(int[] a, int[] b) {
        ConjuntoDeInteiros c1 = new ConjuntoDeInteiros(a);
        ConjuntoDeInteiros c2 = new ConjuntoDeInteiros(b);

        for (int val : c2.getNumeros()) {
            if (!c1.contem(val)) {
                System.out.println(val);
            }
        }
    }
}
