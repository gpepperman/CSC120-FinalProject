/**
 * Represents an item in the game. Items can be picked up, put down,
 * eaten, opened, or thrown depending on their properties.
 */
public class Item {
    protected String name; //item name
    protected boolean pickedUp; //if item is currently picked up
    protected boolean eatable; //if item is edible
    protected boolean opens; //if item can be opened 

    /**
     * Constructs a new Item with the given attributes.
     *
     * @param name      the name of the item
     * @param pickedUp  whether the item starts out in the player's hands
     * @param eatable   whether the item can be eaten
     * @param opens     whether the item can be opened
     */
    public Item(String name, boolean pickedUp, boolean eatable, boolean opens) {
        this.name = name;
        this.pickedUp = pickedUp;
        this.eatable = eatable;
        this.opens = opens;
    }

    /**
     * Attempts to pick up the item. Prints a message describing the outcome.
     */
    public void pickUp() {
        if (!pickedUp) {//checks if item is not picked up
            System.out.println("You picked up the " + name + ".");
            pickedUp = true;
        } else {
            System.out.println("You are already holding the " + name + ".");
        }
    }

    /**
     * Attempts to put the item down. Prints a message describing the outcome.
     */
    public void putDown() {
        if (pickedUp) { //checks if item is being held
            System.out.println("You put down the " + name + ".");
            pickedUp = false;
        } else {
            System.out.println("You're not holding the " + name + ".");
        }
    }

    /**
     * Attempts to eat the item if it is edible and currently held.
     * Prints a message describing the outcome.
     */
    public void eat() {
        if (eatable) {//checks if item is edibe
            if (pickedUp) { //checks if item is currently picked up
                System.out.println("You ate " + name + ". So yummy!");
            } else {
                System.out.println("You're not holding the " + name + ".");
            }
        } else {
            System.out.println(name + " is not edible.");
        }
    }

    /**
     * Attempts to open the item if it is openable and currently held.
     * Prints a message describing the outcome.
     */
    public void open() {
        if (opens) { //checks if item opens
            if (pickedUp) { //checks if item is currently picke up
                System.out.println("You have opened " + name + "!");
                System.out.println("Turns out " + name + " is empty and only decorative :(");
            } else {
                System.out.println("You're not holding the " + name + ".");
            }
        } else {
            System.out.println(name + " is not openable.");
        }
    }

    /**
     * Throws this item at the given person if the player is holding it.
     * This action results in an immediate loss.
     *
     * @param p the person at whom the item is thrown
     */
    public void throwAt(Person p) {
        if (pickedUp) {//checks if item is picked up
            System.out.println("You throw the " + name + " at " + p.name + ". *You Lose!*");
        } else {
            System.out.println("You can't throw the " + name + "; you're not holding it.");
        }
    }

    /**
     * Prints a simple description of the item.
     */
    public void lookAt() {
        System.out.println("It is a " + name + ".");
    }
}
