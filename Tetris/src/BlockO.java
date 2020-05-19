import java.awt.*;
import java.util.ArrayList;

public class BlockO extends Block{


	ArrayList<Cell> shape = new ArrayList<Cell>();

    public BlockO(Cell cLoc) {
    	this.cLoc = cLoc;
        this.loc.add(cLoc);
        this.shapeType = 'O';
        this.rotation = 0;
        genShape();
        this.colour = Color.YELLOW;
    }
    
//    public void rotation() {
//    	rotation++;
//    	System.out.println(rotation);
//    	if(rotation > 3) rotation = 0;
//    }

}