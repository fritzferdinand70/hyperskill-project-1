package tictactoe;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         //printing an empty grid
        System.out.println("---------");
        System.out.println("|       |");
        System.out.println("|       |");
        System.out.println("|       |");
        System.out.println("---------");

        //default state of S before move 1
        String s = "_________";
        char state [] = s.toCharArray();

        // x & y modes
        int moveNo = 1;
         char xmode = 'X';
        char omode = 'O';


        //coordinates
        int xc = 0;
        int yc = 0;

        //checking if input is numeric
        boolean ok;


        do{

            ok = true;
            //user prompt
            System.out.println("Enter the coordinates:");

            //alternating x & y modes
            char mode;
            if( moveNo % 2 == 0 )  mode = omode;
            else mode = xmode;

            //checking if input is numeric
            try{
                xc = scanner.nextInt();
            }catch(InputMismatchException ime){
                ok  = !ok ;
                System.out.println("You should enter numbers!");
                continue;
            }
            try{
                yc = scanner.nextInt();
            }catch (InputMismatchException ime){
                ok  = !ok ;
                System.out.println("You should enter numbers!");
                continue;
            }

            //checking if coordinates are in range
            if(( xc < 1 || xc >3 || yc < 1 || yc > 3 )) {
                ok = !ok;
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            //checking if the coordinate is empty or valid at current state of the game
            xc --;
            yc--;

            if (xc == 0) {
                if (yc == 0) {
                    if ((s.charAt(0) == '_' || s.charAt(0) == '-')) state[0] = mode;
                    else{
                        System.out.println("This cell is occupied! Choose another one!");
                        ok = !ok;
                        continue;
                    }
                } else if (yc == 1) {
                    if ((s.charAt(1) == '_' || s.charAt(1) == '-')) state[1] = mode;
                    else {
                        System.out.println("This cell is occupied! Choose another one!");
                        ok = !ok;
                        continue;
                    }
                } else if (yc == 2) {
                    if ((s.charAt(2) == '_' || s.charAt(2) == '-')) state[2] = mode;
                    else {
                        System.out.println("This cell is occupied! Choose another one!");
                        ok = !ok;
                        continue;
                    }
                }
            } else if (xc == 1) {
                if (yc == 0) {
                    if ((s.charAt(3) == '_' || s.charAt(3) == '-')) state[3] = mode;
                    else {
                        System.out.println("This cell is occupied! Choose another one!");
                        ok = !ok;
                        continue;
                    }
                } else if (yc == 1) {
                    if ((s.charAt(4) == '_' || s.charAt(4) == '-')) state[4] = mode;
                    else {
                        System.out.println("This cell is occupied! Choose another one!");
                        ok = !ok;
                        continue;
                    }
                } else if (yc == 2) {
                    if ((s.charAt(5) == '_' || s.charAt(5) == '-')) state[5] = mode;
                    else {
                        System.out.println("This cell is occupied! Choose another one!");
                        ok = !ok;
                        continue;
                    }
                }
            }
            if (xc == 2) {
                if (yc == 0) {
                    if ((s.charAt(6) == '_' || s.charAt(6) == '-')) state[6] = mode;
                    else {
                        System.out.println("This cell is occupied! Choose another one!");
                        ok = !ok;
                        continue;
                    }
                } else if (yc == 1) {
                    if ((s.charAt(7) == '_' || s.charAt(7) == '-')) state[7] = mode;
                    else {
                        System.out.println("This cell is occupied! Choose another one!");
                        ok = !ok;
                        continue;
                    }
                } else if (yc == 2) {
                    if ((s.charAt(8) == '_' || s.charAt(8) == '-')) state[8] = mode;
                    else {
                        System.out.println("This cell is occupied! Choose another one!");
                        ok = !ok;
                        continue;
                    }
                }
            }

            //setting current state of the game;
            s = new String(state);
            //checking  the state of game
            boolean isEmptyCells = s.contains("_") || s.contains(" ") ;
            int strikecount = 0;
            char player = 'n';

            //difference between no of Xs and Ys
            int x = 0, o =0;
            for(int i = 0; i<9 ; i++) {
                if(s.charAt(i) == 'X') x++;
                else if (s.charAt(i) == 'O') o++;
            }
            boolean isValidDifference = false;
            if ( Math.abs(x-o) == 1 || x-o == 0) isValidDifference = true;


            //strike through in rows , columns and diagonals
            //row1
            if( ( s.charAt(0) == s.charAt(1) ) && ( s.charAt(1) == s.charAt(2) )){
                player = s.charAt(0);
                if( !(player == '_' || player == '-') )
                strikecount++;
            }
            //row2
            if( ( s.charAt(3) == s.charAt(4) ) && ( s.charAt(4) == s.charAt(5) )){
                player = s.charAt(3);
                if( !(player == '_' || player == '-') )
                    strikecount++;
            }
            //row3
            if( ( s.charAt(6) == s.charAt(7) ) && ( s.charAt(7) == s.charAt(8) )){
                player = s.charAt(6);
                if( !(player == '_' || player == '-') )
                    strikecount++;
            }
            //col1
            if( ( s.charAt(0) == s.charAt(3) ) && ( s.charAt(3) == s.charAt(6) )){
                player = s.charAt(0);
                if( !(player == '_' || player == '-') )
                    strikecount++;
            }
            //col2
            if( ( s.charAt(1) == s.charAt(4) ) && ( s.charAt(4) == s.charAt(7) )){
                player = s.charAt(1);
                if( !(player == '_' || player == '-') )
                    strikecount++;
            }
            //col3
            if( ( s.charAt(2) == s.charAt(5) ) && ( s.charAt(5) == s.charAt(8) )){
                player = s.charAt(2);
                if( !(player == '_' || player == '-') )
                    strikecount++;
            }
            //diag1
            if( ( s.charAt(0) == s.charAt(4) ) && ( s.charAt(4) == s.charAt(8) )){
                player = s.charAt(0);
                if( !(player == '_' || player == '-') )
                    strikecount++;
            }
            //diag2
            if( ( s.charAt(2) == s.charAt(4) ) && ( s.charAt(4) == s.charAt(6) )){
                player = s.charAt(2);
                if( !(player == '_' || player == '-') )
                    strikecount++;
            }

            //conditions
            if(isValidDifference && strikecount < 2){
                //1)Game not finished
                if( isEmptyCells  &&  strikecount == 0 ) {
                    System.out.println("---------");
                    System.out.println("| " + s.charAt(0) + " " + s.charAt(1) + " " + s.charAt(2) + " |");
                    System.out.println("| " + s.charAt(3) + " " + s.charAt(4) + " " + s.charAt(5) + " |");
                    System.out.println("| " + s.charAt(6) + " " + s.charAt(7) + " " + s.charAt(8) + " |");
                    System.out.println("---------");
                    //System.out.println("Game not finished");
                }
                    //2)Draw
                else if (!isEmptyCells && strikecount == 0){
                    System.out.println("---------");
                    System.out.println("| " + s.charAt(0) + " " + s.charAt(1) + " " + s.charAt(2) + " |");
                    System.out.println("| " + s.charAt(3) + " " + s.charAt(4) + " " + s.charAt(5) + " |");
                    System.out.println("| " + s.charAt(6) + " " + s.charAt(7) + " " + s.charAt(8) + " |");
                    System.out.println("---------");
                    System.out.println("Draw");
                    break;
                }
                    //3)X wins or 4)Y wins
                else if (strikecount == 1){
                    System.out.println("---------");
                    System.out.println("| " + s.charAt(0) + " " + s.charAt(1) + " " + s.charAt(2) + " |");
                    System.out.println("| " + s.charAt(3) + " " + s.charAt(4) + " " + s.charAt(5) + " |");
                    System.out.println("| " + s.charAt(6) + " " + s.charAt(7) + " " + s.charAt(8) + " |");
                    System.out.println("---------");
                    System.out.println(player + " wins");
                    break;
                }
            }
            //Impossible
            else{
                System.out.println("---------");
                System.out.println("| " + s.charAt(0) + " " + s.charAt(1) + " " + s.charAt(2) + " |");
                System.out.println("| " + s.charAt(3) + " " + s.charAt(4) + " " + s.charAt(5) + " |");
                System.out.println("| " + s.charAt(6) + " " + s.charAt(7) + " " + s.charAt(8) + " |");
                System.out.println("---------");
                System.out.println("Impossible");
                continue;
            }

            moveNo++;


        }while(moveNo < 10);
        //while((!ok) && moveNo >9)




    }
}
