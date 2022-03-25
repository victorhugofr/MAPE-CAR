package br.ufrn.mapecar.emulator;

import java.util.Random;

public class Car {
	public int ano = 2022;
	public String modelo = "Ford Fiesta";
	public String nome = "IMDCar";
	public String placa = "NRV3423";
	
	public boolean idaAoPosto = false;
	public boolean farol = false;
	public boolean ligado = true;
	public boolean freioDeMaoPuxado = false;
	public boolean carroPertoDireita = false;
	public boolean carroPertoFrente = false;
	public boolean carroPertoTras = false;
	public boolean carroPertoEsquerda = false;
	public boolean chuva = false;
	public boolean neblina = false;
	public boolean piscaAlerta = false;
	
	public int pneuFrenteDireita = 32;
	public int pneuFrenteEsquerda = 32;
	public int pneuTrasEsquerda = 32;
	public int pneuTrasDireita = 32;
	
	public double gasolina = 100.00;
	public double odometro = 15526.51;
	public int velocidade = 60;
	public double latitude = 48.0202;
	public double longitude = 11.5848;
	public int inclinacao = 0;
	public int nivelOleo = 100;
	
	public void evento() {
		Random rand = new Random();
		int n = rand.nextInt(5);
		if(n==0) {
			this.carroPertoFrente = true;
			System.out.println("EVENTO: CARRO DA FRENTE ESTÁ MUITO PRÓXIMO");
		}else if(n==1) {
			if(this.pneuFrenteDireita != 15) {
				this.pneuFrenteDireita = 15;
				System.out.println("EVENTO: PNEU DA FRENTE DIREITA FUROU");
			}else {
				evento();
			}
		}else if(n==2) {
			if(this.pneuFrenteEsquerda != 15) {
				this.pneuFrenteEsquerda = 15;
				System.out.println("EVENTO: PNEU DA FRENTE ESQUERDA FUROU");
			}else {
				evento();
			}
		}else if(n==3) {
			this.chuva = true;
			System.out.println("EVENTO: CHUVA FORTE A FRENTE");
		}else if(n==4) {
			this.neblina = true;
			System.out.println("EVENTO: NEBLINA A FRENTE");
		}
	}
	
	public void atualizaInfos() {
		Random rand = new Random();
		int n = rand.nextInt(2);
		if(n==1) {
			this.gasolina -= 0.01;
			this.velocidade -= 1;
			this.latitude -=  0.1;
			this.longitude -=  0.1;
			this.inclinacao -=1;
		}else {
			this.gasolina -= 0.01;
			this.velocidade += 1;
			this.latitude +=  0.2;
			this.longitude +=  0.2;
			if(this.inclinacao<0)
				this.inclinacao +=4;
		}
		this.velocidade += 1;
	}

	@Override
	public String toString() {
		return "Car [ano=" + ano + ", \nmodelo=" + modelo + 
				", \n nome=" + nome + 
				", \n placa=" + placa 
				+ ", \n ligado=" + ligado
				+ ", \n freioDeMaoPuxado=" + freioDeMaoPuxado + 
				", \n carroPertoDireita=" + carroPertoDireita
				+ ", \n carroPertoFrente=" + carroPertoFrente + 
				", \n carroPertoTras=" + carroPertoTras
				+ ", \n carroPertoEsquerda=" + carroPertoEsquerda 
				+ ", \n pneuFrenteDireita=" + pneuFrenteDireita
				+ ", \n pneuFrenteEsquerda=" + pneuFrenteEsquerda 
				+ ", \n pneuTrasEsquerda=" + pneuTrasEsquerda
				+ ", \n  pneuTrasDireita=" + pneuTrasDireita 
				+ ", \n gasolina=" + gasolina + 
				", \n odometro=" + odometro
				+ ", \n velocidade=" + velocidade 
				+ ", \n latitude=" + latitude +
				", \n longitude=" + longitude +
				", \n inclinacao="+ inclinacao + 
				", \n piscaAlerta="+ piscaAlerta + 
				", \n chuva="+ chuva + 
				", \n neblina="+ neblina + 
				", \n farol="+ farol + 
				", \n nivelOleo=" + nivelOleo + "]";
	}
}
