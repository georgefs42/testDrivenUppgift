package se.reky.hakan;

import java.util.Scanner;

public class IOHandler {
    private final Scanner scanner;

    public IOHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public boolean promptForNewGame () {
        System.out.println("Do you want to start a new game? (yes/no)");
        return "yes".equalsIgnoreCase(scanner.nextLine());
    }

    public boolean promptForContinue () {
        System.out.println("Do you want to play again? (yes/no)");
        return "yes".equalsIgnoreCase(scanner.nextLine());
    }

    void displayEndGameMessage() {
        System.out.println("Thank you for playing!");
    }

    void output(String toOutput){
        System.out.println(toOutput);
    }

    public int nextInt (){
        return scanner.nextInt();
    }
    String nextLine(){
        return scanner.nextLine();
    }
    public boolean hasNextInt (){
        return scanner.hasNextInt();
    }

}
