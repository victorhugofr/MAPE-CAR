package br.ufrn.mapecar.utils;

public class Cronometro extends Thread {
	
	@Override
	public void run(){
		int i=0;
		while(true){
			try {
				Thread.sleep(1000);
				System.out.println("Quantidade em segundos de execucao:"+(++i));
			} catch (Exception e) {
				
			}
		}
	}
}