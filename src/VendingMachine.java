import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private VendingMachineState currentState;
    private Map<String, Integer> inventory = new HashMap<>();
    private Map<String, Double> prices = new HashMap<>();
    private double balance = 0.0;
    private String selectedItem;

    public VendingMachine() {
        currentState = new IdleState();
        // Example inventory setup
        inventory.put("Soda", 5);
        prices.put("Soda", 1.5);
        inventory.put("Chips", 3);
        prices.put("Chips", 1.0);
    }

    public void selectItem(String item) {
        currentState.selectItem(this, item);
    }

    public void insertCoin(double amount) {
        currentState.insertCoin(this, amount);
    }

    public void dispenseItem() {
        currentState.dispenseItem(this);
    }

    public void setOutOfOrder() {
        currentState.setOutOfOrder(this);
    }

    // Getters and setters
    public Map<String, Integer> getInventory() {
        return inventory;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addBalance(double amount) {
        this.balance += amount;
    }

    public String getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;
    }

    public double getItemPrice(String item) {
        return prices.getOrDefault(item, 0.0);
    }

    public void setCurrentState(VendingMachineState state) {
        this.currentState = state;
    }
}
