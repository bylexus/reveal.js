package lb;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Provider provider = new Provider();

		// Ordner 1
		Folder ordner1 = new Folder("Ordner 1");
		// Subfolder 1.1
		Folder ordner11 = new Folder("Ordner 1.1");
		// Subfolder 1.2
		Folder ordner12 = new Folder("Ordner 1.2");
		// Add subfolders
		ordner1.addSubfolder(ordner11);
		ordner1.addSubfolder(ordner12);

		// Photo 1
		Photo photo1 = new Photo("Photo 1", ordner11);
		// Photo 2
		Photo photo2 = new Photo("Photo 2", ordner11);
		// Photo 3
		Photo photo3 = new Photo("Photo 3", ordner12);
		// Photo 4
		Photo photo4 = new Photo("Photo 4", ordner12);
		// Photo 4
		Photo photo5 = new Photo("Photo 5", ordner1);

		// Photos in ordner1 / Ordner 1
		provider.collectPhotos(ordner1, new ArrayList<Photo>());

		System.out.println();

		// Photos in ordner11 / Ordner 1.1
		provider.collectPhotos(ordner11, new ArrayList<Photo>());

		System.out.println();

		// Photos in ordner12 / Ordner 1.2
		provider.collectPhotos(ordner12, new ArrayList<Photo>());

	}

}
