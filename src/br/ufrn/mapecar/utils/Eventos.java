package br.ufrn.mapecar.utils;

import br.ufrn.mapecar.emulator.Car;

public class Eventos extends Thread {

	Car carro = null;
	
	public Eventos(Car car) {
		this.carro = car;
	}

	@Override
	public void run(){
		while(true){
			try{
				Thread.sleep(20000);
				carro.evento();
				// LAN�A UM EVENTO A CADA 20000 SEGUNDOS
				// REPITO O PROCESSO INFINITAMENTE. 
			}catch(Exception e){
				System.out.println(e);
			}

		}
	}
}
