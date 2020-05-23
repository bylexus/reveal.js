import java.util.ArrayList;
import java.util.Arrays;

public class Folder implements IFolder {
	private IBild[] bilder = new IBild[] {};
	private IFolder[] folders = new IFolder[] {};
	private String name;
	
	public Folder(String name, IBild[] bilds, IFolder[] iFolders) {
		this.bilder = bilds;
		this.folders = iFolders;
	}
	
	public ArrayList<IBild> collectPhotos() {
		ArrayList<IBild> bilderBilds = new ArrayList<IBild>();
		bilderBilds.addAll(Arrays.asList(this.bilder));
		for (IFolder folder : folders) {
			bilderBilds.addAll(folder.collectPhotos());
		}
		return bilderBilds;
	}
	public void setBilder(IBild[] bilder) {
		this.bilder = bilder;
	}
	
	public ArrayList<IFolder> getFolders() {
		ArrayList<IFolder> bilderBilds = new ArrayList<IFolder>();
		bilderBilds.addAll(Arrays.asList(this.folders));
		for (IFolder folder : folders) {
			bilderBilds.addAll(folder.getFolders());
		}
		return bilderBilds;
	}
	
	public void setFolders(IFolder[] folders) {
		this.folders = folders;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
