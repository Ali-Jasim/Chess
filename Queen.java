
public class Queen extends Piece{
	
	//where the piece can move
	private int ylimit;
	private int ylimitNeg;
	private int ylimitDiag1;
	private int ylimitDiag2;
	private int ylimitDNeg1;
	private int ylimitDNeg2;
	private int xlimit;
	private int xlimitNeg;
	private int xlimitDiag1;
	private int xlimitDiag2;
	private int xlimitDNeg1;
	private int xlimitDNeg2;

	public Queen(int y, int x){
		toPrint = "q";
		playerPiece = false;
		this.y=y;
		this.x=x;
		Type = "Queen";
		
		//initialize limits
		ylimit = y;
		ylimitNeg = y;
		ylimitDiag1 = y;
		ylimitDiag2 = y;
		ylimitDNeg1 = y;
		ylimitDNeg2 = y;
		xlimit = x;
		xlimitNeg = x;
		xlimitDiag1 = x;
		xlimitDiag2 = x;
		xlimitDNeg1 = x;
		xlimitDNeg2 = x;
	}
	
	public void setPlayerPiece(){
		toPrint = "Q";
		playerPiece = true;
	}
	

	public boolean validateMove(int y,int x) {
		return true;
	}
	
	public String pieceType(){
		return "Queen";
	}
	
	public boolean validateMove(int newY,int newX, GameBoard b) {
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
			}else{//diagonal

				if(newY<y){//up
					if(newX-x>=1){//up-right
						if(newY<=ylimitDiag1 && newX>=xlimitDiag1){
							result = true;
						}
					}else{//up-left
						if(newY<=ylimitDiag2 && newX<=xlimitDNeg2){
							result = true;
						}
					}
				}else{//down
					
					if(newX<x){//down-right
						System.out.println("right "+ylimitDNeg2+" "+xlimitDiag2);
						if(newY>=ylimitDNeg2 && newX<=xlimitDiag2){
							result = true;
						}
					}else{//down-left
						if(newY>=ylimitDNeg1 && newX>=xlimitDNeg1){
							System.out.println("left "+ylimitDNeg1+" "+xlimitDNeg1);
							result= true;
						}
					}
				}
			}
		}
		
	
		
		return result;
	}
	
	//this will scan the board in each direction looking for limits
	//to where the player can move.
	private void updateLimits(GameBoard b){
		ylimit = y;
		ylimitNeg = y;
		ylimitDiag1 = y;
		ylimitDiag2 = y;
		ylimitDNeg1 = y;
		ylimitDNeg2 = y;
		xlimit = x;
		xlimitNeg = x;
		xlimitDiag1 = x;
		xlimitDiag2 = x;
		xlimitDNeg1 = x;
		xlimitDNeg2 = x;
		
		Tile temp = b.getTile(y, x);
		//loop through
		//up
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
		//right-up
		while(temp != null && !temp.hasPiece()&& xlimitDiag1<8 && ylimitDiag1<=0){
			temp = b.getTile(ylimitDiag1, xlimitDiag1);
			xlimitDiag1++;
			ylimitDiag1--;
			
		}
		//left-down
		while(temp != null && !temp.hasPiece()&& xlimitDNeg1>=0 && ylimitDNeg1>=0){
			temp = b.getTile(ylimitDNeg1, xlimitDNeg1);
			xlimitDNeg1--;
			ylimitDNeg1--;
			
		}
		//right-down
		while(temp != null && !temp.hasPiece() && xlimitDiag2<8 && ylimitDNeg2>=0){
			temp = b.getTile(ylimitDiag1, xlimitDiag1);
			xlimitDiag2++;
			ylimitDNeg2--;
			
		}
		//left-up
		while(temp != null && !temp.hasPiece() && xlimitDNeg2>=0 && ylimitDiag2<=0){
			temp = b.getTile(ylimitDiag1, xlimitDiag1);
			xlimitDNeg2--;
			ylimitDiag2--;
			
		}
	}
	

}
