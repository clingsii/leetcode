package com.lc.leetcode;

/**
 * Created by caoling on 2016/11/6.
 * <p>
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * <p>
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 */
public class T36 {

    public static boolean isValidSudoku(char[][] board) {
        int fullSize = 9;
        int zero = (int) '0';
        for (int i = 0; i < fullSize; i++) {
            boolean[] rowTags = new boolean[fullSize + 1];
            boolean[] colTags = new boolean[fullSize + 1];
            for (int j = 0; j < fullSize; j++) {
                int vRow = board[i][j] - zero;
                if (vRow > 0 && vRow < 10) {
                    if (!rowTags[vRow]) {
                        rowTags[vRow] = true;
                    } else {
                        return false;
                    }
                }

                int vCol = board[j][i] - zero;
                if (vCol > 0 && vCol < 10) {
                    if (!colTags[vCol]) {
                        colTags[vCol] = true;
                    } else {
                        return false;
                    }
                }
            }
        }


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                int startX = i * 3;
                int startY = j * 3;
                boolean[] data = new boolean[fullSize + 1];

                for (int col = 0; col < 3; col++) {
                    for (int row = 0; row < 3; row++) {
                        int x = startX + row;
                        int y = startY + col;
                        int v = board[x][y] - zero;
                        if (v > 0 && v < 10) {
                            if (!data[v]) {
                                data[v] = true;
                            } else {
                                return false;
                            }
                        }
                    }
                }

            }
        }

        return true;

    }

    public static void main(String[] args) {
        String[] s = {".87654321", "2........", "3........", "4........", "5........", "6........", "7........", "8........"
                , "9........"};

        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = s[i].charAt(j);
            }
        }

        System.out.println(isValidSudoku(board));
    }
}
