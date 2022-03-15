package br.ufrn.mapecar.mapek;

import br.ufrn.mapecar.emulator.Car;

public class Executor {

	public void diminuirVelocidade(Car car) {
		System.out.println("Executor: Reduzindo a velocidade em 10km");
		car.carroPertoFrente = false;
		car.velocidade -= 10;
	}
}
