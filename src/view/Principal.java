package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCozinha;

public class Principal {

	public static void main(String[] args) {
		final int permissao = 1;
		Semaphore semaforo = new Semaphore(permissao);
		for (int id = 1; id < 6; id++) {
			ThreadCozinha t = new ThreadCozinha(id, semaforo);
			t.start();
		}
	}
}
