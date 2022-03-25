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
		}
		/*PROBLEMAS DE CHUVA*/
		if(car.chuva) {
			if(car.velocidade>50){
				if(!planos.contains("Reduzir a velocidade;"))
					planos += "Reduzir a velocidade; "; 
			}else if(!planos.contains("Velocidade Controlada;")){
				planos += "Velocidade controlada; ";
			}
			if(!car.farol) {
				planos += "Acender faróis; ";
			}else if(!planos.contains("Faróis já acesos;")){
				planos += "Faróis já acesos; ";
			}
		}
		/*PROBLEMAS DE NEBLINA*/
		if(car.neblina) {
			if(car.velocidade>50){
				if(!planos.contains("Reduzir a velocidade;"))
					planos += "Reduzir a velocidade; "; 
			}else if(!planos.contains("Velocidade Controlada;")){
				planos += "Velocidade controlada; ";
			}
			if(!car.farol) {
				planos += "Acender faróis; ";
			}else if(!planos.contains("Faróis já acesos;")){
				planos += "Faróis já acesos; ";
			}
			if(!car.piscaAlerta) {
				planos += "Ligar pisca alerta; ";
			}else if(!planos.contains("Ligar pisca alerta;")){
				planos += "Pisca alerta já acesos; ";
			}
		}
		/*PROBLEMAS DE PNEUS*/
		if(car.pneuFrenteDireita < 30  ||
				car.pneuFrenteEsquerda <30  ||
				car.pneuTrasDireita<30  ||
				car.pneuTrasEsquerda<30) {
			if(!car.idaAoPosto) {
				if(!planos.contains("Alertar urgência a ida ao posto"))
					planos += "Alertar urgência a ida ao posto; "; 
				if(!planos.contains("Reduzir a velocidade;"))
					planos += "Reduzir a velocidade; "; 
			}else if(car.velocidade>50){
				if(!planos.contains("Reduzir a velocidade;"))
					planos += "Reduzir a velocidade; "; 
			}else {
				planos += "Condutor ja alertado sobre problemas no pneu; ";
			}
		}
		System.out.println("Plan: "+planos);
		if(planos.contains("Ligar pisca alerta"))
			executor.ligarPisca(car);
		if(planos.contains("Alertar urgência a ida ao posto"))
			executor.alertarIdaPosto(car);
		if(planos.contains("Reduzir a velocidade"))
			executor.diminuirVelocidade(car);
		if(planos.contains("Acender faróis"))
			executor.acenderFarol(car);
		planos = "";
	}

	
}
