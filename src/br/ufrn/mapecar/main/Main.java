package br.ufrn.mapecar.main;

import java.io.UnsupportedEncodingException;

import br.ufrn.mapecar.emulator.Car;
import br.ufrn.mapecar.utils.Cronometro;
import br.ufrn.mapecar.utils.Eventos;
import br.ufrn.mapecar.utils.MAPEK;

public class Main {

	public static void main(String[] args) throws UnsupportedEncodingException {
		Car car = new Car();
		new Eventos(car).start();
		new MAPEK(car).start();
		new Cronometro(car).start();
	}

}
