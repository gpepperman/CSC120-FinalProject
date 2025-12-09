import java.util.ArrayList;

public class Table {
    protected String name;
    protected boolean sat;
    protected ArrayList<Item> items;
    protected ArrayList<Person> guests;

    public Table(String name, boolean sat) {
        this.name = name;
        this.sat = sat;
        this.items = new ArrayList<>();
        this.guests = new ArrayList<>();
    }

    public void sit() {
        if (this.sat) {
            System.out.println("You are already sitting at " + this.name + ".");
        } else {
            System.out.println("You sit at the " + this.name + ".");
            this.sat = true;
        }
    }

    public void unSit() {
        if (this.sat) {
            System.out.println("You stand up from the " + this.name + ".");
            this.sat = false;
        } else {
            System.out.println("You are not currently seated anywhere.");
        }
    }

    public void locationCheck() {
        if (this.sat) {
            System.out.println("You are sitting at the " + this.name + ".");
        } else {
            System.out.println("You are standing in the room.");
        }
    }

    public void lookAtItems() {
        if (items.isEmpty()) {
            System.out.println("The " + this.name + " has no items on it.");
        } else {
            System.out.println("----- Items on " + this.name + " -----");
            for (Item i : items) {
                System.out.println(i.name);
            }
        }
    }

    public void addItem(Item i) {
        if (!items.contains(i)) {
            items.add(i);
        }
    }

    public void removeItem(Item i) {
        if (items.contains(i)) {
            items.remove(i);
        }
    }

    public Item getItemByName(String name) {
        for (Item i : items) {
            if (i.name.equalsIgnoreCase(name)) {
                return i;
            }
        }
        return null;
    }

    public void checkGuests() {
        if (guests.isEmpty()) {
            System.out.println("The " + this.name + " has no guests.");
        } else {
            System.out.println("----- Guests at " + this.name + " -----");
            for (Person p : guests) {
                System.out.println(p.name);
            }
        }
    }

    public void addGuest(Person p) {
        if (!guests.contains(p)){ 
            guests.add(p);
        }
    }

    public void removeGuest(Person p) {
        if (guests.contains(p)) {
            guests.remove(p);
        } 
    }

    public Person getGuestByName(String name) {
        for (Person p : guests) {
            if (p.name.equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }
}
