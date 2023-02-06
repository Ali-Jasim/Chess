     //-----------------------------------------
     // NAME		: Ali Jasim
     // STUDENT NUMBER	: 7784485
     // COURSE		: COMP 2150
     // INSTRUCTOR	: Olivier
     // ASSIGNMENT	: assignment #3
     //      
     // 
     // REMARKS: Game of chess
     //
     //
	 //-----------------------------------------

import java.util.Scanner;
public class test {
	
	public static void main(String args[]){

		Scanner input = new Scanner(System.in);
		String in="";
		
		do{
			//main menu
			System.out.println("(S)tart or (Q)uit? ");
			in = input.nextLine().toUpperCase();
			
			while(!(in.equals("S") || in.equals("Q"))){
				System.out.println("INVALID INPUT: (S)tart or (Q)uit? ");
				in = input.nextLine().toUpperCase();
			}
			
			if(in.equals("S")){// start the game
				boolean quitGame=false;
				Display display = new Display();
				GameLogic logic = new GameLogic(display);
				Player1 AI = new Player1();//I only implemented one AI
				
				int diff = display.promptForOpponentDifficulty(2); //just to show it works.
				
				
				while(!quitGame){ //loop until king is captured or player enters -1
					int coords=0;
					int initX=-1;
					int initY=-1;
					int newX=-1;
					int newY=-1;
					logic.printBoard();
					//prompt user to select piece
					System.out.println("Enter coords of piece (i.e XY)(-1 to quit back to main menu) :");
					coords = input.nextInt();
					
					if(coords == -1){
						quitGame=true;
					}else{
						initX = coords/10;
						initY = coords%10;
					}
					//make sure input is in the range of 1-8
					while(!quitGame && (initX>8 || initX<1) && (initY>8||initY<1)){
						//prompt user to select piece
						System.out.println("INVALID INPUT: Enter coords of Piece (i.e XY)(-1 to quit back to main menu) :");
						coords = input.nextInt();
						
						if(coords == -1){
							quitGame=true;
						}else{
							initX = coords/10;
							initY = coords%10;
							}
						}
					
				
				//prompt user for move
				if(!quitGame){
					System.out.println("Enter coords of move (i.e XY)(-1 to quit back to main menu) :");
					coords = input.nextInt();
					
					if(coords == -1){
						quitGame=true;
					}else{
						newX = coords/10;
						newY = coords%10;
					}
					//make sure input is in the range of 1-8
					while(!quitGame && (newX>8 || newX<1) && (newY>8||newY<1)){
						//prompt user to select move
						System.out.println("INVALID INPUT: Enter coords of move (i.e XY)(-1 to quit back to main menu) :");
						coords = input.nextInt();
						if(coords == -1){
							quitGame=true;
						}else{
							newX = coords/10;
							newY = coords%10;
						}
					}
				}
					//check if we can make a move
					if(newX!=-1 && newY!=-1 && initX!= -1 && initY != -1){
						if(logic.movePiece(initY, initX, newY, newX)){
							if(logic.isKingCaptured()){
								quitGame=true;
								display.gameOver(1);
								logic.printBoard();
							}else{
								AI.makeMove(initX, initY, newX, newY, logic.getCurrBoard());
								if(AI.isKingCaptured()){
									quitGame=true;
									display.gameOver(2);
									logic.printBoard();
								}
							}
						}
					}
				}
			}
		}while(!in.equals("Q"));
		System.out.println("Exitting Game.");
	}
}
