
public class King extends Piece{

	public King(int y, int x){
		toPrint = "k";
		playerPiece = false;
		this.y=y;
		this.x=x;
		Type = "King";
	}
	
	public void setPlayerPiece(){
		toPrint = "K";
		playerPiece = true;
	}

	@Override
	public boolean validateMove(int newY,int newX, GameBoard b) {
		boolean result  = false;
		
		if(y>newY){//up
			if(x==newX){//just up
				if(newY+1 == y){
					result = true;
				}
			}else{
				if(newX+1==x || newX-1==x){
					result = true;
				}
			}
		}else{
			if(y==newY){//horizontal
				if(newX+1 == x || newX-1 ==x){
					result=true;
				}
			}else{//down
				if(x==newX){//just down
					if(newY-1 ==  y){
						result = true;
					}
				}else{//diag
					if(newX+1 == x  || newX-1 == x){
						result = true;
					}
				}
			}
		}
	
		return result;
	}
	
	public String pieceType(){
		return "King";
	}

}
