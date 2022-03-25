package br.ufrn.mapecar.emulator;

import java.io.UnsupportedEncodingException;
import java.util.Random;

public class Car {
	public int ano = 2022;
	public String modelo = "Ford Fiesta";
	public String nome = "IMDCar";
	public String placa = "NRV3423";
	
	public boolean ligado = true;
	public boolean freioDeMaoPuxado = false;
	public boolean carroPertoDireita = false;
	public boolean carroPertoFrente = false;
	public boolean carroPertoTras = false;
	public boolean carroPertoEsquerda = false;
	
	public int pneuFrenteDireita = 32;
	public int pneuFrenteEsquerda = 32;
	public int pneuTrasEsquerda = 32;
	public int pneuTrasDireita = 32;
	
	public int gasolina = 100;
	public double odometro = 15526.51;
	public int velocidade = 40;
	public double latitude = 48.0202;
	public double longitude = 11.5848;
	public int inclinacao = 0;
	public int nivelOleo = 100;
	
	public void evento() {
		Random rand = new Random();
		int n = rand.nextInt(2);
		if(n==0) {
			this.carroPertoFrente = true;
			System.out.println("EVENTO: CARRO DA FRENTE ESTÁ MUITO PRÓXIMO");
		}else if(n==1) {
			this.pneuFrenteDireita = 15;
			System.out.println("EVENTO: PNEU FUROU");
		}
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
				", \n nivelOleo=" + nivelOleo + "]";
	}
}
