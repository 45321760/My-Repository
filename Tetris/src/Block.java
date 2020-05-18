import java.awt.*;
import java.util.ArrayList;

public abstract class Block {
    Color colour;
    ArrayList<Cell> loc = new ArrayList<Cell>();
    Cell cLoc;
    char shapeType;

    public void paint(Graphics g){
    	for(Cell c : loc) {
	        g.setColor(colour);
	        g.fillRect(c.x+1, c.y+1, c.width-2, c.height-2);
	        g.setColor(Color.GRAY);
	        g.drawRect(c.x+1, c.y+1, c.width-2, c.height-2);
    	}
    }
   
    public ArrayList<Cell> getBlocks(){
    	return loc;
    }
    
    public Cell bottomMost() {
//    	System.out.println(loc.toString());
    	Cell lowest = loc.get(0);
    	for(Cell c : loc) {
    		if(c.y > lowest.y)
    			lowest = c;
    	}
    	return lowest;
    }
    
    public Cell rightMost() {
    	Cell right = loc.get(0);
    	for(Cell c : loc) {
    		if(c.x > right.x)
    			right = c;
    	}
    	return right;
    }
    
    public Cell leftMost() {
    	Cell left = loc.get(0);
    	for(Cell c : loc) {
    		if(c.x < left.x)
    			left = c;
    	}
    	return left;
    }
    
    
    public boolean checkDAvail() {  
    	ArrayList<Cell> c = Stage.getBlocks();
	    for(Cell b : this.loc) {	
	    	if(c.contains(new Cell(b.x, b.y+35))) {
	    		return false;
	    	}
	    }
    	return true;
    }
    
    
    public boolean checkLAvail() {
    	ArrayList<Cell> c = Stage.getBlocks();
	    for(Cell b : this.loc) {	
	    	if(c.contains(new Cell(b.x-35, b.y))) {
	    		return false;
	    	}
	    }
    	return true;
    }
    
    public boolean checkRAvail() {
    	ArrayList<Cell> c = Stage.getBlocks();
	    for(Cell b : this.loc) {	
	    	if(c.contains(new Cell(b.x+35, b.y))) {
	    		return false;
	    	}
	    }
    	return true;
    }
    
    public Boolean moveDown() {
    	if(this.bottomMost().y<500 && checkDAvail()) {
    		this.cLoc = new Cell(this.loc.get(0).x, this.loc.get(0).y+35);
    		this.genShape();
        	return false;
    	}
    	return true;
    }
    
    public boolean moveLeft() {
		if(this.leftMost().x>10 && checkLAvail()) {
			this.cLoc = new Cell(this.loc.get(0).x-35, this.loc.get(0).y);
			this.genShape();
	    	return false;
		}
		return true;
	}

    public boolean moveRight() {
		if(this.rightMost().x<325 && checkRAvail()) {
			this.cLoc = new Cell(this.loc.get(0).x+35, this.loc.get(0).y);
			this.genShape();
	    	return false;
		}
		return true;  
	}
    
    
    public void genShape(){
    	while(!this.loc.isEmpty()) this.loc.remove(0);
    	
    	if(this.shapeType=='J') {
		    	this.loc.add(new Cell(cLoc.x,cLoc.y));
		    	this.loc.add(new Cell(cLoc.x,cLoc.y+35));
		    	this.loc.add(new Cell(cLoc.x,cLoc.y+70));
		    	this.loc.add(new Cell(cLoc.x+35,cLoc.y));
    	}else if (this.shapeType=='L') {
		    	this.loc.add(new Cell(cLoc.x,cLoc.y));
		    	this.loc.add(new Cell(cLoc.x,cLoc.y+35));
		    	this.loc.add(new Cell(cLoc.x,cLoc.y+70));
		    	this.loc.add(new Cell(cLoc.x-35,cLoc.y));
    	}else if (this.shapeType=='O') {
		    	this.loc.add(new Cell(cLoc.x,cLoc.y));
		    	this.loc.add(new Cell(cLoc.x,cLoc.y+35));
		    	this.loc.add(new Cell(cLoc.x+35,cLoc.y));
		    	this.loc.add(new Cell(cLoc.x+35,cLoc.y+35));
    	}else if (this.shapeType=='S') {
		    	this.loc.add(new Cell(cLoc.x,cLoc.y));
		    	this.loc.add(new Cell(cLoc.x,cLoc.y-35));
		    	this.loc.add(new Cell(cLoc.x+35,cLoc.y));
		    	this.loc.add(new Cell(cLoc.x+35,cLoc.y+35));
    	}else if (this.shapeType=='T') {
		    	this.loc.add(new Cell(cLoc.x,cLoc.y));
		    	this.loc.add(new Cell(cLoc.x,cLoc.y-35));
		    	this.loc.add(new Cell(cLoc.x-35,cLoc.y));
		    	this.loc.add(new Cell(cLoc.x+35,cLoc.y));
    	}else if (this.shapeType=='Z') {
		    	this.loc.add(new Cell(cLoc.x,cLoc.y));
		    	this.loc.add(new Cell(cLoc.x,cLoc.y+35));
		    	this.loc.add(new Cell(cLoc.x-35,cLoc.y));
		    	this.loc.add(new Cell(cLoc.x+35,cLoc.y+35));
    	}
    }


}