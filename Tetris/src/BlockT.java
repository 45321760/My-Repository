import java.awt.*;
import java.util.ArrayList;

public class BlockT extends Block{


	ArrayList<Cell> shape = new ArrayList<Cell>();

    public BlockT(Cell cLoc) {
    	this.cLoc = cLoc;
        this.loc.add(cLoc);
        this.shapeType = 'T';
        this.rotation = 0;
        genShape();
        this.colour = Color.PINK;
    }
    
    public void rotation() {
    	rotation++;
    	if(rotation > 3) rotation = 0;
    }

}