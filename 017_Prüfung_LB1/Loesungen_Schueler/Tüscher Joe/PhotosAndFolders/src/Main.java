import java.util.ArrayList;

public class Main {

	public static void main(String[] args) 
	{

		Folder rootFolder = new Folder("Ordner 1");
		Folder f1 = new Folder("Ordner 1.1");
		Folder f2 = new Folder("Ordner 1.2");
		
		rootFolder.AddFolder(f1);
		rootFolder.AddFolder(f2);
		
		Photo p1 = new Photo("Photo 5");
		
		Photo p2 = new Photo("Photo 1");
		Photo p3 = new Photo("Photo 2");
		
		Photo p4 = new Photo("Photo 3");
		Photo p5 = new Photo("Photo 4");
		
		rootFolder.AddPhoto(p1);
		f1.AddPhoto(p2);
		f1.AddPhoto(p3);
		
		f2.AddPhoto(p4);
		f2.AddPhoto(p5);
		
		ArrayList<Photo> photos = new ArrayList<Photo>();
		
		photos = collectPhotos(rootFolder, new ArrayList<Photo>()); // ""collectPhotos(
		
		photos.forEach((p) -> { System.out.println("name: " +p.Name); });
		
		
	}
	public static ArrayList<Photo> collectPhotos(Folder folder, ArrayList<Photo> photos)
	{
		return folder.GetPhotos();
	}

}
