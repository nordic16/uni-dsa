package main.java;

/**
 * Enumerado que representa a prioridade de um trabalho de impressão.
 * É também usado para identificar em qual fila de impressão o trabalho
 * atualmente a ser impresso se encontra.
 * 
 * @author EquipaLabP2425
 */
public enum Priority {
    NORMAL,
    HIGH;
	
	
	
	public static Priority fromString(String p) {
		if (p.equalsIgnoreCase("high")) {
			return HIGH;
		
		} else {
			return NORMAL;
		
		} 
	}
}
