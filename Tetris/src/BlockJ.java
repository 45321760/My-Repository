import java.awt.*;
import java.util.ArrayList;

public class BlockJ extends Block{


	ArrayList<Cell> shape = new ArrayList<Cell>();

    public BlockJ(Cell cLoc) {
    	this.cLoc = cLoc;
        this.loc.add(cLoc);
        this.shapeType = 'J';
        this.rotation = 0;
        genShape();
        this.colour = Color.BLUE;
    }
    
//    public void rotation() {
//    	this.rotation++;
//    	System.out.println(this.rotation);
//    	if(this.rotation > 3) rotation = 0;
//    }

}