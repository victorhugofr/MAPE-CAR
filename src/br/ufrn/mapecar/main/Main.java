package br.ufrn.mapecar.main;

import java.io.UnsupportedEncodingException;

import com.mashape.unirest.http.exceptions.UnirestException;

import br.ufrn.mapecar.emulator.Car;
import br.ufrn.mapecar.utils.Cronometro;
import br.ufrn.mapecar.utils.Eventos;
import br.ufrn.mapecar.utils.MAPEK;

public class Main {

	public static void main(String[] args) throws UnsupportedEncodingException, UnirestException {
		Car car = new Car();
		new Eventos(car).start();
		new MAPEK(car).start();
		new Cronometro().start();
	}

}
