import java.awt.*;
import java.util.ArrayList;

public class BlockZ extends Block{

	private int rotation = 0;
	ArrayList<Cell> shape = new ArrayList<Cell>();

    public BlockZ(Cell cLoc) {
    	this.cLoc = cLoc;
        this.loc.add(cLoc);
        this.shapeType = 'Z';
        genShape();
        this.colour = Color.MAGENTA;
    }
    
    public void rotation() {
    	rotation++;
    	if(rotation > 3) rotation = 0;
    }

}