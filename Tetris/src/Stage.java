import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Stage{
    Grid grid;
    Block BlockJ;
    Block BlockL;
    Block BlockO;
    Block BlockS;
    Block BlockT;
    Block BlockZ;
    Block currBlock = null;
	Singleton beat = Singleton.getInstance();
	char phase = 'a';
	public static ArrayList<Cell> blocks= new ArrayList<Cell>();
    
    public Stage(){
        grid = new Grid();
        newBlock();
        BlockThread t = new BlockThread(this);
        t.run();
    }    
    
    public static ArrayList<Cell> getBlocks(){
    	return blocks;
    }
    
    public void updateBlock(){
    	if(phase!=beat.getPhase() && currBlock.loc.size()!=0) {
    		currBlock.moveDown();
    		phase=beat.getPhase();
    	}
    }
    
    public Block getCurrBlock() {
    	return currBlock;
    }
  
    
    public void newBlock() {
    	if(currBlock != null) {
    		for(Cell c : currBlock.loc)
    			blocks.add(c);
    	}
    	Random rnd = new Random();
    	int blockNo = rnd.nextInt(6);
//    	blockNo = ;
        switch(blockNo) {
	    	case 0:
	    		currBlock = new BlockJ(new Cell(185, 10));
	    		break;
	    	case 1:
	    		currBlock = new BlockL(new Cell(185, 10));
	    		break;
	    	case 2:
	    		currBlock = new BlockO(new Cell(185, 10));
	    		break;
	    	case 3:
	    		currBlock = new BlockS(new Cell(185, 10));
	    		break;
	    	case 4:
	    		currBlock = new BlockT(new Cell(185, 10));
	    		break;
	    	case 5:
	    		currBlock = new BlockZ(new Cell(185, 10));
	    		break;
        }
    }
    


    public void paint(Graphics g, Point mouseLoc){
        grid.paint(g,mouseLoc);
        if(currBlock==null) newBlock();
        updateBlock();
        currBlock.paint(g);
        for(int i = 0; i < blocks.size(); i++) {
        	blocks.get(i).paint(g,currBlock.colour);
        }
    }
    
    public void read(String str) {
    	if(currBlock.loc.size()!=0){
	    	if(str.equals("a")) {
	    		currBlock.moveLeft();
	    	}if(str.equals("s")) {
	    		if(currBlock.moveDown()) {
	    			newBlock();
	    		}
	    	}if(str.equals("d")) {
	    		currBlock.moveRight();
	    	}if(str.equals("space")) {
	    		
	    	}
    	}
    	
    }


}