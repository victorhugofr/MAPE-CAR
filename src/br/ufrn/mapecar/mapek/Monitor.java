package br.ufrn.mapecar.mapek;

import br.ufrn.mapecar.emulator.Car;

public class Monitor {
	public Monitor(Car car, Analisador analisador) {
		monitorCar(car,analisador);
	}
	
	public void monitorCar(Car car, Analisador analisador) {
		System.out.println("Monitor: Enviando dados do carro atual");
		System.out.println("Dados enviados:");
		System.out.println(car.toString());
		analisador.analisarCarro(car);
	}
}
