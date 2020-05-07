import java.util.*;

public class tic_tac_toe {
    public static void main(String args[]) throws Exception {

        char gameBoard[][] = { { '[', ' ', ']', '[', ' ', ']', '[', ' ', ']' },
                { '[', ' ', ']', '[', ' ', ']', '[', ' ', ']' }, { '[', ' ', ']', '[', ' ', ']', '[', ' ', ']' } };

        ArrayList<Integer> player1 = new ArrayList<Integer>();
        ArrayList<Integer> player2 = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        int count = 0;

        printGameBoard(gameBoard);

        while (true) {
            if (count % 2 == 0) {
                System.out.println("Player_1 set your marker from (1-9): ");
                int num = sc.nextInt();

                while(num<=0 || num>=10){
                    System.out.println("The number is out of range please insert a number from (1-9)");
                    num = sc.nextInt();
                    if(num<=0 || num>=10)
                        continue;
                    else
                        break;
                }

                while (player1.contains(num) || player2.contains(num)) {
                    System.out.println("The place is taken; mark another cell");
                    num = sc.nextInt();
                    if (player1.contains(num) || player2.contains(num))
                        continue;
                    else
                        break;

                }
                player1.add(num);
                setPlayer("Player_1", num, gameBoard);

                if (checkWinner(player1) == true) {

                    printGameBoard(gameBoard);
                    System.out.println("Player_1 is the winner");

                    break;
                }

                if(checkDraw(player1) == true){
                    printGameBoard(gameBoard);
                    System.out.println("Match Draw");
                    break;
                }

                printGameBoard(gameBoard);

            } else {
                System.out.println("Player_2 set your marker from (1-9): ");
                int num = sc.nextInt();

                while(num<=0 || num>=10){
                    System.out.println("The number is out of range please insert a number from (1-9)");
                    num = sc.nextInt();
                    if(num<=0 || num>=9)
                        continue;
                    else
                        break;
                }
                while (player1.contains(num) || player2.contains(num)) {
                    System.out.println("The place is taken; mark another cell");
                    num = sc.nextInt();
                    if (player1.contains(num) || player2.contains(num))
                        continue;
                    else
                        break;

                }
                player2.add(num);
                setPlayer("Player_2", num, gameBoard);

                if (checkWinner(player2) == true) {
                    printGameBoard(gameBoard);
                    System.out.println("Player_2 is the winner");
                    break;
                }

                if(checkDraw(player2) == true){
                    printGameBoard(gameBoard);
                    System.out.println("Match Draw");
                    break;
                }

                printGameBoard(gameBoard);

            }

            count++;
        }

        Thread.sleep(5000);

    }

    public static void printGameBoard(char gameBoard[][]) {
        for (char[] k : gameBoard) {
            for (char i : k)
                System.out.print(i);
            System.out.println();
        }

    }

    public static void setPlayer(String playerName, int id, char[][] gameBoard) {

        char symbol = ' ';

        if (playerName == "Player_1") {
            symbol = 'X';
        }
        if (playerName == "Player_2") {
            symbol = 'O';
        }

        switch (id) {
            case 1:
                gameBoard[0][1] = symbol;
                break;
            case 2:
                gameBoard[0][4] = symbol;
                break;
            case 3:
                gameBoard[0][7] = symbol;
                break;
            case 4:
                gameBoard[1][1] = symbol;
                break;
            case 5:
                gameBoard[1][4] = symbol;
                break;
            case 6:
                gameBoard[1][7] = symbol;
                break;
            case 7:
                gameBoard[2][1] = symbol;
                break;
            case 8:
                gameBoard[2][4] = symbol;
                break;
            case 9:
                gameBoard[2][7] = symbol;
                break;
            default:
                break;
        }

    }

    public static boolean checkWinner(ArrayList<Integer> player) {

        if (player.contains(1) && player.contains(2) && player.contains(3))
            return true;
        else if (player.contains(4) && player.contains(5) && player.contains(6))
            return true;
        else if (player.contains(7) && player.contains(8) && player.contains(9))
            return true;
        else if (player.contains(1) && player.contains(4) && player.contains(7))
            return true;
        else if (player.contains(2) && player.contains(5) && player.contains(8))
            return true;
        else if (player.contains(3) && player.contains(6) && player.contains(9))
            return true;
        else if (player.contains(1) && player.contains(5) && player.contains(9))
            return true;
        else if (player.contains(3) && player.contains(5) && player.contains(7))
            return true;

        return false;

    }

    public static boolean checkDraw(ArrayList<Integer> player){

        if(player.size()>= 5)
            return true;

        return false;
        
    }
}

