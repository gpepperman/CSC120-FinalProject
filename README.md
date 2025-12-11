# CSC120-FinalProject

## Deliverables:
 - Your final codebase
 - Your revised annotated architecture diagram
 - Design justification (including a brief discussion of at least one alternative you considered)
 - A map of your game's layout (if applicable)
 - `cheatsheet.md`
 - Completed `rubric.md`
  
## Additional Reflection Questions
 - What was your **overall approach** to tackling this project?
I knew immediately that I wanted to do a christmas dinner based game. I wanted to break down the game into as few classes as possible, so I settled for tables, guests, and item on the tables. I also knew that the game loop was going to be confusing for me, so I wanted to put as much information as possible in the methods inside the Table, Person, and Items classes. My approach for the game loop was to have instead of a really elaborate if ladder a series of if else statements. This allowed me to do a lot of recycling of code: for example, before you do any action, each if else checks to see if you are at a table. So although my game loop became quite long, it is very easy to parse through.

 - What **new thing(s)** did you learn / figure out in completing this project?
I learned how to separate the scanner input strings. For each input word I have a case for, it cuts of the characters associated with the input word from the scanner input and then divded the scanner input into two pieces. For example, "throw item" counts off the first six characters from "throw " and then designated the second part of the string as the item name. This system, however, got very complicated when the user input contained three parts, such as "give guest gift".

 - Is there anything that you wish you had **implemented differently**?
I wish I had found a better way to implement the 'avoid' words into the game. Currently, you have to tell a guest the exact word for the game to register that you said an avoid word. For example, if a guest's avoid word is work, the game will only register it in "tell guest work" and not "tell guest how is work".

 - If you had **unlimited time**, what additional features would you implement?
If I had unlimited time, I would want to make an actual talking feature where the player can ask questions and get responses rather than dummy responses.

 - What was the most helpful **piece of feedback** you received while working on your project? Who gave it to you?
The most helpful piece of feedback I recieved was from Hia. I was having issues early on with my table class allowing me to sit at multiple tables; however, Hia helped me see that my code was actually preventing the player from sitting at the same table multiple times. I needed to add the one table at a time case into my game loop.  

 - If you could go back in time and give your past self some **advice** about this project, what hints would you give?
My advice would be to work on the game loop in tandem instead of after creating the object classes. Once I started making my game loop I had to go back and adjust a lot of things in my other classes, so it would have been a lot my time effective to work on them all at the same time.

 - _If you worked with a team:_ please comment on how your **team dynamics** influenced your experience working on this project.
 I did not work on a team, but I had a great dynamic working with myself.
