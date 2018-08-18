/**
 * 
 * @author chris
 * Hier eine ganze primitive Implementierungsvorschrift....die Definition des abstraken Datentyps Stack
 */
public interface Stack {
	/**
	 * Wir wollen etwas (ein int) im Stack ablegen (keine negativen Zahlen erlaubt)
	 * @param x
	 */
	void push(int x);
	
	/**
	 * Die Funktion pop() gibt uns das oberste Element zurück, und entfernt es aus dem Stack
	 * @return int
	 */
	int pop();
	
    /**
     * Die Funktion peek() liefert das oberste Element, ohne es jedoch aus dem Stack zu entfernen
     * @return int
     */
    int peek();
	
		/**
	 * Gibt einen Boolean zurück ob der Stack leer ist oder nicht
	 * @return
	 */
	boolean isEmpty();
}
