import java.awt.*;
import java.util.ArrayList;

public class BlockL extends Block{
	private int rotation = 0;
	ArrayList<Cell> shape = new ArrayList<Cell>();

    public BlockL(Cell cLoc) {
    	this.cLoc = cLoc;
        this.loc.add(cLoc);
        this.shapeType = 'L';
        genShape();
        this.colour = Color.GREEN;
    }
    
    public void rotation() {
    	rotation++;
    	if(rotation > 3) rotation = 0;
    }

}