package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static final char[] board ={' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};
    public static final Scanner input=new Scanner(System.in);

    public static void clrscr(){
        for (int i=0;i<10;i++){
            System.out.println();
        }
    }

    public static void clearBoard(){
        board[1]=' ';board[2]=' ';board[3]=' ';
        board[4]=' ';board[5]=' ';board[6]=' ';
        board[7]=' ';board[8]=' ';board[9]=' ';
    }

    public static void showboard(){
        System.out.println("  "+board[1]+"  |  "+board[2]+"  |  "+board[3]+"\n------------" +
                "---\n"+"  "+board[4]+"  |  "+board[5]+"  |  "+board[6]+"\n-------------" +
                "--\n"+"  "+board[7]+"  |  "+board[8]+"  |  "+board[9]);
    }

    public static int countb(char a)
    {
        int sum=0;
        for(int i=1;i<=9;i++)
        {
            if(board[i]==a)
                sum=sum+1;
        }
        return sum;
    }

    public static char checkWinner(){
        if(board[1]==board[2] && board[2]==board[3] && board[1]!=' ') {
            return board[1];
        }
        if(board[4]==board[5] && board[5]==board[6] && board[4]!=' ') {
            return board[4];
        }
        if(board[7]==board[8] && board[8]==board[9] && board[7]!=' ') {
            return board[7];
        }
        //checking vertically
        if(board[1]==board[4] && board[4]==board[7] && board[1]!=' ') {
            return board[1];
        }
        if(board[2]==board[5] && board[5]==board[8] && board[2]!=' ') {
            return board[2];
        }
        if(board[3]==board[6] && board[6]==board[9] && board[3]!=' ') {
            return board[3];
        }
        //checking diagonally
        if(board[1]==board[5] && board[5]==board[9] && board[1]!=' ') {
            return board[1];
        }
        if(board[3]==board[5] && board[5]==board[7] && board[3]!=' ') {
            return board[3];
        }
        if(countb('X')+countb('O')<=9) {
            return 'C';
        }
        else{
            return 'D';
        }
    }

    public static void player1Move() {
        System.out.println("Enter Player 1 Position between 1 and 9: ");
        while (true) {
            int position = input.nextInt();
            if (position >= 1 && position <= 9) {
                if (board[position] == ' ') {
                    board[position] = 'X';
                    break;
                } else {
                    System.out.println("Enter unoccupied position.");
                }
            }
            else {
                System.out.println("Invalid position\nEnter the position only between 1 and 9");
            }
        }
    }

    public static void player2Move(){
        System.out.println("Enter Player 2 Position between 1 and 9: ");
        while (true) {
            int position = input.nextInt();
            if (position >= 1 && position <= 9) {
                if (board[position] == ' ') {
                    board[position] = 'O';
                    break;
                }
                else {
                    System.out.println("Enter unoccupied position.");
                }
            } else {
                System.out.println("Invalid position\nEnter the position only between 1 and 9");
            }
        }
    }

    public static void compMove(){
        Random rn =new Random();
        while(true) {
            int randomNum = rn.nextInt(9) + 1;
            if(board[randomNum]==' '){
                board[randomNum]='O';
                break;
            }
        }
    }

    public static void playervcomp(){    //player vs computer
        while(true){
            clrscr();
            showboard();
            if(countb('X')==countb('O')){
                player1Move();
            }
            else{
                compMove();
            }
            char win=checkWinner();
            if(win=='X'){
                clrscr();
                showboard();
                System.out.println("You WON the game");
                break;
            }
            else if (win=='O'){
                clrscr();
                showboard();
                System.out.println("You LOST the game");
                break;
            }
            else if (win == 'D') {
                clrscr();
                showboard();
                System.out.println("Game DRAW");
                break;
            }
        }
    }

    public static void playervplayer(){    //player vs player
        while(true){
            clrscr();
            showboard();
            if(countb('X')==countb('O')){
                player1Move();
                showboard();
            }
            else{
                player2Move();
                showboard();
            }
            if(checkWinner()=='X'){
                clrscr();
                showboard();
                System.out.println("Player1 WON the game");
                break;
            }
            else if (checkWinner()=='O'){
                clrscr();
                showboard();
                System.out.println("Player2 WON the game");
                break;
            }
            else if (checkWinner() == 'D') {
                clrscr();
                showboard();
                System.out.println("Game DRAW");
                break;
            }
        }
    }

    public static void main(String[] args) {
        while(true){
            System.out.println("Welcome to Tic Tak Toe game!\n\nEnter Your choice\n1.Player vs Computer" +
                    "\n2.Player vs Player\n3.Exit");
            int ch=input.nextInt();
            clrscr();
            switch (ch){
                case 1:
                    playervcomp();
                    clearBoard();
                    break;
                case 2:
                    playervplayer();
                    clearBoard();
                    break;
                case 3:
                    System.out.println("Thank You!");
                    System.exit(0);
                default:
                    System.out.println("Enter a valid option.");
            }
        }
    }
}