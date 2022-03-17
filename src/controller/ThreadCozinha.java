package controller;

import java.util.concurrent.Semaphore;

public class ThreadCozinha extends Thread {

	private String comida;
	private int id;
	private int sopat;
	private int lasanhat;
	private int tempo;
	private Semaphore semaforo;

	public ThreadCozinha(int id, Semaphore semaforo) {
		this.id = id;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		cozimento();
		try {
			semaforo.acquire();
			System.out.println("O prato #" + id + " " + comida + " foi entregue! *-*");
			sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}

	private void cozimento() {
		if (id % 2 == 1) {
			tempo = (int) (Math.random() * 300 + 500);
			comida = "Sopa de Cebola";
			int t = tempo / 100;
			System.out.println("O prato #" + id + " é uma " + comida + " e será feita em 0." + t + " segundos.");
			while (sopat < 100) {
				try {
					sleep(100);
					sopat += tempo / 100;
					System.out.println("O prato #" + id + ": " + comida + " está " + sopat + "% concluída.");
					if (sopat > 90) {
						System.out.println("O prato #" + id + " está concluído.");
						break;
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} else {
			tempo = (int) (Math.random() * 600 + 600);
			comida = "Lasanha a Bolonhesa";
			double t = tempo / 100;
			System.out.println("O prato #" + id + " é uma " + comida + " e será feita em " + t / 10 + " segundos.");
			while (lasanhat < 100) {
				try {
					sleep(100);
					lasanhat += tempo / 100;
					System.out.println("O prato #" + id + ": " + comida + " está " + lasanhat + "% concluída");
					if (lasanhat > 90) {
						System.out.println("O prato #" + id + " está concluído.");
						break;
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
