public class Item {
    protected String name;
    protected boolean pickedUp;
    protected boolean eatable;
    protected boolean opens;

    public Item(String name, boolean pickedUp, boolean eatable, boolean opens) {
        this.name = name;
        this.pickedUp = pickedUp;
        this.eatable = eatable;
        this.opens = opens;
    }

    public void pickUp() {
        if (!pickedUp) {
            System.out.println("You picked up the " + name + ".");
            pickedUp = true;
        } else {
            System.out.println("You are already holding the " + name + ".");
        }
    }

    public void putDown() {
        if (pickedUp) {
            System.out.println("You put down the " + name + ".");
            pickedUp = false;
        } else {
            System.out.println("You're not holding the " + name + ".");
        }
    }

    public void eat() {
        if (eatable) {
            if(pickedUp){
                System.out.println("You ate " + name + ". So yummy!");
            } else{
                System.out.println("You're not holding the " + name + ".");
            }
        } else {
            System.out.println(name + " is not edible.");
        }
    }

    public void open() {
        if (opens) {
            if(pickedUp){
                System.out.println("You have opened " + name + "!");
            } else{
                System.out.println("You're not holding the " + name + ".");
            }
        } else {
            System.out.println(name + " is not openable.");
        }
    }

    public void throwAt(Person p) {
        if (pickedUp) {
            System.out.println("You throw the " + name + " at " + p.name + ". *You Lose!*");
        } else {
            System.out.println("You can't throw the " + name + "; you're not holding it.");
        }
    }


    public void lookAt() {
        System.out.println("It is a " + name + ".");
    }
}