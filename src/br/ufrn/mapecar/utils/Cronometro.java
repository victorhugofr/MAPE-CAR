package br.ufrn.mapecar.utils;

import br.ufrn.mapecar.emulator.Car;

public class Cronometro extends Thread {
	Car car = null;
	
	public Cronometro(Car car) {
		this.car = car;
	}

	@Override
	public void run(){
		int i=0;
		while(true){
			try {
				car.atualizaInfos();
				Thread.sleep(1000);
				System.out.println("Quantidade em segundos de execucao:"+(++i));
			} catch (Exception e) {
				
			}
		}
	}
}