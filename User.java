
package moneyGame;

public class User {
    private String username;
    private int balance;
    private Machine machine;

    public User(String username, int balance, Machine machine) {
        this.username = username;
        this.balance = balance;
        this.machine = machine;
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    // Methods
    public void play() {
        // TODO: Implement the logic for playing the slot machine
    }
}
