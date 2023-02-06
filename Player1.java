
public class Player1 implements ChessPlayer {
	
	
	private Display display;
	private boolean kingCaptured;
	
	public Player1(){
		display = new Display();
		kingCaptured = false;
	}

	//this is will give us the opposite piece and move to opposite square
	public void makeMove(int X, int Y,int newX,int newY, GameBoard b) {
		
		X--;
		Y--;
		newX--;
		newY--;
		
		
		int moveX=7-X;
		int moveY=7-Y;
		int moveToX=7-newX;
		int moveToY=7-newY;
		
		Tile initTile = b.getTile(moveY, moveX);
		Tile toTile = b.getTile(moveToY, moveToX);
		
		Piece item = initTile.getPiece();
		
		if(toTile.hasPiece()&&toTile.getPiece().isPlayerPiece()){//capturing!
			
				display.summarizeMove(item,toTile.getPiece());
				item.setCoords(newY, newX);
				
				if(toTile.getPiece().getType().equals("King")){
					kingCaptured = true;
					toTile.removePiece();
				}else
					toTile.removePiece();
				
				initTile.removePiece();
				toTile.setPiece(item);
			
		}else{
			
				display.summarizeMove(item, moveToY, moveToX);
				item.setCoords(newY, newX);
				initTile.removePiece();
				toTile.setPiece(item);
			
		}
	}


	public boolean isKingCaptured() {
		return kingCaptured;
	}

	

}
