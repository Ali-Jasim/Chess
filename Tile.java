
public class Tile {
	private Piece piece;
	private String content;
	
	//constructors
	public Tile(Piece a) {
		piece = a;
		content = piece.print();
	}
	
	public Tile(){
		content = " ";
		piece = null;
	}
	
	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
		this.content  = piece.print();
	}
	
	public void removePiece(){
		if(this.hasPiece()){
			piece = null;
			this.content = " ";
		}else{
			System.out.println("no piece to remove");
		}
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public void setPrintable(){
		if(this.hasPiece())
			this.content = piece.print();
		else
			this.content = " ";
	}
	
	public boolean hasPiece(){
		if(piece != null){
			return true;
		}else{
			return false;
		}
	}
	
	public String print(){
		return content;
	}
}
