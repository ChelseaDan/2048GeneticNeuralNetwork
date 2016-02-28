import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by danielgraaf1 on 28/02/2016.
 */
public class Main {

    public static void main(String[] args) {
        Board board = new Board(4,4);
        board.insertRandom();
        board.printBoard();
       while (true) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                String input;

                while ((input = br.readLine()) != null) {
                    switch (input.charAt(0)) {
                        case 'a':
                            board.moveLeft();
                            break;
                        case 'd':
                            board.moveRight();
                            break;
                        case 'w':
                            board.moveUp();
                            break;
                        case 's':
                            board.moveDown();
                            break;
                    }
                    if (board.getHasChanged()) {
                        board.insertRandom();
                        board.setHasChanged();
                    }
                    board.printBoard();
                }

            } catch (IOException io) {
                io.printStackTrace();
            }
        }


    }

}
