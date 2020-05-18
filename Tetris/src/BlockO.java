import java.awt.*;
import java.util.ArrayList;

public class BlockO extends Block{

	private int rotation = 0;
	ArrayList<Cell> shape = new ArrayList<Cell>();

    public BlockO(Cell cLoc) {
    	this.cLoc = cLoc;
        this.loc.add(cLoc);
        this.shapeType = 'O';
        genShape();
        this.colour = Color.BLUE;
    }
    
    public void rotation() {
    	rotation++;
    	if(rotation > 3) rotation = 0;
    }

}