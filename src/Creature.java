public class Creature {

    int energy = 15, fullness = 15, happiness = 15;
    String name;

    public Creature(String name) {
        this.name = name;
    }

    public String checkStatus() {
        String status = "";

        if (this.happiness <= 0 || this.energy <= 0 || this.fullness <= 0) {
            System.out.println("Oh no! " + this.getName() + " has died. You're a terrible owner!");
            System.exit(0);
        }

        if (this.happiness <= 6) {
            status += "Oh, " + this.getName() + " is feeling sad!" + System.lineSeparator();
        }

        if (this.energy <= 6) {
            status += "Hmmm, " + this.getName() + " is really tired!" + System.lineSeparator();
        }

        if (this.fullness <= 6) {
            status += "Whoops, " + this.getName() + " is super hungry!";
        }

        return status;
    }

    public void eat() {
        if (this.fullness >= 12) {
            System.out.println("Whoops, " + this.getName() + " is already full.");
            return;
        }

        this.fullness += 8;
        this.happiness -= 6;
        this.energy -= 4;
        if (this.fullness > 15) this.fullness = 15;

        System.out.println("Yum, " + this.getName() + " really enjoyed that!");
    }

    public String getName() {
        return this.name;
    }

    public void play() {
        this.fullness -= 4;
        this.happiness += 8;
        this.energy -= 6;
        if (this.happiness > 15) this.happiness = 15;

        System.out.println("This was so much fun, let's do it again!");
    }

    public void sleep() {
        if (this.energy >= 12) {
            System.out.println("Whoops, " + this.getName() + " is not that sleepy.");
            return;
        }

        this.fullness -= 5;
        this.happiness -= 5;
        this.energy += 8;
        if (this.energy > 15) this.energy = 15;

        System.out.println("*yawn*, that was a good nap!");
    }

}
