package Programa;

import java.util.Random; //Biblioteca utilizada para poder aleatorizar valores

public class PreencheVetor {
	public static void vetorCrescente(int v[],int vC[]) {
		for(int x=0;x<v.length;x++) { 
			v[x] = x; //valores de cada vetor é o próprio índex do vetor
			vC[x] = v[x];//vetorCrescente recebendo valores de x
		}
	}
	public static void vetorDecrescente(int v[],int vD[]) {
		for(int x=0;x<v.length;x++) {
			v[x] = v.length-x; //os valores passam a começar do máximo e subtrai pelo índex do vetor preenchido
			vD[x] = v[x];//vetorDecrescente recebendo valores de x
		}
	}
	public static void vetorAleatorio(int v[],int vA[]) {
		Random r = new Random(); //método utilizado para aleatorizar os valores para armazenar no vetor
		for(int x=0;x<v.length;x++) {
			int rInt = r.nextInt(v.length); //ele irá aleatorizar valores entre 0 até o tamanho do vetor e armazenará em rInt em cada repetição
			v[x] = rInt;
			vA[x] = v[x];//vetorAleatorio recebendo valores de x
		}
	}
	
	public static void recuperaVetor(int vAlterado[],int vIntacto[]) { //Será usada para devolver os valores iniciais do vetor após organiza-los 
		for(int x=0;x<vAlterado.length;x++) {
			vAlterado[x] = vIntacto[x];
		}
	}
}
