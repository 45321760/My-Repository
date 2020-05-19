import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class Main extends JFrame implements KeyListener, MouseListener{

	private static final long serialVersionUID = 558385498635889553L;
	App canvas;

	class App extends JPanel {

		private static final long serialVersionUID = 1L;
		Stage stage;

		public App() {
			setPreferredSize(new Dimension(700, 550));
			stage = new Stage();
		}

		public void read(String control) {
			stage.read(control);
		}

		@Override
		public void paint(Graphics g) {
			stage.paint(g, getMousePosition());
		}

		public void readM( boolean b) {
			stage.readM(b, getMousePosition());
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
		addMouseListener(this);
		this.setTitle("Tetris by Thomas Cowan - thomas.cowan64@gmail.com");
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
		if(e.getKeyCode() == KeyEvent.VK_A) {
			canvas.read("a");
		}    	
		if(e.getKeyCode() == KeyEvent.VK_S) {
			canvas.read("s");
		}    	
		if(e.getKeyCode() == KeyEvent.VK_D) {
			canvas.read("d");
		}  	
		if(e.getKeyCode() == KeyEvent.VK_F) {
			canvas.read("f");
		}
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		canvas.readM(true);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		canvas.readM(true);
	}
}