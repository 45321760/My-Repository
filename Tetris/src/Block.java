import java.awt.*;
import java.util.ArrayList;

public abstract class Block {
	Color colour;
	ArrayList<Cell> loc = new ArrayList<Cell>();
	Cell cLoc;
	char shapeType;
	int rotation;
	static Block stored = null;

	public void paint(Graphics g){
		colorCell();
		for(Cell c : loc) {
			g.setColor(c.c);
			g.fillRect(c.x, c.y, 35, 35);
			g.setColor(Color.BLACK);
			g.drawRect(c.x, c.y, 35, 35);
		}
	}

	public void colorCell() {
		for(Cell c : loc) {
			c.c = this.colour;
		}
	}

	public static void paintStored(Graphics g) {
		if(stored == null) return;
		g.setColor(stored.colour);

		if(stored.shapeType == 'J') {
			g.fillRect(495, 75, 35, 35);
			g.fillRect(495, 110, 35, 35);
			g.fillRect(495, 145, 35, 35);
			g.fillRect(530, 75, 35, 35);
			g.setColor(Color.BLACK);
			g.drawRect(495, 75, 35, 35);
			g.drawRect(495, 110, 35, 35);
			g.drawRect(495, 145, 35, 35);
			g.drawRect(530, 75, 35, 35);
		}else if (stored.shapeType=='L') {
			g.fillRect(530, 75, 35, 35);
			g.fillRect(530, 110, 35, 35);
			g.fillRect(530, 145, 35, 35);
			g.fillRect(495, 75, 35, 35);
			g.setColor(Color.BLACK);
			g.drawRect(530, 75, 35, 35);
			g.drawRect(530, 110, 35, 35);
			g.drawRect(530, 145, 35, 35);
			g.drawRect(495, 75, 35, 35);
		}else if (stored.shapeType=='O') {
			g.fillRect(495, 85, 35, 35);
			g.fillRect(495, 120, 35, 35);
			g.fillRect(530, 85, 35, 35);
			g.fillRect(530, 120, 35, 35);
			g.setColor(Color.BLACK);
			g.drawRect(495, 85, 35, 35);
			g.drawRect(495, 120, 35, 35);
			g.drawRect(530, 85, 35, 35);
			g.drawRect(530, 120, 35, 35);
		}else if (stored.shapeType=='S') {
			g.fillRect(500, 105, 35, 35);
			g.fillRect(500, 70, 35, 35);
			g.fillRect(535, 105, 35, 35);
			g.fillRect(535, 140, 35, 35);
			g.setColor(Color.BLACK);
			g.drawRect(500, 105, 35, 35);
			g.drawRect(500, 70, 35, 35);
			g.drawRect(535, 105, 35, 35);
			g.drawRect(535, 140, 35, 35);
		}else if (stored.shapeType=='T') {
			g.fillRect(510, 120, 35, 35);
			g.fillRect(545, 120, 35, 35);
			g.fillRect(475, 120, 35, 35);
			g.fillRect(510, 85, 35, 35);
			g.setColor(Color.BLACK);
			g.drawRect(510, 120, 35, 35);
			g.drawRect(545, 120, 35, 35);
			g.drawRect(475, 120, 35, 35);
			g.drawRect(510, 85, 35, 35);
		}else if (stored.shapeType=='Z') {
			g.fillRect(510, 85, 35, 35);
			g.fillRect(510, 120, 35, 35);
			g.fillRect(475, 85, 35, 35);
			g.fillRect(545, 120, 35, 35);
			g.setColor(Color.BLACK);
			g.drawRect(510, 85, 35, 35);
			g.drawRect(510, 120, 35, 35);
			g.drawRect(475, 85, 35, 35);
			g.drawRect(545, 120, 35, 35);
		}else if (stored.shapeType=='I') {
			g.fillRect(460, 100, 35, 35);
			g.fillRect(495, 100, 35, 35);
			g.fillRect(530, 100, 35, 35);
			g.fillRect(565, 100, 35, 35);
			g.setColor(Color.BLACK);
			g.drawRect(460, 100, 35, 35);
			g.drawRect(495, 100, 35, 35);
			g.drawRect(530, 100, 35, 35);
			g.drawRect(565, 100, 35, 35);
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

	public boolean moveDown() {
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

	public void rotate(int r, ArrayList<Cell> c) {
		if(c.size() != 0) {
			int dx = c.get(0).x;
			int dy = c.get(0).y;
			for(int i = 0; i < r%4; i++) {
				for(Cell d : c) {
					int tempx = d.x - dx;	    		
					int tempy = d.y - dy;
					d.x = -tempy + dx;
					d.y = tempx + dy;
				}
			}
		}
		this.loc = c;
	}

	public static Block storeBlock(Block b) {
		if(stored==null) {
			stored = b;
			return null;
		} else {
			Block temp = stored;
			stored = b;
			return temp;
		}
	}


	public void genShape(){
		while(!this.loc.isEmpty()) this.loc.remove(0);

		if(this.shapeType=='J') {
			this.loc.add(new Cell(cLoc.x,cLoc.y));
			this.loc.add(new Cell(cLoc.x,cLoc.y+35));
			this.loc.add(new Cell(cLoc.x,cLoc.y+70));
			this.loc.add(new Cell(cLoc.x+35,cLoc.y));
			rotation(this.rotation);
		}else if (this.shapeType=='L') {
			this.loc.add(new Cell(cLoc.x,cLoc.y));
			this.loc.add(new Cell(cLoc.x,cLoc.y+35));
			this.loc.add(new Cell(cLoc.x,cLoc.y+70));
			this.loc.add(new Cell(cLoc.x-35,cLoc.y));
			rotation(this.rotation);
		}else if (this.shapeType=='O') {
			this.loc.add(new Cell(cLoc.x,cLoc.y));
			this.loc.add(new Cell(cLoc.x,cLoc.y+35));
			this.loc.add(new Cell(cLoc.x+35,cLoc.y));
			this.loc.add(new Cell(cLoc.x+35,cLoc.y+35));
			rotation(this.rotation);
		}else if (this.shapeType=='S') {
			this.loc.add(new Cell(cLoc.x,cLoc.y));
			this.loc.add(new Cell(cLoc.x,cLoc.y-35));
			this.loc.add(new Cell(cLoc.x+35,cLoc.y));
			this.loc.add(new Cell(cLoc.x+35,cLoc.y+35));
			rotation(this.rotation);
		}else if (this.shapeType=='T') {
			this.loc.add(new Cell(cLoc.x,cLoc.y));
			this.loc.add(new Cell(cLoc.x,cLoc.y-35));
			this.loc.add(new Cell(cLoc.x-35,cLoc.y));
			this.loc.add(new Cell(cLoc.x+35,cLoc.y));
			rotation(this.rotation);
		}else if (this.shapeType=='Z') {
			this.loc.add(new Cell(cLoc.x,cLoc.y));
			this.loc.add(new Cell(cLoc.x,cLoc.y+35));
			this.loc.add(new Cell(cLoc.x-35,cLoc.y));
			this.loc.add(new Cell(cLoc.x+35,cLoc.y+35));
			rotation(this.rotation);
		}else if (this.shapeType=='I') {
			this.loc.add(new Cell(cLoc.x,cLoc.y));
			this.loc.add(new Cell(cLoc.x+35,cLoc.y));
			this.loc.add(new Cell(cLoc.x+70,cLoc.y));
			this.loc.add(new Cell(cLoc.x+105,cLoc.y));
			rotation(this.rotation);
		}
	}


	public void rotation() {
		this.rotation++;

		rotate(this.rotation, this.loc);
	}	

	public void rotation(int r) {
		rotate(r, this.loc);
	}


}