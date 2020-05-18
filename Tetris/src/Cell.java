import java.awt.*;

class Cell extends Rectangle {
    // fields
    static int size = 35;

    //constructors
    public Cell(int x, int y){
        super(x,y,size,size);
    }
    

    //methods
    void paint(Graphics g, Point mousePos){
        g.setColor(Color.WHITE);
        g.fillRect(x,y,size,size);
        g.setColor(Color.BLACK);
        g.drawRect(x,y,size,size);
    }
    
    void paint(Graphics g, Color c){
        g.fillRect(this.x+1,this.y+1,size-2,size-2);
        g.setColor(c);
        g.drawRect(this.x+1,this.y+1,size-2,size-2);
    }

    public boolean contains(Point p){
        if (p != null){
            return super.contains(p);
        } else {
            return false;
        }
    }
    
    public Point toCoord() {
    	
    	return new Point((this.x-10)/35,(this.y-10)/35 );
    }

    

}