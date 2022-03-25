package br.ufrn.mapecar.mapek;

import br.ufrn.mapecar.emulator.Car;

public class Executor {

	public void diminuirVelocidade(Car car) {
		System.out.println("Executor: Reduzindo a velocidade em 10km");
		car.carroPertoFrente = false;
		car.velocidade -= 10;
	}
	public void alertarIdaPosto(Car car) {
		car.idaAoPosto = true;
		System.out.println("Executor: Alertando ida ao posto");
	}
	public void acenderFarol(Car car) {
		System.out.println("Executor: Acendendo farol");
		car.farol = true;
	}
	public void ligarPisca(Car car) {
		System.out.println("Executor: Ligando pisca alerta");
		car.piscaAlerta = true;
	}
}
