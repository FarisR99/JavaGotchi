import java.util.Scanner;

public class Game {

    private Scanner scanner = new Scanner(System.in);

    private Creature creature = null;

    private boolean userQuit = false;

    private void interact() {
        System.out.println("What would you like to do?");
        System.out.println("1. Play");
        System.out.println("2. Eat");
        System.out.println("3. Sleep");
        System.out.println("4. Quit");

        int choice = this.scanner.nextInt();
        switch (choice) {
            case 1:
                this.creature.play();
                break;
            case 2:
                this.creature.eat();
                break;
            case 3:
                this.creature.sleep();
                break;
            case 4:
                this.userQuit = true;
                break;
            default:
                System.err.println("Whoops, you have to pick a number between 1-4 (inclusive)");
                break;
        }
    }

    public void run() {
        this.startTutorial();

        while (!this.userQuit) {
            this.interact();
            String status = this.creature.checkStatus();
            if (status != null) System.out.println(status);
            else this.userQuit = true;
        }

        this.scanner.close();
        System.out.println("Awh, time to put " + this.creature.getName() + " to sleep :(");
    }

    private void startTutorial() {
        System.out.println("Hi there, welcome to JavaGotchi!");
        System.out.println("What's the name of your creature?");

        String name = this.scanner.nextLine();
        this.creature = new Creature(name);

        System.out.println("Great, you can now meet " + this.creature.getName() + "!");
    }

}
