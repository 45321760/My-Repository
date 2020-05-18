import java.awt.*;
import java.util.ArrayList;

public class BlockT extends Block{

	private int rotation = 0;
	ArrayList<Cell> shape = new ArrayList<Cell>();

    public BlockT(Cell cLoc) {
    	this.cLoc = cLoc;
        this.loc.add(cLoc);
        this.shapeType = 'T';
        genShape();
        this.colour = Color.GRAY;
    }
    
    public void rotation() {
    	rotation++;
    	if(rotation > 3) rotation = 0;
    }

}