package Task_5;

import java.util.ArrayList;

import static java.lang.Math.abs;

public class Task_4 {
    public static void main(String[] args) {
        int[][] chessBoard = new int[8][8];
        start(chessBoard, 0);
        System.out.printf("Number of combinations: %s", count);
    }
    public static int count = 0;

    static void setQueen(int[][] board, int i, int j) {
        for (int x = 0; x < 8; x++) {
            board[i][x] += 1;
            board[x][j] += 1;
            int shift = abs(i - x);
            if (i != x && j - shift > 0) board[x][j - shift] += 1;
            if (i != x && j + shift < 8) board[x][j + shift] += 1;
        }
        board[i][j] = -1;
    }

    static void removeQueen(int[][] board, int i, int j) {
        for (int x = 0; x < 8; x++) {
            board[i][x] -= 1;
            board[x][j] -= 1;
            int shift = abs(i - x);
            if (i != x && j - shift > 0) board[x][j - shift] -= 1;
            if (i != x && j + shift < 8) board[x][j + shift] -= 1;
        }
        board[i][j] = 0;
    }

    static String showResult(int[][] board) {
        ArrayList<String> result = new ArrayList<String>();
        String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h"};
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == -1) result.add(String.format("%s%d", letters[j], i + 1));
            }
        }
        if (result.size() > 7) {
            count += 1;
            return String.join(", ", result);
        }
        return null;
    }

    static void start(int[][] board, int i) {
        for (int j = 0; j < 8; j++) {
            if (board[i][j] == 0) {
                setQueen(board, i, j);
                if (i == 7) {
                    String result = showResult(board);
                    if (result != null) System.out.println(result);
                }
                else start(board, i + 1);
                removeQueen(board, i, j);
            }
        }
    }
}

