import java.util.ArrayList;
import java.util.List;

public class Ordner {
	List<Ordner> childs = new ArrayList<>();
	List<Photo> photos = new ArrayList<>();
	String name;
	
	public Ordner(String name) {
		this.name = name;
	}
	
	public void addOrdner(Ordner o) {
		this.childs.add(o);
	}
	
	public void addPhoto(Photo p) {
		this.photos.add(p);
	}
	
	public void collectImages(List<Photo> photoList) {
		for (Photo p : this.photos) {
			photoList.add(p);
		}
		for (Ordner c : childs) {
			c.collectImages(photoList);
		}
	}
}
