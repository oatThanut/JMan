import java.awt.*;

/** An instance of this class is a J*Man.
 There should at most one J*Man in a game board at a time*/
public class JMan extends Piece {
    
    /** Constructor: a new J*Man at position (x, y) on Map m
     with color red if c = 0, green if c = 1, and yellow if c = 2. */
    public JMan(int x, int y, int c, Map m){
        super(Piece.JMAN, m);
        // Complete this
        super.setX(x);
		super.setY(y);
		if( c == 0) {super.setColor(Color.RED);}
		else if(c == 1){super.setColor(Color.YELLOW);}
		else {super.setColor(Color.GREEN);}
    }
    
    /** Constructor: a new J*Man at position (x, y) on Map m
     with color c. Precondition: c is one of
     Color.RED, Color.GREEN, and Color.YELLOW.*/
    public JMan(int x, int y, Color c, Map m){
        super(Piece.JMAN, m);
        // Complete this;
        super.setX(x);
		super.setY(y);
		super.setColor(c);
    }
    
    /** J*Man should move based on what button is pushed.
     This method is not used. */
    public void act(){return;}
    
    /**
     * This method is used to check that piece are eatable or not
     * @param p is the piece on the board
     * @return if jMan can eat return true
     */
    public boolean isEatable(Piece p){
    	if(p != null){
    		boolean eating;
    		if(getColorWord().equals("Green") && p.getColorWord().equals("Red")){
    			eating = true;
    		}else if(getColorWord().equals("Red") && p.getColorWord().equals("Yellow")){
    			eating = true;
    		}else if(getColorWord().equals("Yellow") && p.getColorWord().equals("Green")){
    			eating = true;
    		}else{
    			eating = false;
    		}
			if (eating)
			setColor(p.getColor());    	
			return eating;
    	}
    	return false;
    }
    
    
    /** Move J*Man one step based on the value of i:
        0 = up, 1 = down, 2 = left, 3 = right. */
    public void step(int i) {
		if (i == 0 && (getMap().isEmpty(getX(), getY()-1) || isEatable(getMap().pieceAt(getX(), getY() - 1)))){
			getMap().move(getX(), getY(), getX(), getY() - 1);
		}
		else if (i == 1 && (getMap().isEmpty(getX(), getY() + 1) || isEatable(getMap().pieceAt(getX(), getY() + 1)))){
			getMap().move(getX(), getY(), getX(), getY() + 1);
		}
		else if (i == 2 && (getMap().isEmpty(getX() - 1, getY()) || isEatable(getMap().pieceAt(getX() - 1, getY())))){
			getMap().move(getX(), getY(), getX() - 1, getY());
		}
		else if (i == 3 && (getMap().isEmpty(getX() + 1, getY()) || isEatable(getMap().pieceAt(getX() + 1, getY())))){
			getMap().move(getX(), getY(), getX() + 1, getY());
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
		g.drawLine(h + 3, v + 2, h1 - 3, v1 - 2);
		g.drawLine(h + 3, v1 - 2, h1 - 3, v + 2);
		g.drawLine(h + 1, v + this.getMap().getHeightOfTile() / 2, h1 - 1, v + this.getMap().getHeightOfTile() / 2);
		g.drawLine(h + this.getMap().getWidthOfTile() / 2, v + 1, h + this.getMap().getWidthOfTile() / 2, v1 - 1);
	}
    
    /** = representation of this piece */
    public String toString() {
        String color= "";
        return getColorWord() + " J*Man at (" + getX() + ", " + getY() + ")";
    }
}
