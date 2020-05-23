import java.util.ArrayList;

public interface IFolder {
	public String getName();
	public ArrayList<IFolder> getFolders();
	public ArrayList<IBild> collectPhotos();
}
