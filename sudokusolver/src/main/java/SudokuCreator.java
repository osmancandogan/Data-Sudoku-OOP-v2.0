public class SudokuCreator {
    private int[][] sudoku;
    private int[][] copyOfSudoku;
    private static final int UNASSIGNED = 0;

    public SudokuCreator() {
        this.sudoku = new int[9][9];
        this.copyOfSudoku = new int[9][9];
        createSudoku();
    }

    public int[][] getSudoku() {
        return sudoku;
    }

    public int[][] getCopyOfSudoku() {
        return copyOfSudoku;
    }

    private void createSudoku() {
        removeCells(this.sudoku);
        removeCells(this.copyOfSudoku);
        int x, y, n;
        int deneme = 0;
        for (int i = 1; i <= 20; ) {
            x = (int) (10 * Math.random()-1);
            y = (int) (10 * Math.random()-1);
            n = (int) (9 * Math.random()+1);
            if (sudoku[x][y] == UNASSIGNED && isPossible(x, y, n)) {
                sudoku[x][y] = n;
                copyOfSudoku[x][y] = n;
                i++;

            }
        }

        SudokuSolver sudokuSolver = new SudokuSolver(this.copyOfSudoku);
        if (!sudokuSolver.solveSudoku()) {
            createSudoku();
        }
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

    private void removeCells(int[][] sudokuGrid) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sudokuGrid[i][j] = UNASSIGNED;
            }
        }
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
