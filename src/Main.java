public class Main {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();
        machine.selectItem("Soda");
        machine.insertCoin(1.0);
        machine.insertCoin(0.5);
        machine.dispenseItem();
        machine.setOutOfOrder();
        machine.selectItem("Chips");  // Should fail
    }
}
