package controller;

import java.util.concurrent.Semaphore;

public class ControllerExercicio2 extends Thread {
	
	    private int idCorredor;
		private Semaphore semaforo;
		private static final int DISTANCIATOTAL = 200;
		
	public ControllerExercicio2(int idThread,Semaphore semaforo) {
		
		this.idCorredor=idThread;
		this.semaforo=semaforo;
		
	}
	
	private void PessoaAndando() {
		
		int distanciaPercorrida = 0;
		while (distanciaPercorrida < DISTANCIATOTAL) {
	
			int rodada = (int) (40 + Math.random() * 60);
			distanciaPercorrida += rodada;
			
			System.out.println("A pessoa" + idCorredor + " já percorreu :"
					+ distanciaPercorrida + "metros");

			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	
	
	
	private void PessoaChegou() {
		System.out.println("O Corredor #" + idCorredor + " Chegou");
	}
	
	private void abrirPorta() {
		System.out.println("A pessoa #" + idCorredor + " abriu a porta, e cruzou");
		// Tempo Abertura Porta 1 a 2 segundos
		int tempo = (int) ((Math.random() * 10) + 20);
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		PessoaAndando();
		PessoaChegou();
		try {
			semaforo.acquire();
			abrirPorta();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
		
		
	
	
	}


}
