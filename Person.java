import java.util.ArrayList;

public class Person {
    protected String name;
    protected RelationshipType relationship;
    protected ArrayList<String> avoids;
    protected ArrayList<String> wins;

    public Person(String name, RelationshipType relationship) {
        this.name = name;
        this.relationship = relationship;
        this.avoids = new ArrayList<>();
        this.wins = new ArrayList<>();
    }

    public void addAvoid(String avoid){
        if (!avoids.contains(avoid)) {
            avoids.add(avoid);
        }
    }

    public void addWin(String win){
        if (!wins.contains(win)) {
            wins.add(win);
        }
    }

    public void greet() {
        System.out.println(name + " smiles: \"Thank you for the greeting!\"");
    }

    public boolean tell(String gossip) {
        if(avoids.contains(gossip)){
            System.out.println("You said \"" + gossip + "\" to "+ name + "? We don't talk about that. *You Lose!*" );
            return true;
        } else{
            System.out.println("You told " + name + ": \"" + gossip + "\"");
            return false;
        }
    }

    public boolean give(String present) {
        if(wins.contains(present)){
            System.out.println("You gave " + name + " " + present + "! That's their favorite. *You Win!*" );
            return true;
        } else{ 
            System.out.println("You gave " + name + " " + present + ". They say thank you, but give it back");
            return false;
        }
    }

    public void farewell() {
        System.out.println("You bid farewell to " + name + ".");
    }

    public void checkWho() {
        System.out.println(name + " is your " + relationship + ".");
    }

    public void insult() {
        System.out.println("You insulted " + name + ". They gasp. *You Lose!*");
    }

    public void attack() {
        System.out.println("You attacked " + name + ". Everyone screams. *You Lose!*");
    }
}
