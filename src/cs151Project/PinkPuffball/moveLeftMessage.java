package cs151Project.PinkPuffball;
public class moveLeftMessage extends Message{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	int Xposition;
	
	public moveLeftMessage(int Xposition) {
		this.Xposition = Xposition;
	}

	public int getXposition() {
		return Xposition;
	}

}
