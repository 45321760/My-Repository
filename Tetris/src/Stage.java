import java.awt.*;
import java.io.*;
import java.util.*;


public class Stage{
	Grid grid;
	Block currBlock = null;
	Singleton beat = Singleton.getInstance();
	char phase = 'a';
	int cPlayerScore;
	int oPlayerScore;
	boolean lost;
	ArrayList<ArrayList<Cell>> scoring = new ArrayList<ArrayList<Cell>>();
	public static ArrayList<Cell> blocks= new ArrayList<Cell>();
	ArrayList<Integer> highScores = new ArrayList<Integer>();
	private boolean mouse = false;
	private Point mouseP = null;

	public Stage(){
		cPlayerScore = oPlayerScore = 0;
		lost = false;
		grid = new Grid();
		newBlock();
		createScoringArray();
		getHighScores();
	}    



	private void createScoringArray() {
		for(int i = 0; i < 15; i++){
			scoring.add(new ArrayList<Cell>());
		}
		for(int i = 0; i < 15; i++){
			for(int j = 0; j < 10; j++){
				scoring.get(i).add(new Cell(10+35*j,10+35*i));
			}
		}
	}



	public static ArrayList<Cell> getBlocks(){
		return blocks;
	}

	public void updateBlock(){
		if(phase!=beat.getPhase() && currBlock.loc.size()!=0) {

			if(currBlock.moveDown()) {
				newBlock();
				currBlock.genShape();
			}
			phase=beat.getPhase();
		}
	}

	public Block getCurrBlock() {
		return currBlock;
	}


	public void newBlock() {
		if(currBlock != null) {
			for(Cell c : currBlock.loc) {
				c.setColor(currBlock.colour);
				blocks.add(c);
			}
		}
		Random rnd = new Random();
		int blockNo = rnd.nextInt(7);
		//    	blockNo = 6;
		if(!blocks.contains(new Cell(185, 10))) {
			switch(blockNo) { 
			case 0:
				currBlock = new BlockJ(new Cell(185, 10));
				break;
			case 1:
				currBlock = new BlockL(new Cell(185, 10));
				break;
			case 2:
				currBlock = new BlockO(new Cell(185, 10));
				break;
			case 3:
				currBlock = new BlockS(new Cell(185, 45));
				break;
			case 4:
				currBlock = new BlockT(new Cell(185, 45));
				break;
			case 5:
				currBlock = new BlockZ(new Cell(185, 10));
				break;
			case 6:
				currBlock = new BlockI(new Cell(185, 10));
				break;
			}
		} else {
			lost = true;
		}
	}






	public void paint(Graphics g, Point mouseLoc){
		grid.paint(g,mouseLoc);
		if(currBlock==null) newBlock();
		updateBlock();
		currBlock.genShape();
		currBlock.paint(g);


		try {
			paintHighScores(g);
		} catch (IOException e) {
			e.printStackTrace();
		}

		paintSpareBlock(g);
		score();
		for(int i = 0; i < blocks.size(); i++) {
			blocks.get(i).paint(g,blocks.get(i).c);
		}
		if(lost) {
			paintLost(g);
		}
	}


	public void readM(boolean b, Point p) {
		this.mouse  = b;
		this.mouseP = p;
	}

	public void paintLost(Graphics g) {

		g.setColor(Color.WHITE);
		g.fillRect(0,0,700,550);
		g.setColor(Color.BLACK);
		g.setFont(g.getFont().deriveFont( 50.0f ));

		g.drawString("You've Lost", 210, 150);
		g.drawString("Final Score:", 210, 240);
		g.drawString(new Integer(cPlayerScore).toString(), 330, 320);

		g.setColor(Color.LIGHT_GRAY);;
		g.fillRect(220,330,260,80);
		g.setColor(Color.BLACK);
		g.drawString("Play Again", 230,385);
		if(this.mouseP != null) {
		} if(this.mouseP != null && this.mouse && 
				this.mouseP.x>=220 && 
				this.mouseP.x<=480 && 
				this.mouseP.y>=330 && 
				this.mouseP.y<=410) {
			this.mouseP = null;
			newGame();

		}

	}

	public void newGame() {
		cPlayerScore = oPlayerScore = 0;
		lost = false;
		newBlock();
		getHighScores();
		blocks =  new ArrayList<Cell>();
	}

	public void paintSpareBlock(Graphics g) {
		//Draws box around shape
		g.setColor(Color.WHITE);
		g.fillRect(430, 20, 200, 200);
		g.setColor(Color.BLACK);
		g.drawRect(430, 20, 200, 200);
		Block.paintStored(g);
	}



	public void read(String str) {
		if(currBlock.loc.size()!=0){
			if(str.equals("a")) {
				currBlock.moveLeft();
				currBlock.genShape();
			}if(str.equals("s")) {
				if(currBlock.moveDown()) {
					newBlock();
					currBlock.genShape();
				}
			}if(str.equals("d")) {
				currBlock.moveRight();
				currBlock.genShape();
			}if(str.equals("space")) {
				currBlock.rotation();
				currBlock.genShape();
			}if(str.equals("f")) {
				currBlock = Block.storeBlock(currBlock);
				if(currBlock == null) newBlock();
			}
		}
	}

	public void score(){

		int rows = 0;
		for(int i = scoring.size()-1; i >= 0; i--) {
			if(blocks.containsAll(scoring.get(i))) {
				rows++;
				blocks.removeAll(scoring.get(i));
				//Drops blocks
				for(Cell c : blocks) {
					if(c.y < 10+i*35) {
						c.y += 35;
					}
				}
			}
		}

		oPlayerScore = cPlayerScore;
		if(rows != 0) cPlayerScore += 100*Math.pow(2,rows);

		if(highScores.contains(oPlayerScore)) highScores.remove(new Integer(oPlayerScore));

		highScores.add(cPlayerScore);
		updateHighScores();
		saveHighScores();
	}

	public void paintHighScores(Graphics g) throws IOException {
		g.setFont(g.getFont().deriveFont( 30.0f ));
		g.drawString("Current Score", 400, 270);
		g.setFont(g.getFont().deriveFont( 25.0f ));
		g.drawString(Integer.toString(cPlayerScore), 400, 310);
		g.setFont(g.getFont().deriveFont( 30.0f ));
		g.drawString("Current High Scores", 400, 360);
		g.setFont(g.getFont().deriveFont( 20.0f ));
		for(int i = 0; i < highScores.size(); i++) {
			g.drawString(highScores.get(i).toString(), 400, 400+i*30);
		}
	}


	private void updateHighScores() {
		Collections.sort(highScores, Collections.reverseOrder());
		while(highScores.size() > 5) {
			highScores.remove(5);
		}
	}

	public void getHighScores() {
		try {
			File f = new File("src/HighScoreData.txt");
			f.createNewFile();
			BufferedReader br = new BufferedReader(new FileReader(f));
			String st;
			while((st = br.readLine()) != null) {
				highScores.add(Integer.parseInt(st));
			}
			br.close();
		} catch (IOException e) {}
	}

	public void saveHighScores() {
		try {
			File f = new File("src/HighScoreData.txt");
			f.createNewFile();
			FileWriter wr = new FileWriter("src/HighScoreData.txt");
			for(Integer i : highScores) {
				wr.write(new Integer(i).toString() + "\n");
			}
			wr.close();
		} catch (IOException e) {}
	}





}