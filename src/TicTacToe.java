import java.util.Scanner;

public class TicTacToe {

    Scanner sc = new Scanner(System.in);
    char[] board = new char[9];
    int moveCounter;

    /*
    initalizing game board
     */
    public void init() {

        for (int i = 0; i < 9; i++) {
            board[i] = ' ';
        }
        printGameGrid();

    }

    /*
    printing game board
     */
    public void printGameGrid() {
        System.out.println("---------");
        System.out.println("| " + board[0] + " " + board[1] + " " + board[2] + " |");
        System.out.println("| " + board[3] + " " + board[4] + " " + board[5] + " |");
        System.out.println("| " + board[6] + " " + board[7] + " " + board[8] + " |");
        System.out.println("---------");

    }

    /*
    the game is starting until one side wins or draw
     */
    public void startGame() {
        boolean b;
        do {
            makeMove();
            b = controlBoard();
        } while(!b);

    }

    /*
    for each move the input should be like "1 2", if it is valid format, the program will continue
     */
    public void makeMove () {

        String move;
        String newMove = null;
        int m = 0;
        while(true) {
            System.out.print("Enter the coordinates: ");
            move = sc.nextLine();
            if(move.contains(" ")) {
                newMove = move.charAt(0) + "0" + move.charAt(2);
            }
            try {
                m = Integer.parseInt(newMove);
                break;
            } catch (NumberFormatException e) {
            }
            System.out.println("You should enter numbers!");
        }


        int a = m/100;
        int b = m%10;
        checkMove(a,b);

    }

    /*
    checking the coordinates are between 1 to 3 or not
     */
    public void checkMove(int a, int b) {
        if(a <=3 && b<=3) {
            if(checkCell(a,b)) {
                printGameGrid();
            }
        } else {
            System.out.println("Coordinates should be from 1 to 3!");
            makeMove();
        }

    }

    /*
    checking the specific coordinates, and assing new value
     */
    public boolean checkCell(int x, int y) {
        boolean spot = false;
        switch(x) {
            case 1:
                switch(y) {
                    case 1:
                        if(checkSpot(board[0])) {
                            board[0] = play();
                            spot = true;
                        }
                        break;
                    case 2:
                        if(checkSpot(board[1])) {
                            board[1] = play();
                            spot = true;
                        }
                        break;
                    case 3:
                        if(checkSpot(board[2])) {
                            board[2] = play();
                            spot = true;
                        }
                        break;
                }
                break;
            case 2:
                switch(y) {
                    case 1:
                        if(checkSpot(board[3])) {
                            board[3] = play();
                            spot = true;
                        }
                        break;
                    case 2:
                        if(checkSpot(board[4])) {
                            board[4] = play();
                            spot = true;
                        }
                        break;
                    case 3:
                        if(checkSpot(board[5])) {
                            board[5] = play();
                            spot = true;
                        }
                        break;
                }
                break;
            case 3:
                switch(y) {
                    case 1:
                        if(checkSpot(board[6])) {
                            board[6] = play();
                            spot = true;
                        }
                        break;
                    case 2:
                        if(checkSpot(board[7])) {
                            board[7] = play();
                            spot = true;
                        }
                        break;
                    case 3:
                        if(checkSpot(board[8])) {
                            board[8] = play();
                            spot = true;
                        }
                        break;
                }
                break;


        }
        return spot;
    }

    /*
    checking cell is occupied or not
     */
    public boolean checkSpot(char c) {
        boolean cell = false;
        if(c != ' ') {
            System.out.println("The cell is occupied! Choose another one!");
            makeMove();
        } else {
            cell = true;

        }

        return cell;

    }

    /*
    determining whose turn is it
     */
    public char play() {
        moveCounter++;
        if(moveCounter%2 == 1) {
            return 'X';
        }else {
            return 'O';
        }

    }

    /*
    after each move, analyzing the result until the game over condition
     */
    public String analyzeResult() {
        String line = null;
        String result = null;
        boolean lineX = false;
        boolean lineO = false;

        for (int a = 0; a < 8; a++) {
            switch (a) {
                case 0:
                    line = "" + board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = "" + board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = "" + board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = "" + board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = "" + board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = "" + board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = "" + board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = "" + board[2] + board[4] + board[6];
                    break;
            }


            if (line.equals("XXX")) {
                lineX = true;

            } else if (line.equals("OOO")) {
                lineO = true;

            }

        }

        if(!(line.isEmpty())) {
            result = "draw";

        }
        if (lineX) {
            result = "X wins";
        } else if (lineO) {
            result = "O wins";
        }

        return result;

    }

    /*
    the game is going to continue or not
     */
    public boolean controlBoard() {
        boolean situation = false;
        String str = analyzeResult();
        if((str =="Draw") || (str == "X wins") || (str == "O wins")) {
            System.out.println(str);
            situation = true;

        }

        return situation;
    }
}
