public class ItemSelectedState implements VendingMachineState {
    @Override
    public void selectItem(VendingMachine machine, String item) {
        System.out.println("Item already selected. Insert coin to proceed.");
    }

    @Override
    public void insertCoin(VendingMachine machine, double amount) {
        machine.addBalance(amount);
        System.out.println("Coin inserted: " + amount + ". Current balance: " + machine.getBalance());
        if (machine.getBalance() >= machine.getItemPrice(machine.getSelectedItem())) {
            machine.setCurrentState(new DispensingState());
            dispenseItem(machine);  // Automatically trigger dispense if enough balance
        }
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        if (machine.getBalance() >= machine.getItemPrice(machine.getSelectedItem())) {
            System.out.println("Dispensing item: " + machine.getSelectedItem());
            machine.getInventory().put(machine.getSelectedItem(), machine.getInventory().get(machine.getSelectedItem()) - 1);
            machine.setBalance(machine.getBalance() - machine.getItemPrice(machine.getSelectedItem()));
            machine.setCurrentState(new IdleState());
            System.out.println("Returned to Idle state.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    @Override
    public void setOutOfOrder(VendingMachine machine) {
        machine.setCurrentState(new OutOfOrderState());
        System.out.println("Machine set to OutOfOrder.");
    }
}
