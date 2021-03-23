package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCruzamento;



public class Principal {

	public static void main(String[] args) {
		int permissao=1;
		Semaphore semaforo =new Semaphore(permissao);
		
	for(int idCarro = 1; idCarro < 5;idCarro++){
		
		int pos =(int)((Math.random()*3.1)+1);
			
			Thread travessia = new ThreadCruzamento(idCarro, semaforo, pos);
			travessia.start();
			
		}

	}

}
