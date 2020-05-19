import java.awt.*;
import java.util.ArrayList;

public class BlockL extends Block{

	ArrayList<Cell> shape = new ArrayList<Cell>();

    public BlockL(Cell cLoc) {
    	this.cLoc = cLoc;
        this.loc.add(cLoc);
        this.shapeType = 'L';
        this.rotation = 0;
        genShape();
        this.colour = Color.ORANGE;
    }
    
    public void rotation() {
    	rotation++;
    	if(rotation > 3) rotation = 0;
    }

}