public class OutOfOrderState implements VendingMachineState {
    @Override
    public void selectItem(VendingMachine machine, String item) {
        System.out.println("Machine is out of order. No operations allowed.");
    }

    @Override
    public void insertCoin(VendingMachine machine, double amount) {
        System.out.println("Machine is out of order. No operations allowed.");
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        System.out.println("Machine is out of order. No operations allowed.");
    }

    @Override
    public void setOutOfOrder(VendingMachine machine) {
        System.out.println("Machine is already out of order.");
    }
}
