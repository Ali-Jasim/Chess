
public class Bishop extends Piece{
	
	private int ylimitDiag1;
	private int ylimitDiag2;
	private int ylimitDNeg1;
	private int ylimitDNeg2;
	private int xlimitDiag1;
	private int xlimitDiag2;
	private int xlimitDNeg1;
	private int xlimitDNeg2;
	

	public Bishop(int y, int x){
		toPrint = "b";
		playerPiece = false;
		this.y=y;
		this.x=x;
		Type = "Bishop";
		ylimitDiag1 = y;
		ylimitDiag2 = y;
		ylimitDNeg1 = y;
		ylimitDNeg2 = y;
		xlimitDiag1 = x;
		xlimitDiag2 = x;
		xlimitDNeg1 = x;
		xlimitDNeg2 = x;
	}
	
	public void setPlayerPiece(){
		toPrint = "B";
		playerPiece = true;
	}
	
	
	public boolean validateMove(int newY,int newX,GameBoard b) {
		
		updateLimits(b);
		boolean result = false;
		if(newY<y){//up
			if(newX>x){//up-right
				if(newY<=ylimitDiag1 && newX>=xlimitDiag1){
					result = true;
				}
			}else{//up-left
				if(newY<=ylimitDiag2 && newX<=xlimitDNeg2 && newX!=x){
					result = true;
				}
			}
		}else{//down
			if(newX<x){//down-right
				if(newY>=ylimitDNeg2 && newX<=xlimitDiag2 && newY!=y){
					result = true;
				}
			}else{//down-left
				if(newY>=ylimitDNeg1 && newX>=xlimitDNeg1 && newY!=y){
					result= true;
				}
			}
		}
				
	return result;
}
	
		
	
	
	public void updateLimits(GameBoard b){
		Tile temp  = b.getTile(y, x);
		ylimitDiag1 = y;
		ylimitDiag2 = y;
		ylimitDNeg1 = y;
		ylimitDNeg2 = y;
		xlimitDiag1 = x;
		xlimitDiag2 = x;
		xlimitDNeg1 = x;
		xlimitDNeg2 = x;
		//right-up
		while(temp != null && !temp.hasPiece() && xlimitDiag1<8 && ylimitDiag1<=0){
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
	
	public String pieceType(){
		return "Bishop";
	}


}
