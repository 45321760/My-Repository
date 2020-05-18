import java.awt.*;
import java.util.ArrayList;

public class BlockS extends Block{

	private int rotation = 0;
	ArrayList<Cell> shape = new ArrayList<Cell>();
	

    public BlockS(Cell cLoc) {
    	this.cLoc = cLoc;
        this.loc.add(cLoc);
        this.shapeType = 'S';
        genShape();
        this.colour = Color.PINK;
    }
    
    public void rotation() {
    	rotation++;
    	if(rotation > 3) rotation = 0;
    }

}