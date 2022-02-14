package cs151Project.PinkPuffball;
public class moveRightMessage extends Message{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	int Xposition;
	
	public moveRightMessage(int Xposition) {
		this.Xposition = Xposition;
	}

	public int getXposition() {
		return Xposition;
	}


	

}
