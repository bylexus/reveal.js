import java.util.ArrayList;

public class Folder {
	public String Name;
	public ArrayList<Folder> SubFolders;
	public ArrayList<Photo> Photos;
	
	public Folder(String name)
	{
		this.Name = name;
		this.SubFolders = new ArrayList<Folder>();
		this.Photos = new ArrayList<Photo>();
	}
	public void AddFolder(Folder folder)
	{
		this.SubFolders.add(folder);
	}
	public void RemoveFolder(Folder folder)
	{
		this.SubFolders.remove(folder);
	}
	
	public void AddPhoto(Photo photo)
	{
		if(this.Photos.contains(photo))
			return;
		this.Photos.add(photo);
	}
	public void RemovePhoto(Photo photo)
	{
		this.Photos.remove(photo);
	}
	public ArrayList<Photo> GetPhotos()
	{
		ArrayList<Photo> photos = new ArrayList<Photo>();
		if(this.SubFolders.size() != 0) 
		{
			this.SubFolders.forEach(
				(f) ->
				{
					photos.addAll(f.GetPhotos());
				}
				);
		}
		photos.addAll(this.Photos);
		return photos;
	}
	
}
