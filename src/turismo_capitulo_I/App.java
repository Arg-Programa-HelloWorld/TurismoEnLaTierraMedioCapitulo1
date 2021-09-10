
package turismo_capitulo_I;

import java.io.IOException;

public class App {
	
    public static void main(String[] args) throws IOException {

		boolean dataUploadSupervisor;

		dataUploadSupervisor = Functions.dataLoader();

		if (dataUploadSupervisor) {

			View.ready();
				
			Model.menu();

		} else {

			View.warning();

		}

	}

}