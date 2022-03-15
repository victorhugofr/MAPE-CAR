package br.ufrn.mapecar.emulator;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;

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
	
	String host = "http://localhost:8086/exve/";
	String charset = "UTF-8";
	String hostWithOutHttp = "localhost:8086";
	String key = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2NDczNzQxMDksImlhdCI6MTY0NzI4NzcwOSwiaXNzIjoiaHR0cHM6Ly9rbm93Z29pby5naXRodWIuY29tL2tub3dnby12ZWhpY2xlLXNpbXVsYXRvciIsImp0aSI6IjkyN2I4MzM5LTA1YTgtNTM1ZS05NzUxLWZlNmVmYzllNmMwNSIsInNjb3BlIjoic2ltdWxhdG9yOnJlYWQgc2ltdWxhdG9yOndyaXRlIHJhd19ldmVudHM6cmVhZCByYXdfZXZlbnRzOndyaXRlIG5vdGlmaWNhdGlvbnMgd2ViaG9va3MgZXh2ZS52ZWhpY2xlczpyZWFkIGV4dmUuZmxlZXRzOnJlYWQgZXh2ZS5mbGVldHM6d3JpdGUifQ.c3rZA4CdQbcaolbW4Bo3fr58KEstqbqRf3SS0R7GzwE";// Type

	public String obterValorCombustivel() throws UnsupportedEncodingException, UnirestException {
		GetRequest getR = Unirest.get(host + "vehicles/" + "947" + "/fuelLevels")
				.header("Authorization", key);

		HttpResponse<String> response = getR.asString();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(response.getBody().toString());
		return je.getAsJsonObject().get("fuelLevels").getAsJsonArray().get(0)
				.getAsJsonObject().get("value").getAsString();
	}
	
	public String obterInfosCarro() throws UnsupportedEncodingException, UnirestException {
		GetRequest getR = Unirest.get(host + "vehicles/" + "947" + "/fuelLevels")
				.header("Authorization", key);

		HttpResponse<String> response = getR.asString();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(response.getBody().toString());
		return je.getAsJsonObject().get("fuelLevels").getAsJsonArray().get(0)
				.getAsJsonObject().get("value").getAsString();
	}
	
	public void evento() {
		Random rand = new Random();
		int n = rand.nextInt(1);
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
