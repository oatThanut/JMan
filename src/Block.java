import java.awt.Color;
import java.awt.Graphics;
/**
 * This is the class of white block on the field.
 * @author Thanut Sajjakulnukit (5810545416)
 *
 */
public class Block extends Piece {
	
	/**
	 * This is the constructor of Block
	 * @param x is position x of the Block
	 * @param y is position y of the Block
	 * @param m is the map
	 */
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
	
	/**
     * This is the method that draw the element in field.
     * @param g is the graphic on the field
     * @param height height of grid
     * @param width width of grid
     */
	public void painting(Graphics g, int i, int j){
		int h = i * this.getMap().getHeightOfTile();
		int v = j * this.getMap().getWidthOfTile();
		
		g.setColor(Color.WHITE);
		g.fillRect(h+1, v, this.getMap().getWidthOfTile()-2, this.getMap().getHeightOfTile()-2);
	}
	
	/**
	 * Show position of this object.
	 */
	public String toString(){
		return this.getColorWord()+"Block at (" + getX() + ", " + getY() + ")";
	}

}
