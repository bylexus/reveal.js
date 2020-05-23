package lb;

public class Photo {
	private String name;
	private Folder folderRef;

	public Photo(String name, Folder folder) {
		this.setName(name);
		this.setFolderRef(folder);
		folder.addPhoto(this);
	}

	public Folder getFolderRef() {
		return folderRef;
	}

	public String getName() {
		return name;
	}

	public void setFolderRef(Folder folderRef) {
		this.folderRef = folderRef;
	}

	public void setName(String name) {
		this.name = name;
	}

}
