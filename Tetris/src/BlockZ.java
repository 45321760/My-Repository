import java.awt.*;
import java.util.ArrayList;

public class BlockZ extends Block{


	ArrayList<Cell> shape = new ArrayList<Cell>();

    public BlockZ(Cell cLoc) {
    	this.cLoc = cLoc;
        this.loc.add(cLoc);
        this.shapeType = 'Z';
        this.rotation = 0;
        genShape();
        this.colour = Color.RED;
    }
    
    public void rotation() {
    	rotation++;
    	if(rotation > 3) rotation = 0;
    }

}