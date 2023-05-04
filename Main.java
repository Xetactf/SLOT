
package slot;

public class Main {
	public static void main(String[] args) {
		Machine machine = new Machine();
		User user = new User(machine);
		user.printSolde();
		user.lancerMachine();
	}

}

