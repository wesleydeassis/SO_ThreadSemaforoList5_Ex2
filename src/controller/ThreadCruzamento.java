package controller;

import java.util.concurrent.Semaphore;

public class ThreadCruzamento extends Thread{
	
	private int idThreadCarro;
	private Semaphore semaforo;
	private int posicaoCarro; 
	
	
	
	public ThreadCruzamento(int idThreadCarro, Semaphore semaforo, int pos) {
		this.idThreadCarro = idThreadCarro;
		this.semaforo = semaforo;
		this.posicaoCarro = pos;
	}
	

	@Override
	public void run() {
		
		try {
			semaforo.acquire();
			cruzamento();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}finally {
			semaforo.release();
		}
	
		
		
	}


	private void cruzamento() {
		String origem="";
		
		try {
			
		if(posicaoCarro==1){
			origem ="Carro partindo do Sul";
			
			int direcaoCarro = (int)((Math.random()*1.1)+1);
			if(direcaoCarro == 1){
				System.out.println("carro #:"+ posicaoCarro+""+origem+" está indo para Norte");
				sleep(100);
				
			}
			else{
				System.out.println("carro #:"+ posicaoCarro+""+origem+" está indo para Leste");
				sleep(100);
			}
			
		}
		else if(posicaoCarro==2){
			
			origem="Carro partindo da Leste";
			int direcaoCarro = (int)((Math.random()*1.1)+1);
			if(direcaoCarro == 1){
				System.out.println("carro #:"+ posicaoCarro+""+origem+" está indo para Oeste");
				sleep(100);
			}
			else{
				System.out.println("carro #:"+ posicaoCarro+""+origem+" está indo para Sul");
				sleep(100);
			}
			
		}else if(posicaoCarro==3){
			
			origem="Carro partindo do Norte";
			int direcaoCarro = (int)((Math.random()*1.1)+1);
			if(direcaoCarro == 1){
				System.out.println("carro #:"+ posicaoCarro+""+ origem+" está indo para Sul");
				sleep(100);
			}
			else{
				System.out.println("carro #:"+ posicaoCarro+""+origem+" está indo para Oeste");
				sleep(100);
			}
		}
		else{
			posicaoCarro=4;
			origem="Carro partindo de Oeste";
			int direcaoCarro = (int)((Math.random()*1.1)+1);
			if(direcaoCarro == 1){
				System.out.println("carro #:"+ posicaoCarro+""+origem+" está indo para Leste");
				sleep(100);
			}
			else{
				System.out.println("carro #:"+ posicaoCarro+""+origem+" está indo para Norte");
				sleep(100);
			}
		}		
		
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
