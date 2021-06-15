import java.util.Scanner;

public class Sudoku {
    public static void main(String[] args) {
        System.out.println("Welcome to Sudoku Game...\n"+
                " C: creates a new game\n"+
                " S: solve the last generated name \n"+
                " Q: Exit");

        Scanner scanner = new Scanner(System.in);
        String command = scanner.next();
        SudokuCreator sudokuCreator=null;
        SudokuSolver sudokuSolver=null;

        while (!command.toLowerCase().equals("q")) {
            if (command.toLowerCase().equals("s")) {
                sudokuSolver = new SudokuSolver(sudokuCreator.getSudoku());
                sudokuSolver.solveSudoku();
                sudokuSolver.printSudoku();
            } else if (command.toLowerCase().equals("c")) {
                sudokuCreator = new SudokuCreator();
                sudokuCreator.printSudoku();
            }
            command=scanner.next();
        }
    }
}
