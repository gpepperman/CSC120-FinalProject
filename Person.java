import java.util.ArrayList; //import array list features

/**
 * Represents a person (guest) in the game. Each person has a name,
 * a relationship to the player, a list of forbidden words ("avoids"),
 * and a list of correct gifts ("wins") that will win the game if given.
 * 
 * A person must be greeted before they can receive a gift.
 */
public class Person {
    protected String name; //name of person
    protected RelationshipType relationship; //person's relationship to you
    protected ArrayList<String> avoids; //things to avoid in discussion
    protected ArrayList<String> wins; //thing you need to give them to win
    private boolean greeted = false; //if you have greeted them yet

    /**
     * Constructs a new Person with the given name and relationship type.
     *
     * @param name          the name of the guest
     * @param relationship  the player's relationship to this person
     */
    public Person(String name, RelationshipType relationship) {
        this.name = name;
        this.relationship = relationship;
        this.avoids = new ArrayList<>();
        this.wins = new ArrayList<>();
    }

    /**
     * Adds a word or phrase that this person does not want to hear.
     *
     * @param avoid the forbidden word to add
     */
    public void addAvoid(String avoid){
        if (!avoids.contains(avoid)) {//checks if the list of avoids doesn't contain the new avoid yet
            avoids.add(avoid);
        }
    }

    /**
     * Adds a gift that will win the game if given to this person.
     *
     * @param win the winning gift name
     */
    public void addWin(String win){
        if (!wins.contains(win)) {//checks if the list of wins doesn't contain the new win yet
            wins.add(win);
        }
    }

    /**
     * Greets this person, marking them as greeted and printing a response.
     */
    public void greet() {
        System.out.println(name + " smiles: \"Thank you for the greeting!\"");
        greeted = true;
    }

    /**
     * Returns whether this person has already been greeted.
     *
     * @return true if greeted; false otherwise
     */
    public boolean hasBeenGreeted() {
        return greeted;
    }

    /**
     * Tells this person a piece of gossip or a phrase. If the phrase is
     * in their "avoids" list, the player loses the game.
     *
     * @param gossip the phrase spoken to the person
     * @return true if the player loses; false otherwise
     */
    public boolean tell(String gossip) {
        if (avoids.contains(gossip)) { //checks if the phrase is an avoid statement 
            System.out.println("You said \"" + gossip + "\" to " + name + "? We don't talk about that. *You Lose!*");
            return true;
        } else {
            System.out.println("You told " + name + ": \"" + gossip + "\"");
            return false;
        }
    }

    /**
     * Attempts to give this person a present. If the present matches one
     * of their winning gifts, the player wins the game.
     *
     * @param present the gift given to the person
     * @return true if the player wins; false otherwise
     */
    public boolean give(String present) {
        if (wins.contains(present)) {//checks if the gift is an winning gift 
            System.out.println("You gave " + name + " " + present.toLowerCase() + "! That's " + name + "'s favorite. *You Win!*");
            return true;
        } else {
            System.out.println("You gave " + name + " " + present.toLowerCase() +  ". " + name + " says thank you, but gives it back.");
            return false;
        }
    }

    /**
     * Says farewell to this person.
     */
    public void farewell() {
        System.out.println("You bid farewell to " + name + ".");
    }

    /**
     * Prints this person's relationship to the player.
     */
    public void checkWho() {
        System.out.println(name + " is your " + relationship + ".");
    }

    /**
     * Insults this person, resulting in an immediate loss.
     */
    public void insult() {
        System.out.println("You insulted " + name + ". They gasp. *You Lose!*");
    }

    /**
     * Attacks this person, resulting in an immediate loss.
     */
    public void attack() {
        System.out.println("You attacked " + name + ". Everyone screams. *You Lose!*");
    }
}
