import java.awt.Color;
import java.awt.Graphics;

public class Pillar extends Piece {

	public Pillar(int x, int y, int c, Map m) {
		super(Piece.PILLAR, m);
		super.setX(x);
		super.setY(y);
		if( c == 0) {super.setColor(Color.RED);}
		else if(c == 1){super.setColor(Color.YELLOW);}
		else {super.setColor(Color.GREEN);}
	}
	
	public Pillar(int x, int y, Color c, Map m) {
		super(Piece.PILLAR, m);
		super.setX(x);
		super.setY(y);
		super.setColor(c);
	}

	public void act() {
		if(Piece.rand(0, 1) == 0){
			int random = this.rand(0, 2);
			if( random == 0) {super.setColor(Color.RED);}
			else if(random == 1){super.setColor(Color.YELLOW);}
			else {super.setColor(Color.GREEN);}
		}
		
	}
	
	public void painting(Graphics g, int i, int j){
		int h = i * this.getMap().getWidthOfTile();
		int h1 = (i + 1) * this.getMap().getWidthOfTile();
		int v = j * this.getMap().getHeightOfTile();
		int v1 = (j + 1) * this.getMap().getHeightOfTile();
		
		g.setColor(this.getColor());
		g.fillPolygon(new int[] { h + 1, h1 - 1, h + this.getMap().getWidthOfTile() / 2 }, new int[] { v1 - 2, v1 - 2, v }, 3);
	}
	
	public String toString(){
		return this.getColorWord()+"Pillar at (" + getX() + ", " + getY() + ")"; 
	}

}
