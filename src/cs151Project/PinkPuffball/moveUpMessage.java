package cs151Project.PinkPuffball;
public class moveUpMessage extends Message{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int Yposition;
	
	public moveUpMessage(int Yposition) {
		this.Yposition = Yposition;
	}

	public int getYposition() {
		return Yposition;
	}

	
	

}
