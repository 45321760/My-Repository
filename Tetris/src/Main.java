import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class Main extends JFrame implements KeyListener{
    
	App canvas;
	
    class App extends JPanel {
        
        Stage stage;

        public App() {
            setPreferredSize(new Dimension(720, 720));
            stage = new Stage();
        }
        
        public void read(String control) {
        	stage.read(control);
        }

        @Override
        public void paint(Graphics g) {
            stage.paint(g, getMousePosition());
        }

    }

    public static void main(String[] args) throws Exception {
        Main window = new Main();
        window.run();
    }

    private Main() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas = new App();
        this.addKeyListener(this);
        this.setContentPane(canvas);
        this.pack();
        this.setVisible(true);
    }

    public void run() {
        while (true) {
            this.repaint();
        }
    }
    

    public void keyPressed(KeyEvent e) {
    	if(e.getKeyCode() == KeyEvent.VK_SPACE) {
	   		canvas.read("space");
    	} 
    	if(e.getKeyCode() == KeyEvent.VK_W) {
	   		canvas.read("w");
    	}
    	if(e.getKeyCode() == KeyEvent.VK_A) {
	   		canvas.read("a");
    	}    	
    	if(e.getKeyCode() == KeyEvent.VK_S) {
	   		canvas.read("s");
    	}    	
    	if(e.getKeyCode() == KeyEvent.VK_D) {
	   		canvas.read("d");
    	}
    }

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
    
}