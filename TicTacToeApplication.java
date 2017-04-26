package tictactoeapplication;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TicTacToeApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Getting inupt
		Scanner sc = new Scanner(System.in);
		// Allows for cont. games
		boolean doYouWantToPlay = true;

		while (doYouWantToPlay) {
			// setting up our tokens and AI
			System.out.println("Welcome to Tic Tac Toe! You are about to go against "
					+ "the master of Tic Tac Toe. Are you ready? I hope so!\nBUT FIRST, you"
					+ " must pick what character you want to be and which character I will be.");
			
			System.out.println();
			System.out.println("Enter a single character that will represent you on the board:");
			
			char playerToken = sc.next().charAt(0);
			System.out.println("Enter a singe character that will represent your opponent on the board:");
			
			char opponentToken = sc.next().charAt(0);
			TicTacToe game = new TicTacToe(playerToken, opponentToken);
			AI ai = new AI();

			// Set up the game
			System.out.println();
			System.out.println("Now we can start the game. To play, enter a number and your token shall be put"
					+ " in its place.\nThe numbers go from 1-9, left to right. We shall see who will win this round.");
			TicTacToe.printIndexBoard();
			System.out.println();

			// Let's play!
			while (game.gameOver().equals("notOver")) {
				if (game.currentMarker == game.userMarker) {
					// USER TURN
					System.out.println();
					System.out.println("It's your turn! Enter a spot for your token");
					int spot = sc.nextInt();
					while (!game.playTurn(spot)) {
						ai.wait1Sec();
						System.out.println("Try again. " + spot + " is invalid. This spot is already taken"
								+ " or it is out of range");
						spot = sc.nextInt();
	
					}
					System.out.println("You picked " + spot + "!");
					ai.wait1Sec();
				} else {
					//AI Turn
					System.out.println();

					System.out.println("It's my turn!");
					// Pick Spot
					int aiSpot = ai.pickSpot(game);
					game.playTurn(aiSpot);
					System.out.println();
					System.out.println("I picked " + aiSpot+"!");
					ai.wait1Sec();
					
								
				}
				// Print out new board
				System.out.println();
				game.printBoard();
			}
			System.out.println(game.gameOver());
			System.out.println();
			// Set up a new game... or not, depending on the response
			System.out.println("Do you want to play again? Enter Y if you do. "
					+ "Enter anything else if you are tired of me.");
			char response = sc.next().charAt(0);
			doYouWantToPlay = (response == 'Y');
			doYouWantToPlay = (response == 'y');
			System.out.println();
			System.out.println();
		}
	}

}

// https://youtu.be/edg25CkMtOc?t=1915
