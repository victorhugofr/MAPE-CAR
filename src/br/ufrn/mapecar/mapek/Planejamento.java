package br.ufrn.mapecar.mapek;

import br.ufrn.mapecar.emulator.Car;

public class Planejamento {

	Executor executor = null;
	public Planejamento(Executor executor) {
		this.executor = executor;
	}
	
	public void planCar(Car car) {
		String planos = "";
		if(car.carroPertoFrente) {
			planos += "Reduzir a velocidade; "; 
			System.out.println("Plan: reduzir a velocidade");
			executor.diminuirVelocidade(car);
		}
		if(car.pneuFrenteDireita < 30  ||
				car.pneuFrenteEsquerda <30  ||
				car.pneuTrasDireita<30  ||
				car.pneuTrasEsquerda<30) {
			planos += "Alertar urgência a ida ao posto.; "; 
			executor.diminuirVelocidade(car);
		}
		System.out.println("Plan: "+planos);
	}

	
}
