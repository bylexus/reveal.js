/**
 * Hier eine möglich Implementierung des Stacks...in diesem Fall mit einem Array. 
 */
public class StackImpl implements Stack {

	/**
	 * Wir arbeiten mit globalen Vars...könnte man schöner machen
	 * ANZAHLEL = Konstante....die sagt wieviele Element unser Array von Anfang an hat
	 * array...das ist unser Stack
	 * actualFille...globale Var um den Füllstand zu überprüfen / sehr unschön...ich weiss
	 */
	private static int ANZAHLEL = 20;
	private int [] array = new int[ANZAHLEL]; 
	private int actualFilled = 0;
	
	
	/**
	 * Main-Funktion...hier kommen dann die Anweisungen und Tests rein
	 * @param args
	 */
	public static void main(String[] args) {

		/**
		 * Stack-Objekt erstellen
		 */
		Stack stack = new StackImpl();
		
		/**
		 * Element abfüllen
		 */
		stack.push(34);
		stack.push(45);
		stack.push(56);
		
		/**
		 * Stack ausgeben und einzelne Elemente wieder rausnehmen
		 */
		
		System.out.println("Oberstes Element: " + stack.peek());
		
		((StackImpl)stack).printStack();
		
		stack.pop();

		((StackImpl)stack).printStack();

		stack.pop();

		((StackImpl)stack).printStack();

		stack.pop();

		((StackImpl)stack).printStack();
		
	}
	
	/**
	 * Konstruktor -> siehe Modul bei Herrn Inauen
	 */
	public StackImpl()
	{
		
	}
	
	
	/**
	 * IHRE ARBEIT : Programmieren Sie die pop()-Funktion aus!
	 */
	@Override
	public int pop() {
		return 0;
	}

	/**
	 * IHRE ARBEIT : Programmieren Sie die push()-Funktion aus!
	 */
	@Override
	public void push(int x) {
		

	}
	
	/**
	 * IHRE ARBEIT : Programmieren Sie die peek()-Funktion aus!
	 */
	@Override
	public int peek() {
		return 0;
	}

	/**
	 * IHRE ARBEIT : Programmieren Sie die isEmtpy()-Funktion aus!
	 */
	@Override
	public boolean isEmpty() {

		return true;
	}
	
	/**
	 * Hilfsmethode um den Stack anzuzeigen
	 */
	private void printStack ()
	{
		System.out.print("++++++++++++++++++++++++++++++++++++++++++++++\n");

		for (int i = 0; i < array.length; i++) {
			System.out.print("Position " + i + " / Wert : " + array[i] + "\n");
			
		}
		
		System.out.print("++++++++++++++++++++++++++++++++++++++++++++++\n");

	}

}
