
public interface GameDisplay {
	public int promptForOpponentDifficulty(int maxDifficulty);
	public void displayBoard(GameBoard b);
	public void summarizeMove(Piece item,int newY,int newX);
	public void summarizeMove(Piece item,Piece captured); //if a piece has been captured
	public void gameOver(int winner);
}
