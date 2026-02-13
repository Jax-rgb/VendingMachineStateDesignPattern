public class DispensingState implements VendingMachineState {
    @Override
    public void selectItem(VendingMachine machine, String item) {
        System.out.println("Cannot select item while dispensing.");
    }

    @Override
    public void insertCoin(VendingMachine machine, double amount) {
        System.out.println("Cannot insert coin while dispensing.");
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        System.out.println("Dispensing in progress...");
        // Dispensing logic is handled in ItemSelectedState; this state just blocks actions.
        machine.setCurrentState(new IdleState());  // Auto-transition after dispense
    }

    @Override
    public void setOutOfOrder(VendingMachine machine) {
        machine.setCurrentState(new OutOfOrderState());
        System.out.println("Machine set to OutOfOrder.");
    }
}
