package br.ufrn.mapecar.mapek;

import br.ufrn.mapecar.emulator.Car;

public class Analisador {

	boolean algoAFazer = false;
	Planejamento planejamento = null;
	
	public Analisador(Planejamento planejamento) {
		this.planejamento = planejamento;
	}

	public void analisarCarro(Car car) {
		algoAFazer = false;
		verificaAproximacao(car);
		verificaPneus(car);
		if(!algoAFazer) {
			System.out.println("Analyze: Nada a ser feito");
		}
	}
	
	public void verificaPneus(Car car){
		if(car.pneuFrenteDireita < 30  ||
				car.pneuFrenteEsquerda <30  ||
				car.pneuTrasDireita<30  ||
				car.pneuTrasEsquerda<30) {
			System.out.println("Analyze: Pneu está seco.");
			planejamento.planCar(car);
			algoAFazer = true;
		}
	}
	
	public void verificaAproximacao(Car car){
		if(car.carroPertoFrente==true) {
			System.out.println("Analyze: O carro da frente está muito próximo");
			planejamento.planCar(car);
			algoAFazer = true;
		}
	}
}
