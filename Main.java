
package slot;

public class Main {
	public static void main(String[] args) {
		//Creation d'une machine
		Machine machine = new Machine();
		//creation d'un utilisateur 
		User user = new User(machine);
		//Afficher le solde au démmarage
		user.printSolde();
		//Lancer la machine
		user.lancerMachine();
	}

}
