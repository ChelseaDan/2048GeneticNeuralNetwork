import java.util.Random;

/**
 * Created by danielgraaf1 on 28/02/2016.
 */
public class Board {

    private int height;
    private int width;
    private int score;
    private boolean hasChanged;
    public Tile[][] board;

    public Board(int width, int height) {
        setWidth(width);
        setHeight(height);
        board = new Tile[width][height];
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Tile[][] getBoard() {
        return board;
    }

    private Tile generatePiece() {
        Random random = new Random();
        double val = random.nextDouble();
        return (val < 0.9) ? new Tile(2) : new Tile(4);
    }

    public void insertRandom() {
        Random random = new Random();
        int randWidth;
        int randHeight;
        do {
            randWidth = random.nextInt(width);
            randHeight = random.nextInt(height);
        } while (board[randWidth][randHeight] != null);
        board[randWidth][randHeight] = generatePiece();
    }

    public void printBoard() {
        System.out.println("SCORE : " + score + "\n");
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                int val = (board[i][j] == null) ? 0 : board[i][j].getValue();
                String s = "[" + String.format("%04d", val) + "]";
                System.out.print(s);
            }
            System.out.println();
        }
    }

    public void moveLeft() {
        Tile curr = null;
        Tile next = null;
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                curr = board[i][j];
                for (int k = i + 1; k < width; k++) {
                    next = board[k][j];
                    if (curr == null && next != null) {
                        hasChanged = true;
                        board[i][j] = new Tile(next.getValue());
                        board[k][j] = null;
                        curr = board[i][j];
                        next = board[k][j];
                    }
                    if (curr != null && next != null) {
                        if (curr.getValue() == next.getValue()) {
                            hasChanged = true;
                            board[i][j] = new Tile(2 * next.getValue());
                            score += board[i][j].getValue();
                            board[k][j] = null;
                        }
                        break;
                    }
                }
            }
        }
    }

    public void moveUp() {
        Tile curr = null;
        Tile next = null;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                curr = board[i][j];
                for (int k = j + 1; k < height; k++) {
                    next = board[i][k];
                    if (curr == null && next != null) {
                        hasChanged = true;
                        board[i][j] = new Tile(next.getValue());
                        board[i][k] = null;
                        curr = board[i][j];
                        next = board[i][k];
                    }
                    if (curr != null && next != null) {
                        if (curr.getValue() == next.getValue()) {
                            hasChanged = true;
                            board[i][j] = new Tile(2 * next.getValue());
                            score += board[i][j].getValue();
                            board[i][k] = null;
                        }
                        break;
                    }
                }
            }
        }
    }

    public void moveDown() {
        Tile curr = null;
        Tile next = null;
        for (int i = 0; i < width; i++) {
            for (int j = height - 1; j >= 0; j--) {
                curr = board[i][j];
                for (int k = j - 1; k >= 0; k--) {
                    next = board[i][k];
                    if (curr == null && next != null) {
                        hasChanged = true;
                        board[i][j] = new Tile(next.getValue());
                        board[i][k] = null;
                        curr = board[i][j];
                        next = board[i][k];
                    }
                    if (curr != null && next != null) {
                        if (curr.getValue() == next.getValue()) {
                            hasChanged = true;
                            board[i][j] = new Tile(2 * next.getValue());
                            score += board[i][j].getValue();
                            board[i][k] = null;
                        }
                        break;
                    }
                }
            }
        }
    }

    public void moveRight() {
        Tile curr = null;
        Tile next = null;
        for (int j = 0; j < height; j++) {
            for (int i = width - 1; i >= 0; i--) {
                curr = board[i][j];
                for (int k = i - 1; k >= 0; k--) {
                    next = board[k][j];
                    if (curr == null && next != null) {
                        hasChanged = true;
                        board[i][j] = new Tile(next.getValue());
                        board[k][j] = null;
                        curr = board[i][j];
                        next = board[k][j];
                    }
                    if (curr != null && next != null) {
                        if (curr.getValue() == next.getValue()) {
                            hasChanged = true;
                            board[i][j] = new Tile(2 * next.getValue());
                            score += board[i][j].getValue();
                            board[k][j] = null;
                        }
                        break;
                    }
                }
            }
        }
    }



    public boolean getHasChanged() {
        return hasChanged;
    }

    public void setHasChanged() {
        hasChanged = false;
    }


}
