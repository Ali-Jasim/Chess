
public class Knight extends Piece{

	public Knight(int y, int x){
		toPrint = "n";
		playerPiece = false;
		this.y=y;
		this.x=x;
		Type = "Knight";
	}
	
	public void setPlayerPiece(){
		toPrint = "N";
		playerPiece = true;
	}
	

	public boolean validateMove(int newY,int newX,GameBoard b) {
		boolean result = false;
		if(newY<y){
			if(newX-1==x || newX+1==x){
				if(newY+2==y){
					result=true;
				}
			}
			if(newX-2==x || newX+2==x){
				if(newY+1==y){
					result=true;
				}
			}//top half
		}else{
			if(newX-1==x || newX+1==x){
				if(newY-2==y){
					result=true;
				}
			}
			if(newX-2==x || newX+2==x){
				if(newY-1==y){
					result=true;
				}
			}
		}//bottom half
			
		return result;
	}

	public String pieceType(){
		return "Knight";
	}
}
