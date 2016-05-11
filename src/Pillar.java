import java.awt.Color;
import java.awt.Graphics;
/**
 * This is the class of the pillar on the field 
 * @author Thanut Sajjakulnukit (5810545416)
 *
 */
public class Pillar extends Piece {
	/**
	 * This is the constructor of pillar
	 * @param x is position x of the pillar
	 * @param y is position y of the pillar
	 * @param c is color of the pillar
	 * @param m is the map
	 */
	public Pillar(int x, int y, int c, Map m) {
		super(Piece.PILLAR, m);
		super.setX(x);
		super.setY(y);
		if( c == 0) {super.setColor(Color.RED);}
		else if(c == 1){super.setColor(Color.YELLOW);}
		else {super.setColor(Color.GREEN);}
	}
	
	/**
	 * This is the constructor of pillar
	 * @param x is position x of the pillar
	 * @param x is position y of the pillar
	 * @param c is color of the pillar
	 * @param m is the map
	 */
	public Pillar(int x, int y, Color c, Map m) {
		super(Piece.PILLAR, m);
		super.setX(x);
		super.setY(y);
		super.setColor(c);
	}
	
	/**
	 * The pillar can change it's color by this method
	 */
	public void act() {
		if(Piece.rand(0, 1) == 0){
			int random = this.rand(0, 2);
			if( random == 0) {super.setColor(Color.RED);}
			else if(random == 1){super.setColor(Color.YELLOW);}
			else {super.setColor(Color.GREEN);}
		}
		
	}
	
	/**
     * This is the method that draw the element in field.
     * @param g is the graphic on the field
     * @param height height of grid
     * @param width width of grid
     */
	public void painting(Graphics g, int i, int j){
		int h = i * this.getMap().getWidthOfTile();
		int h1 = (i + 1) * this.getMap().getWidthOfTile();
		int v = j * this.getMap().getHeightOfTile();
		int v1 = (j + 1) * this.getMap().getHeightOfTile();
		
		g.setColor(this.getColor());
		g.fillPolygon(new int[] { h + 1, h1 - 1, h + this.getMap().getWidthOfTile() / 2 }, new int[] { v1 - 2, v1 - 2, v }, 3);
	}
	
	/**
	 * Show position of this object.
	 */
	public String toString(){
		return this.getColorWord()+"Pillar at (" + getX() + ", " + getY() + ")"; 
	}

}
