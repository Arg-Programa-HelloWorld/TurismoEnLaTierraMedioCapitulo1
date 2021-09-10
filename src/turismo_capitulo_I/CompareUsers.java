package turismo_capitulo_I;

import java.util.Comparator;

public class CompareUsers implements Comparator<User> {

	//Ordena los userList por budget de mayor a menor
	@Override
	public int compare(User user1, User user2) {
		int result = Double.compare(user2.getBudget(), user1.getBudget()); 
		if (result == 0) { // Si budget son iguales se compara Time
			result = Double.compare(user2.getTime(), user1.getTime());
		}
		return result;
	}

}
