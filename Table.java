import java.util.ArrayList;

/**
 * Represents a table in the game. A table can hold items, seat guests,
 * and track whether the player is currently sitting at it.
 */
public class Table {
    protected String name; //name of table
    protected boolean sat; //whether the play is sat or not
    protected ArrayList<Item> items; //list of items on table
    protected ArrayList<Person> guests; //list of guests sat at table

    /**
     * Constructs a new Table with the given name and seating state.
     *
     * @param name the name of the table
     * @param sat  whether the player is initially sitting at this table
     */
    public Table(String name, boolean sat) {
        this.name = name;
        this.sat = sat;
        this.items = new ArrayList<>();
        this.guests = new ArrayList<>();
    }

    /**
     * Attempts to sit at the table. Prints a message describing the outcome.
     */
    public void sit() {
        if (this.sat) { //checks if you are already sitting at table
            System.out.println("You are already sitting at " + this.name + ".");
        } else {
            System.out.println("You sit at the " + this.name + ".");
            this.sat = true;
        }
    }

    /**
     * Attempts to stand up from the table. Prints a message describing the outcome.
     */
    public void unSit() {
        if (this.sat) {
            System.out.println("You stand up from the " + this.name + ".");
            this.sat = false;
        } else { //if you are not seated at a table, you cannont stant up
            System.out.println("You are not currently seated.");
        }
    }

    /**
     * Prints the player's current location relative to this table.
     */
    public void locationCheck() {
        if (this.sat) { //if player is sat, tells you location
            System.out.println("You are sitting at the " + this.name + ".");
        } else { //if player is not sat, tells you're standing
            System.out.println("You are standing in the room.");
        }
    }

    /**
     * Prints all items currently on the table. If there are none, prints a message.
     */
    public void lookAtItems() {
        if (items.isEmpty()) { //checks if the table has items
            System.out.println("The " + this.name + " has no items on it.");
        } else { 
            System.out.println("----- Items on " + this.name + " -----");
            for (Item i : items) {
                System.out.println(i.name);
            }
        }
    }

    /**
     * Adds an item to the table if it is not already present.
     *
     * @param i the item to add
     */
    public void addItem(Item i) {
        if (!items.contains(i)) { //checks if item is already on the table
            items.add(i);
        }
    }

    /**
     * Removes an item from the table if it is present.
     *
     * @param i the item to remove
     */
    public void removeItem(Item i) {
        if (items.contains(i)) {//checks if the item is already on the table
            items.remove(i);
        }
    }

    /**
     * Retrieves an item from the table by name (case-insensitive).
     *
     * @param name the name of the item to search for
     * @return the matching Item, or null if none is found
     */
    public Item getItemByName(String name) {
        for (Item i : items) {
            if (i.name.equalsIgnoreCase(name)) {
                return i;
            }
        }
        return null;
    }

    /**
     * Prints all guests currently seated at the table. If none, prints a message.
     */
    public void checkGuests() {
        if (guests.isEmpty()) { //checks if the table has any guests seated at it
            System.out.println("The " + this.name + " has no guests.");
        } else {
            System.out.println("----- Guests at " + this.name + " -----");
            for (Person p : guests) {
                System.out.println(p.name);
            }
        }
    }

    /**
     * Adds a guest to the table if they are not already present.
     *
     * @param p the guest to add
     */
    public void addGuest(Person p) {
        if (!guests.contains(p)) { //checks if the guest is already seated at the table
            guests.add(p);
        }
    }

    /**
     * Removes a guest from the table if present.
     *
     * @param p the guest to remove
     */
    public void removeGuest(Person p) {
        if (guests.contains(p)) { //checks if guest is seated at table
            guests.remove(p);
        }
    }

    /**
     * Retrieves a guest from the table by name (case-insensitive).
     *
     * @param name the name of the guest to search for
     * @return the matching Person, or null if none is found
     */
    public Person getGuestByName(String name) {
        for (Person p : guests) {
            if (p.name.equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }
}