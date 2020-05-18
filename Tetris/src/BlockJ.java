import java.awt.*;
import java.util.ArrayList;

public class BlockJ extends Block{
	
	private int rotation = 0;
	ArrayList<Cell> shape = new ArrayList<Cell>();

    public BlockJ(Cell cLoc) {
    	this.cLoc = cLoc;
        this.loc.add(cLoc);
        this.shapeType = 'J';
        genShape();
        this.colour = Color.RED;
    }
    
    public void rotation() {
    	rotation++;
    	if(rotation > 3) rotation = 0;
    }

}