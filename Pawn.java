
public class Pawn extends Piece{
	
	public Pawn(int y, int x){
		toPrint = "p";
		playerPiece = false;
		this.y=y;
		this.x=x;
		Type ="Pawn";
	}
	
	public void setPlayerPiece(){
		toPrint = "P";
		playerPiece = true;
		
	}

	public boolean validateMove(int newY,int newX, GameBoard b) {
		Tile moveTo = b.getTile(newY, newX);
		boolean result = false;
		
		if(moveTo.hasPiece()){//has a piece check if possible to capture
			if(y-newY == 1){
				if(x-newX == 1 || newX-x == 1){
					result=true;
				}
			}
		}else{//move forward
			if(y-newY==1){
				result = true;
			}
		}
		
		return result;
	}
	
	
	
	public String pieceType(){
		return Type;
	}


}
