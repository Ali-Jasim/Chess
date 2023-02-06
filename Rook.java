
public class Rook extends Piece{
	
	private int xlimit;
	private int ylimit;
	private int xlimitNeg;
	private int ylimitNeg;

	public Rook(int y, int x){
		toPrint = "r";
		playerPiece = false;
		this.y=y;
		this.x=x;
		Type = "Rook";
		ylimit = y;
		ylimitNeg = y;
		xlimit = x;
		xlimitNeg = x;
	}
	
	public void setPlayerPiece(){
		toPrint = "R";
		playerPiece = true;
	}
	

	public boolean validateMove(int newY,int newX,GameBoard b) {
		updateLimits(b);
		boolean result = false;
		
		if(x==newX){//vertical
			if(newY-y<=1){ //up
				if(newY<=ylimit){
					result = true;
				}
			}else{ //down
				
				if(newY>=ylimitNeg){
					result = true;
				}
			}
		}else{//horizontal
			if(y==newY){
				if(newX-x<=1){//right
					if(newX<=xlimit){
						result = true;
					}
				}else{//left
					if(newX>=xlimitNeg){
						result = true;
					}
				}
			}
		}
				
		return result;
	}
	
	//scan board for limits
	private void updateLimits(GameBoard b){
		ylimit = y;
		ylimitNeg = y;
		xlimit = x;
		xlimitNeg = x;
		
		Tile temp = b.getTile(y, x);
		while(temp != null && !temp.hasPiece() && ylimit<8){
			temp = b.getTile(ylimit, x);
			ylimit++;
		}
		//right
		while(temp != null && !temp.hasPiece() && xlimit<8){
			temp = b.getTile(y, xlimit);
			xlimit++;
		}
		//down
		while(temp != null && !temp.hasPiece()&& ylimitNeg>=0){
			temp = b.getTile(ylimitNeg, x);
			ylimitNeg--;
		}
		//left
		while(temp != null && !temp.hasPiece()&& xlimitNeg>=0){
			temp = b.getTile(y, xlimitNeg);
			xlimitNeg--;

		}
	}
	
	public String pieceType(){
		return "Rook";
	}

}
