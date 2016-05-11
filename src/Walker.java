import java.awt.Color;
import java.awt.Graphics;

public class Walker extends Piece {

	public Walker(int x, int y, int c, Map m) {
		super(Piece.WALKER, m);
		super.setX(x);
		super.setY(y);
		if( c == 0) {super.setColor(Color.RED);}
		else if(c == 1){super.setColor(Color.YELLOW);}
		else {super.setColor(Color.GREEN);}
	}
	
	public Walker(int x, int y, Color c, Map m) {
		super(Piece.WALKER, m);
		super.setX(x);
		super.setY(y);
		super.setColor(c);
	}

	public void act() {
		if(Piece.rand(0, 1)==0){
			move(Piece.rand(0, 3));
		}	
	}
	
	public void painting(Graphics g, int i, int j){
		int h = i * this.getMap().getWidthOfTile();
		int v = j * this.getMap().getHeightOfTile();
		
		g.setColor(this.getColor());
		g.fillOval(h + 1, v, this.getMap().getWidthOfTile() - 2, this.getMap().getHeightOfTile() - 2);
	}
	
	/**
	 * This method is used to move the walker to the random position 0 = up, 1 = right, 2 = down, 3 = left
	 * @param dir is the direction of the walker to move.
	 */
	public void move(int dir){
		if(dir == 0 && this.getMap().isInGrid(this.getX(), this.getY()+1) && this.getMap().pieceAt(this.getX(), this.getY()+1) == null) this.getMap().move(this.getX(), this.getY(), this.getX(), this.getY()+1);
		else if(dir == 1 && this.getMap().isInGrid(this.getX()+1, this.getY()) && this.getMap().pieceAt(this.getX()+1, this.getY()) == null)this.getMap().move(this.getX(), this.getY(), this.getX()+1, this.getY());
		else if(dir == 2 && this.getMap().isInGrid(this.getX(), this.getY()-1) && this.getMap().pieceAt(this.getX(), this.getY()-1) == null)this.getMap().move(this.getX(), this.getY(), this.getX(), this.getY()-1);
		else if(dir == 3 && this.getMap().isInGrid(this.getX()-1, this.getY()) && this.getMap().pieceAt(this.getX()-1, this.getY()) == null)this.getMap().move(this.getX(), this.getY(), this.getX()-1, this.getY());
	}
	
	public String toString(){
		return this.getColorWord()+"Walker at (" + getX() + ", " + getY() + ")";
	}

}
