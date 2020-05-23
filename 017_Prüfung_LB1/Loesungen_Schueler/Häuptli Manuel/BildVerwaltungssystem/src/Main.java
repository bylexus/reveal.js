import java.util.ArrayList;

/**
 * Demonstration des Composite-Patterns anhand eines mathematischen
 * Termbaums.
 * 
 * Hier wird die Formel 
 * 
 * 2*(45 - 3*12) + 12 / (4*2) + sin(7*PI)
 * 
 * augebaut, ausgegeben und ausgerechnet.
 */
public class Main {

	public static void main(String[] args) {
		IFolder folder = 
				new Folder("Ornder 1", 	new Bild[] { new Bild("Bild5") }, 
						new IFolder[] {
								new Folder("Ordner 1.1", new Bild[] { new Bild("Bild1"), new Bild("Bild2")}, new IFolder[] {}),
								new Folder("Ordner 1.2", new Bild[] { new Bild("Bild3"), new Bild("Bild4")}, new IFolder[] {})
								});
		
		ArrayList<IBild> bilder = folder.collectPhotos();
		for (IBild iBild : bilder) {
			System.out.println(iBild.getName());
		}
	}
}
