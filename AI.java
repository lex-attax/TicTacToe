package tictactoeapplication;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

class AI {

	public int pickSpot(TicTacToe game) {
		ArrayList<Integer> choices = new ArrayList();
		for (int i = 0; i < 9; i++) {
			// If the slot is not taken, add it as a choice
			if (game.board[i] == '-') {
				choices.add(i + 1);
			}
		}
		Random rand = new Random();
		int choice = choices.get(Math.abs(rand.nextInt() % choices.size()));
		return choice;
	}

	public void wait1Sec() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
