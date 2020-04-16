#Assignment 2

####Design decisions for Christopher Columbus Game:

In this problem, we will have to add at least two Pirate ships to the ocean in any available cell and the pirate ship 
will register itself with Christopher Columbus’ Ship (CCS) and will receive notifications each time the ship moves. 
The pirate will use the information about Christoper Columbus' Ship location to chase Christoper Columbus.

For this, we can implement the Observer Design Pattern. The observer pattern defines a one-to-many dependency between
objects so that when one object changes state, all of  its dependents are notified and updated automatically.

The object which is being watched is called the subject. In this case, CCS is the subject. The objects which are 
watching the state changes are called observers. Here, the pirate ships are observers.

We place the ships in the ocean randomly by using the Random() method.
PirateShip Class implements the Observer Interface.
The Columbus Ship i.e., Ship class extends the Observable Class.

Advantages of using observer pattern:
1. It allows sending data to other objects effectively without any change in the Subject or Observer classes.
2. Observers can be added/removed at any point in time.
3. It supports the principle of loose coupling between objects that interact with each other.