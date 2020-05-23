package lb;

import java.util.List;

public class Provider {

	public void collectPhotos(Folder folder, List<Photo> photos) {
		for (Photo p : folder.getPhotos()) {
			System.out.println(folder.getName() + " : " + p.getName());
		}
	}

}
