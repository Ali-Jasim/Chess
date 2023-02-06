
public abstract class Piece {
	protected String toPrint;
	protected boolean playerPiece;
	protected int x,y;
	protected String Type;
	
	public abstract void setPlayerPiece();
	public abstract boolean validateMove(int y,int x,GameBoard b);
	public abstract String pieceType();;

	
	public boolean isPlayerPiece(){
		return playerPiece;
	}
	
	public String getType(){
		return Type;
	}
	
	public String print() {
		return toPrint;
	}
	
	public void setCoords(int y, int x) {
		this.y=y;
		this.x=x;
	}

	public int getY() {
		return y;
	}

	public int getX() {
		return x;
	}
	
}
