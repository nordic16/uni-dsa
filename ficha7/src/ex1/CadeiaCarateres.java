package ex1;

import java.util.Iterator;

public interface CadeiaCarateres extends Iterable<Character> {
    /**
     * O número de elementos nesta cadeia
     */
    int comprimento();
    /* *
     * Concatena a cadeia de caracteres outra no
     * final desta cadeia de caracteres
     *
     * @param outra A cadeia a concatenar
     * @return O resultado da concatena ç ã o
     */
    CadeiaCarateres concat(CadeiaCarateres outra);
    /* *
     * Devolve uma cadeia de caracteres que é uma
     * subcadeia desta cadeia de caracteres
     *
     * @param primeiro O í ndice inicial , inclusiv é
     * @param ultimo O í ndice final , exclusiv é
     * @requires 0 <= primeiro <= ultimo <= comprimento ()
     * @return A subcadeia compreendida entre os
     * dois índices
     */
    CadeiaCarateres subcadeia(int primeiro , int ultimo);
}
