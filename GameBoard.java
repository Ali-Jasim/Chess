
public class GameBoard {
	
	private Tile tiles[][] = new Tile[8][8];
	
	public GameBoard(){ //initialize tiles
		for(int i = 0; i<8; i++){
			for(int j = 0; j<8;j++){
					if(i == 1 || i == 6){
						tiles[i][j] = new Tile(new Pawn(i,j));
					}else{
						if(i == 0 || i == 7){//add pieces
							switch(j){
								case 0: tiles[i][j] = new Tile(new Rook(i,j));
										break;
								case 1: tiles[i][j] = new Tile(new Knight(i,j));
										break;
								case 2: tiles[i][j] = new Tile(new Bishop(i,j));
										break;
								case 3: tiles[i][j] = new Tile(new King(i,j));
										break;
								case 4: tiles[i][j] = new Tile(new Queen(i,j));
										break;
								case 5: tiles[i][j] = new Tile(new Bishop(i,j));
										break;
								case 6: tiles[i][j] = new Tile(new Knight(i,j));
										break;
								case 7: tiles[i][j] = new Tile(new Rook(i,j));
										break;
							}
						}else
							tiles[i][j] = new Tile();
					}
					
					if(i == 6 || i == 7){
						tiles[i][j].getPiece().setPlayerPiece();
						tiles[i][j].setPrintable();
					}
				}
			}
		}
	
	
	public void print(){
		System.out.println("  1 2 3 4 5 6 7 8");
		System.out.println("------------------");
		for(int i = 0; i<8; i++){
			System.out.print(i+1);
			for(int j = 0; j<8;j++){
					System.out.print("|"+tiles[i][j].print());
				}
			System.out.println("|\n------------------");
			}
	}
	
	public Tile[][] getTiles(){
		return tiles;
	}
	
	public Tile getTile(int y,int x){
		return tiles[y][x];
	}
	
	

}
