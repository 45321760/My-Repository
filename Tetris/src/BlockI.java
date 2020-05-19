import java.awt.*;
import java.util.ArrayList;

public class BlockI extends Block{


	ArrayList<Cell> shape = new ArrayList<Cell>();

    public BlockI(Cell cLoc) {
    	this.cLoc = cLoc;
        this.loc.add(cLoc);
        this.shapeType = 'I';
        this.rotation = 0;
        genShape();
        this.colour = Color.CYAN;
    }
}