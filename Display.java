
import java.util.Scanner;
public class Display implements GameDisplay {
	
	public Display(){
		
	}

	@Override
	public int promptForOpponentDifficulty(int maxDifficulty) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Select difficulty (1-"+maxDifficulty+"): ");
		int diff = in.nextInt();
		
		while(diff>maxDifficulty || diff<1){
			System.out.println("INVALID INPUT. select difficulty (1-"+maxDifficulty+"): ");
			diff = in.nextInt();
		}
		
		
		return diff;
	}

	@Override
	public void displayBoard(GameBoard b) {
		b.print();
	}
	
	@Override
	public void summarizeMove(Piece item, int newY, int newX) {
		System.out.print(item.getType() + " moved from: ("+(item.getY()+1)+","+(item.getX()+1)+")");
		System.out.println(" to ("+(newY+1)+","+(newX+1)+").");
	}

	@Override
	public void summarizeMove(Piece item, Piece captured) {
		System.out.print(item.getType() + " moved from: ("+(item.getY()+1)+","+(item.getX()+1)+")");
		System.out.print(" to: ("+(captured.getY()+1)+","+(captured.getX()+1)+"). ");
		System.out.println(captured.getType() + " captured.");
	}


	@Override
	public void gameOver(int winner) {
		switch(winner){
			case 1: System.out.println("Player Wins.");
					break;
			case 2: System.out.println("Computer Wins.");
					break;
		}
		
	}


}

