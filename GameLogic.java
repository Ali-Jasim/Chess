
public class GameLogic implements ChessController{
	private Display display;
	private GameBoard currBoard;
	private boolean capturedKing;
	
	public GameLogic(Display display){
		this.display = display;
		currBoard = new GameBoard();
		capturedKing = false;
	}
	
	//for testing purposes
	public void printBoard(){
		display.displayBoard(currBoard);
	}
	
	public boolean movePiece(int initY, int initX, int newY, int newX) {
		//assuming the player typed in a number in the range of 1-8 for x,y
		initY--;
		initX--;
		newY--;
		newX--;
		boolean result = false;
		
		Tile initTile = currBoard.getTile(initY, initX);
		Tile toTile = currBoard.getTile(newY, newX);
		
		if(initTile.hasPiece() && initTile.getPiece().isPlayerPiece()){
			
			Piece item = initTile.getPiece();
				
			if(toTile.hasPiece()){
				if(!toTile.getPiece().isPlayerPiece()){
					if(item.validateMove(newY,newX,currBoard)){
						display.summarizeMove(item,toTile.getPiece());
						item.setCoords(newY, newX);
						
						if(!toTile.getPiece().getType().equals("King")) //check if player got the king
							toTile.removePiece();
						else{
							toTile.removePiece();
							capturedKing = true;
						}
						initTile.removePiece();
						toTile.setPiece(item);
						result = true;
					}else{//the piece cannot move that way
						System.out.println("Invalid move!");
					}
				}else{//player tried to capture their own piece
					System.out.println("Cannot capture player piece!");
				}
			}else{
					if(item.validateMove(newY,newX,currBoard)){
						display.summarizeMove(item, newY, newX);
						item.setCoords(newY, newX);
						initTile.removePiece();
						toTile.setPiece(item);
						result = true;
						}else{
						System.out.println("Invalid move!");
						}
				}
		}else{
			System.out.println("Must select valid piece!");
		}
		
		return result;
	}

	
	public GameBoard getCurrBoard() {
		return currBoard;
	}


	public boolean isKingCaptured() {
		return capturedKing;
	}

	public void Reset() {
		currBoard = new GameBoard();
	}

}
