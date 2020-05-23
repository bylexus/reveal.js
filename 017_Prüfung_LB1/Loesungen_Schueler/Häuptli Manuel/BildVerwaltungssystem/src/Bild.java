
public class Bild implements IBild {
	private String name;
	
	public Bild(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
