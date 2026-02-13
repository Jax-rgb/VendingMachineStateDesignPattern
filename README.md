# VendingMachineStateDesignPattern

Problem Scenario
A vending machine operates in different modes (states), and the allowed user actions change depending on the current state:

Idle → User can only select an item. Cannot insert coins or dispense.
ItemSelected → User can insert coins (to pay) and request dispensing. Cannot select another item.
Dispensing → No user actions allowed (automatic process). After completion → back to Idle.
OutOfOrder → No actions allowed at all (maintenance mode).

The original implementation used many if-else or switch statements inside the VendingMachine class to check the current state before performing each action. This makes the code:

Hard to read and maintain
Difficult to extend (adding new states requires changing many places)
Prone to bugs (forgetting to handle a state in some method)

Goal: Refactor using the State Design Pattern (Behavioral pattern) so that:

Each state becomes its own class
State-specific behavior is encapsulated
VendingMachine (the context) delegates actions to the current state object
Adding/removing states or changing behavior is much easier
