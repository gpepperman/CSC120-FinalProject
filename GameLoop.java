import java.util.Scanner;

public class GameLoop {

    public static void main(String[] args) {

        Table diningTable = new Table("Dining Table", false);
        Person elizabeth = new Person("Elizabeth", RelationshipType.parent);
        elizabeth.addAvoid("ERIC");
        elizabeth.addWin("EARRINGS");
        Person owen = new Person("Owen", RelationshipType.cousin);
        owen.addAvoid("GIRLFRIEND");
        owen.addWin("TICKET");
        Person rick = new Person("Rick", RelationshipType.parent);
        rick.addAvoid("WORK");
        rick.addWin("EAGLES JACKET");
        Person maureen = new Person("Maureen", RelationshipType.aunt);
        maureen.addAvoid("MOTHER");
        maureen.addWin("PAINT");
        Person riley = new Person("Riley", RelationshipType.cousin);
        riley.addAvoid("WORK");
        riley.addWin("DRESS");
        Person paul = new Person("Paul", RelationshipType.uncle);
        paul.addAvoid("EXWIFE");
        paul.addWin("GUIATR");
        Person chris = new Person("Chirs", RelationshipType.uncle);
        chris.addAvoid("WAKE FOREST");
        chris.addWin("TULANE SOCKS");
        diningTable.addGuest(chris);
        diningTable.addGuest(paul);
        diningTable.addGuest(riley);
        diningTable.addGuest(elizabeth);
        diningTable.addGuest(owen);
        diningTable.addGuest(rick);
        diningTable.addGuest(maureen);
        Item potatos = new Item("Potatos", false, true,false);
        Item bread = new Item("Bread", false,true,false);
        Item rice = new Item("Rice", false,true,false);
        Item peas = new Item("Peas", false,true,false);
        diningTable.addItem(peas);
        diningTable.addItem(rice);
        diningTable.addItem(bread);
        diningTable.addItem(potatos);

        Table snackTable = new Table("Snack Table", false);
        Person steve = new Person("Steve", RelationshipType.uncle);
        steve.addAvoid("CANCER");
        steve.addWin("HOCKEY STICK");
        Person sarah = new Person("Sarah", RelationshipType.aunt);
        sarah.addAvoid("WEDDING");
        sarah.addWin("BUDDHA");
        Person nolan = new Person("Nolan", RelationshipType.cousin);
        nolan.addAvoid("WEDDING");
        nolan.addWin("MONEY");
        snackTable.addGuest(steve);
        snackTable.addGuest(sarah);
        snackTable.addGuest(nolan);
        Item chips = new Item("Chips", false,true ,false);
        Item cake = new Item("Cake", false,true, false);
        snackTable.addItem(cake);
        snackTable.addItem(chips);

        Table giftTable = new Table("Gift Table", false);
        Person beth = new Person("Beth", RelationshipType.grandparent);
        beth.addAvoid("HUSBAND");
        beth.addWin("PICTURE");
        Person abby = new Person("Abby", RelationshipType.sibling);
        abby.addAvoid("SPANISH");
        abby.addWin("PENCIL");
        Person kate = new Person("Kate", RelationshipType.sibling);
        kate.addAvoid("BOYFRIEND");
        kate.addWin("MONEY");
        giftTable.addGuest(beth);
        giftTable.addGuest(abby);
        giftTable.addGuest(kate);
        Item bigGift = new Item("Big Gift", false,false,true);
        Item smallGift = new Item("Small Gift", false,false, true);
        giftTable.addItem(bigGift);
        giftTable.addItem(smallGift);

        // Track where the player is sitting
        Table currentTable = null;

        Scanner userInput = new Scanner(System.in);
        boolean playing = true;
        String response;

        System.out.println("****************************");
        System.out.println("WELCOME TO CHRISTMAS DINNER");
        System.out.println("****************************");
        System.out.println("You arrive with a sack full of gifts to give out.");
        System.out.println("You also arrive with a list of 'avoid' words.");
        System.out.println("However, they are only 'avoid' words for specific guests.");
        System.out.println("------- Items in the Sack: -------");
        System.out.println("• Earring, Eagles Jacket, Hockey Stick,");
        System.out.println("  Tulane Socks, Money, Paint, Ticket, Dress,");
        System.out.println("  Pencil, Monitor, Picture, Guitar, Buddha");
        System.out.println("------- Words to Avoid: -------");
        System.out.println("• Spanish, Eric, Cancer, Exwife, ");
        System.out.println("  Work, Wake Forest, Boyfriend,");
        System.out.println("  Wedding, Mother, Girlfriend");
        System.out.println("The room has 3 tables you can move between:");
        System.out.println("------- Tables: -------");
        System.out.println("• Snack Table, Dining Table, Gift Table");
        System.out.println("To start the gave, sit at a table!");
        

        while (playing) {
            System.out.print("> ");
            response = userInput.nextLine().trim().toUpperCase();

            // -----------------------------
            // SIT COMMAND
            // -----------------------------
            if (response.startsWith("SIT")) {

                Table target = null;

                if (response.contains("DINING")) target = diningTable;
                else if (response.contains("SNACK")) target = snackTable;
                else if (response.contains("GIFT")) target = giftTable;
                else {
                    System.out.println("Sit where?");
                    continue;
                }

                // Trying to sit at a second table
                if (currentTable != null && currentTable != target) {
                    System.out.println("You can't sit at two tables at once!");
                    System.out.println("You are already sitting at the " + currentTable.name + ".");
                    continue;
                }

                target.sit();
                currentTable = target;
            }

            // -----------------------------
            // UNSIT
            // -----------------------------
            else if (response.equals("UNSIT")) {
                if (currentTable == null) {
                    System.out.println("You are not sitting anywhere.");
                } else {
                    currentTable.unSit();
                    currentTable = null;
                }
            }

            // -----------------------------
            // LOOK
            // -----------------------------
            else if (response.startsWith("WHAT")) {
                if (currentTable == null) {
                    System.out.println("You must sit at a table to check items.");
                } else {
                    currentTable.lookAtItems();
                }
            }

            // -----------------------------
            // WHO (check guests)
            // -----------------------------
            else if (response.equals("WHO")) {
                if (currentTable == null) {
                    System.out.println("You must be sitting at a table to check who is there.");
                } else {
                    currentTable.checkGuests();
                }
            }

            // -----------------------------
            // PERSON INTERACTIONS
            // -----------------------------
            else if (response.startsWith("GREET ")) {
                if (currentTable == null) {
                    System.out.println("You must be sitting at a table to greet someone.");
                    continue;}

                String name = response.substring(6).trim();
                Person target = currentTable.getGuestByName(name);

                if (target == null) {
                    System.out.println(name + " is not at this table.");
                    continue;
                }

                target.greet();
            }

            else if (response.startsWith("TELL ")) {
                if (currentTable == null) {
                    System.out.println("You must be sitting at a table to tell someone something.");
                    continue;
                }
                
                String[] parts = response.split(" ", 3);
                if (parts.length < 3) {
                    System.out.println("Tell what to whom?");
                    continue;
                }
                
                String name = parts[1];
                String gossip = parts[2];

                Person target = currentTable.getGuestByName(name);
                if (target == null) {
                    System.out.println(name + " is not at this table.");
                    continue;
                }

                boolean lost = target.tell(gossip);
                if (lost) {
                    playing = false;
                }
            }

            else if (response.startsWith("GIVE ")) {
                if (currentTable == null) {
                    System.out.println("You must be sitting at a table to give someone something.");
                    continue;
                }
                
                String[] parts = response.split(" ", 3);
                if (parts.length < 3) {
                    System.out.println("Give what to whom?");
                    continue;
                }
                
                String name = parts[1];
                String present = parts[2];

                Person target = currentTable.getGuestByName(name);
                if (target == null) {
                    System.out.println(name + " is not at this table.");
                    continue;
                }

                if (!target.hasBeenGreeted()) {
                     System.out.println("You cannot give " + name.toLowerCase() + " " + present.toLowerCase()+ " before greeting " + name.toLowerCase()+"!");
                     continue;
                    }

                boolean lost = target.give(present);
                if (lost) {
                    playing = false;
                }
            }

            else if (response.startsWith("FAREWELL ")) {
                if (currentTable == null) {
                    System.out.println("You must be sitting at a table say farewell to someone.");
                    continue;}

                String name = response.substring(8).trim();
                Person target = currentTable.getGuestByName(name);

                if (target == null) {
                    System.out.println(name + " is not at this table.");
                    continue;
                }

                target.farewell();
            }

            else if (response.startsWith("WHO IS ")) {
                if (currentTable == null) {
                    System.out.println("You must be sitting at a table to check who someone is.");
                    continue;}

                String name = response.substring(7).trim();
                Person target = currentTable.getGuestByName(name);

                if (target == null) {
                    System.out.println(name + " is not at this table.");
                    continue;
                }

                target.checkWho();
            }

            else if (response.startsWith("INSULT ")) {
                if (currentTable == null) {
                    System.out.println("You must be sitting at a table to insult someone.");
                    continue;}

                String name = response.substring(7).trim();
                Person target = currentTable.getGuestByName(name);

                if (target == null) {
                    System.out.println(name + " is not at this table.");
                    continue;
                }

                target.insult();
                playing = false;
            }

            else if (response.startsWith("ATTACK ")) {
                if (currentTable == null) {
                    System.out.println("You must be sitting at a table to attack someone.");
                    continue;}

                String name = response.substring(7).trim();
                Person target = currentTable.getGuestByName(name);

                if (target == null) {
                    System.out.println(name + " is not at this table.");
                    continue;
                }

                target.attack();
                playing = false;
            }

            // -----------------------------
            // ITEM INTERACTIONS
            // -----------------------------
            else if (response.startsWith("PICK UP ")) {
                if (currentTable == null) {
                    System.out.println("You must be sitting at a table to pick up an item.");
                    continue;}

                String name = response.substring(8).trim();
                Item target = currentTable.getItemByName(name);

                if (target == null) {
                    System.out.println(name + " is not on this table.");
                    continue;
                }

                target.pickUp();
            }

            else if (response.startsWith("PUT DOWN ")) {
                if (currentTable == null) {
                    System.out.println("You must be sitting at a table to put down an item.");
                    continue;}

                String name = response.substring(9).trim();
                Item target = currentTable.getItemByName(name);

                if (target == null) {
                    System.out.println(name + " is not on this table.");
                    continue;
                }

                target.putDown();
            }

            else if (response.startsWith("LOOK AT ")) {
                if (currentTable == null) {
                    System.out.println("You must be sitting at a table to look at an item.");
                    continue;}

                String name = response.substring(8).trim();
                Item target = currentTable.getItemByName(name);

                if (target == null) {
                    System.out.println(name + " is not on this table.");
                    continue;
                }

                target.lookAt();
            }

            else if (response.startsWith("EAT ")) {
                if (currentTable == null) {
                    System.out.println("You must be sitting at a table to eat.");
                    continue;}

                String name = response.substring(4).trim();
                Item target = currentTable.getItemByName(name);

                if (target == null) {
                    System.out.println(name + " is not on this table.");
                    continue;
                }

                target.eat();
            }

            else if (response.startsWith("OPEN ")) {
                if (currentTable == null) {
                    System.out.println("You must be sitting at a table to open something.");
                    continue;}

                String name = response.substring(5).trim();
                Item target = currentTable.getItemByName(name);

                if (target == null) {
                    System.out.println(name + " is not on this table.");
                    continue;
                }

                target.open();
            }

            else if (response.startsWith("THROW")) {
                if (currentTable == null) {
                    System.out.println("You must be sitting at a table.");
                    continue;
                }
                
                String rest = response.substring(5).trim();
                
                if (!rest.contains(" AT ")) {
                    System.out.println("Throw what at who?");
                    continue;
                }
                
                String[] parts = rest.split(" AT ");
                
                String itemName = parts[0].trim();   
                String personName = parts[1].trim();   
                
                Item item = currentTable.getItemByName(itemName);
                Person person = currentTable.getGuestByName(personName);
                
                if (item == null) {
                    System.out.println("There is no " + itemName + " on this table.");
                    continue;
                }
                
                if (person == null) {
                    System.out.println(personName + " is not at this table.");
                    continue;
                }
                
                item.throwAt(person);
                playing = false;
            }

            // -----------------------------
            // HINTS
            // -----------------------------
            else if (response.equals("HINT")) {
                System.out.println("Remeber you arrived with a bag full of gifts! You have to give it to correct guest to win!");
                System.out.println("Don't remeber what you brought? Type: \"SACK REMINDER\"");
                System.out.println("Don't remeber what not to say? Type: \"AVOIDS REMINDER\"");
                System.out.println("Don't remeber what the tables are? Type: \"TABLES REMINDER\"");
            }

            else if (response.equals("SACK REMINDER")) {
                System.out.println("------- Items in the Sack: -------");
                System.out.println("• Earring, Eagles Jacket, Hockey Stick,");
                System.out.println("  Tulane Socks, Money, Paint, Ticket, Dress,");
                System.out.println("  Pencil, Monitor, Picture, Guitar, Buddha");
            }

            else if (response.equals("AVOIDS REMINDER")) {
                System.out.println("------- Words to Avoid: -------");
                System.out.println("• Spanish, Eric, Cancer, Exwife, ");
                System.out.println("  Work, Wake Forest, Boyfriend,");
                System.out.println("  Wedding, Mother, Girlfriend");
            }

            else if (response.equals("TABLES REMINDER")) {
                System.out.println("------- Tables: -------");
                System.out.println("• Snack Table, Dining Table, Gift Table");
                }

            else if (response.equals("BETTER HINT")) {
                System.out.println("You want a better hint? Fine! Either Elizabeth, Abby, or Sarah want the earrings!");
            }

            // -----------------------------
            // HELP
            // -----------------------------
            else if (response.equals("HELP")) {
                System.out.println("******** Commands: ********");
                System.out.println("------- Table Commands: -------");
                System.out.println("• \"Sit {TABLE NAME}\" lets you sit at a specific table");
                System.out.println("• \"Unsit {TABLE NAME}\" lets you unsit a specific table");
                System.out.println("• \"Who\" lets you check who is at the table");
                System.out.println("• \"What\" lets you check what items are on the table");

                System.out.println("------- Item Commands: -------");
                System.out.println("• \"Pick Up {item name}\" lets you pick up a specific item on the table");
                System.out.println("• \"Put Down {item name}\" lets you put down a specific item on the table");
                System.out.println("• \"Look At {item name}\" lets you look at a specific item on the table");
                System.out.println("• \"Eat {item name}\" lets you eat a specific item on the table");
                System.out.println("• \"Throw {item name} at {guest name}\" lets you throw a specific item on the table at a specific guest at the table");
                System.out.println("• \"Open {item name}\" lets you open a specific item on the table");

                System.out.println("------- Guest Commands: -------");
                System.out.println("• \"Greet {guest name}\" lets you greet a specific guest at the table");
                System.out.println("• \"Farewell {guest name}\" lets you say farewell to a specific guest at the table");
                System.out.println("• \"Attack {guest name}\" lets you attack a specific guest at the table");
                System.out.println("• \"Insult {guest name}\" lets you insult a specific guest at the table");
                System.out.println("• \"Tell {guest name} {String}\" lets you tell a specific guest at the table something");
                System.out.println("• \"Give {guest name} {gift from sack}\" lets you give a specific guest at the table a gift from your sack");
                System.out.println("• \"Who is {guest name}\" lets you check your relationship to a specific guest at the table");

                System.out.println("------- Hint Commands: -------");
                System.out.println("• \"Quit\" lets you end the game");
                System.out.println("• \"Hint\" give you a hint on how to win the game");
                System.out.println("• \"Better Hint\" give you a better hint on how to win the game");
                System.out.println("• \"Sack Reminder\" reminder you of the gifts you brought");
                System.out.println("• \"Tables Reminder\" reminder you of the tables in the room");
                System.out.println("• \"Avoids Reminder\" reminder you of the words to avoid in conversation");
            }


            // -----------------------------
            // QUIT GAME
            // -----------------------------
            else if (response.equals("QUIT")) {
                playing = false;
            }

            
            // -----------------------------
            // UNKNOWN COMMAND
            // -----------------------------
            else {
                System.out.println("I don't recognize that command.");
            }
        }

        userInput.close();
        System.out.println("******************");
        System.out.println("GAME OVER");
        System.out.println("******************");
    }
}