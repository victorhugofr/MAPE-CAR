package br.ufrn.mapecar.utils;


import br.ufrn.mapecar.emulator.Car;
import br.ufrn.mapecar.mapek.Analisador;
import br.ufrn.mapecar.mapek.Executor;
import br.ufrn.mapecar.mapek.Monitor;
import br.ufrn.mapecar.mapek.Planejamento;


public class MAPEK extends Thread{
	Car car = null;
	
	public MAPEK(Car car) {
		this.car = car;
	}

	@Override
	public void run(){
		int x = 0;
		System.out.println("Iniciando MAPE-K Loop");
		while(true){
			try{
				// ENVIA AS INSTANCIAS A CADA 10 SEGUNDOS
				Thread.sleep(1000);
				Executor executor = new Executor();
				Planejamento planejamento = new Planejamento(executor);
				Analisador analisador = new Analisador(planejamento);
				Monitor monitor = new Monitor(car,analisador);
				System.out.println("Quantidade de vezes que o MAPEK foi chamado:"+(++x));
			}catch(Exception e){
				System.out.println(e);
			}
			
		}
	}
}
