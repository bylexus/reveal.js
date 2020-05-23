package lb;

import java.util.ArrayList;
import java.util.List;

public class Folder {
	private String name;
	private List<Folder> subFolders = new ArrayList<Folder>();
	private List<Photo> photos = new ArrayList<Photo>();

	public Folder(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addSubfolder(Folder subFolder) {
		this.subFolders.add(subFolder);
	}

	public List<Folder> getSubFolders() {
		return subFolders;
	}

	public void addPhoto(Photo photo) {
		this.photos.add(photo);
	}

	public List<Photo> getPhotos() {
		return photos;
	}

}
