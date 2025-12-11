# Design Justification
In designing my Christmas game, I wanted to structure the code around minimal classes to keep the logic manageable in my game loop. All guests are constructed through the Person class, so each guest is only distinguished in interactions by their lists of avoids and wins. This allows the game loop to remain simple while each character has unique aspects. The Item class is similarly simple in that all of the items' aspects are differentiated through booleans. The methods in the Table, Person and Item classes are very simple actions. I also chose boolean return values for some methods in Table, Person, and Item classes to let the game loop easily detect win/loss states. This layout, although simple, allows the game to be very easily extended with more guests, items, and tables. 

One design idea I had early on was to make the game be based off of surving a certain amount of turns of play to win rather than completing a goal. I decided not to go this route because I thought it would be more engaging to give the players a task of giving out gifts rather than just idly chatting. 

# Expansion Ideas
- Expand the game so to win you have to give every guest the correct gift
- Expand the tell feature to make it more interactive, so you can collect information through talking
- Expand from one room of tables to a house full of rooms
- Create extentions of Item class so foods and gifts can have their own unique interactions
- Create extentions of Person class so certain guests (i.e. immediate family vs extended family) can have different interactions
- Limit gift matching gueses so the player can only give a guest gifts n times
- Limit the options of gifts to be given, as currently the game allows the player to give whatever they want to a guest. 
