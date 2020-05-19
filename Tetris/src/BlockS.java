import java.awt.*;
import java.util.ArrayList;

public class BlockS extends Block{


	ArrayList<Cell> shape = new ArrayList<Cell>();
	

    public BlockS(Cell cLoc) {
    	this.cLoc = cLoc;
        this.loc.add(cLoc);
        this.shapeType = 'S';
        this.rotation = 0;
        genShape();
        this.colour = Color.GREEN;
    }
    
    public void rotation() {
    	rotation++;
    	if(rotation > 3) rotation = 0;
    }

}