public class IdleState implements VendingMachineState {
    @Override
    public void selectItem(VendingMachine machine, String item) {
        if (machine.getInventory().containsKey(item) && machine.getInventory().get(item) > 0) {
            machine.setSelectedItem(item);
            machine.setCurrentState(new ItemSelectedState());
            System.out.println("Item selected: " + item);
        } else {
            System.out.println("Item not available.");
        }
    }

    @Override
    public void insertCoin(VendingMachine machine, double amount) {
        System.out.println("Cannot insert coin in Idle state. Select item first.");
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        System.out.println("Cannot dispense in Idle state. Select item and insert coin first.");
    }

    @Override
    public void setOutOfOrder(VendingMachine machine) {
        machine.setCurrentState(new OutOfOrderState());
        System.out.println("Machine set to OutOfOrder.");
    }
}
