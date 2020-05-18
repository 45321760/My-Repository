
public class BlockThread implements Runnable{

	Thread t;
	Singleton phase = Singleton.getInstance();
	char stage = 'a';
	Stage temp;
	
	public BlockThread(Stage stage) {
		temp = stage;
	}
	

	public void run(Block c) {
//		while(!Thread.currentThread().isInterrupted()) {
	    	if(stage!=phase.getPhase()) {
//	    		c.drop();
	    		stage=phase.getPhase();
	    	}
//    	}
	}

	@Override
	public void run() {
		run(temp.getCurrBlock());
	}
	
}
