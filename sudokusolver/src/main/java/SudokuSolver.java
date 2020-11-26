public class SudokuSolver {
    private int[][] sudoku;
    private static final int UNASSIGNED=0;

    public SudokuSolver(int[][] sudoku) {
        this.sudoku=sudoku;
    }

    public  boolean solveSudoku() {
        for (int i = 0; i < 9; i++) //satır
        {
            for (int j = 0; j < 9; j++)  //sütun
            {
                if (sudoku[i][j] == UNASSIGNED) {
                    for (int k = 1; k <= 9; k++) {
                        if (isPossible(i, j, k)) {
                            sudoku[i][j] = k;
                            if (solveSudoku()) {
                                return true;
                            } else {
                                sudoku[i][j] = UNASSIGNED;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isPossible(int x, int y, int n) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[x][i] == n) return false;
        }
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][y] == n) return false;
        }

        int xgrid = (x / 3) * 3, ygrid = (y / 3) * 3;


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (sudoku[xgrid+i][ygrid+j] == n) return false;
            }
        }

        return true;
    }

    public void printSudoku() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j]+"\t");
            }
            System.out.print("\n");
        }
    }

}
