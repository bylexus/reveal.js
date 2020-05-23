import java.util.Date;

public class Foto {
	private String Format;
	private float Bildgroesse;
	private float Farbraum;
	private String Titel;
	private String beschreibung;
	private String copyright;
	private String Komprimierungsqualitaet;
	private boolean transparenzkanal;
	private Date aufnahmedatum;
	
	void Ordnerhinzufuegen(String ordnername){
		Ordner ordner = new Ordner(ordnername);
		ordner.getOrdner();
	}
}
