import java.awt.Color;
import java.awt.Graphics;

public class Block extends Piece {

	public Block(int x, int y, Map m) {
		super(Piece.BLOCK, m);
		super.setX(x);
		super.setY(y);
		super.setColor(Color.WHITE);
	}

	/**
	 * This method is used to move the element but
	 * block shouldn't be able to move so this method is not use.
	 */
	public void act() {return;}
	
	public void painting(Graphics g, int i, int j){
		int h = i * this.getMap().getHeightOfTile();
		int v = j * this.getMap().getWidthOfTile();
		
		g.setColor(Color.WHITE);
		g.fillRect(h+1, v, this.getMap().getWidthOfTile()-2, this.getMap().getHeightOfTile()-2);
	}
	
	public String toString(){
		return this.getColorWord()+"Block at (" + getX() + ", " + getY() + ")";
	}

}
