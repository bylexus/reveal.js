import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		// Aufbau der Ordner- und Photo-Hierarchie:
		Ordner topFolder = new Ordner("Ordner 1");
		Ordner ordner11 = new Ordner("Ordner 1.1");
		Ordner ordner12 = new Ordner("Ordner 1.2");
		Photo photo1 = new JpegPhoto("Photo 1");
		Photo photo2 = new PngPhoto("Photo 2");
		Photo photo3 = new JpegPhoto("Photo 3");
		Photo photo4 = new PngPhoto("Photo 4");
		Photo photo5 = new JpegPhoto("Photo 5");
		
		topFolder.addOrdner(ordner11);
		topFolder.addOrdner(ordner12);
		
		ordner11.addPhoto(photo1);
		ordner11.addPhoto(photo2);
		ordner12.addPhoto(photo3);
		ordner12.addPhoto(photo4);
		topFolder.addPhoto(photo5);
		
		
		
		

		// Demonstration Photo-Sammeln und Ausgeben:
		Main m = new Main();
		List<Photo> photos = new ArrayList<>();
		m.collectPhotos(topFolder, photos);
		for (Photo p : photos) {
			System.out.println("Photo: " + p.title);
		}
	}
	
	/**
	 * Durch das Composite-Pattern gestaltet sich das Sammeln der Photos sehr einfach.
	 */
	public void collectPhotos(Ordner ordner, List<Photo>photos) {
		ordner.collectImages(photos);
	}
}
