package view;

import java.util.concurrent.Semaphore;

import controller.ControllerExercicio2;

public class PrincipalExercicio2 {public static void main(String[] args) {

	int permissoes = 1;
	
	Semaphore semaforo = new Semaphore(permissoes);

	for (int i = 1; i <= 4; i++) {
		Thread t = new ControllerExercicio2(i, semaforo);
		t.start();
	}
	
	
}

}
