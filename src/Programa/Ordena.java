package Programa;

public class Ordena {
	public static double bubbleSort(int v[]) {
		int aux; //declaração de auxiliar para troca de valores caso preciso
		
		double inicio, fim;
		
		inicio = System.currentTimeMillis();	//mede tempo de início
		
		for(int x=0;x<v.length;x++) {
			for(int y=x+1;y<v.length;y++){
				if(v[x]>v[y]) { //comparação entre vetores em que caso o vetor x seja menor q vetor y, os valores vão sendo trocados
					aux=v[x];
					v[x]=v[y];
					v[y]=aux;
				}
			}
		}
		
		fim = System.currentTimeMillis();	//mede tempo final para então printar o tempo total através da subtração do tempo final pelo inicial
		
		return (fim-inicio)/1000;	// Retorna o tempo de execução em segundos;
	}
	
	public static double insertionSort(int v[]) {
		int aux; //declaração de auxiliar para que possa haver comparação entre a auxiliar y e verificar se encontra alguem menor q aux
		int y; //declaração de auxiliar para futura decrementar da posicao inicial e verificar se está organizado corretamente
		
		double inicio, fim;
		
		inicio = System.currentTimeMillis();
		
		for(int x=1;x<v.length;x++) {
			aux = v[x];
			y = x-1;
			while(y>=0&&v[y]>aux) {
				v[y+1]=v[y];
				y--;
			}
			v[y+1]=aux;
		}
		
		fim = System.currentTimeMillis();
		
		return (fim-inicio)/1000;
	}
	
	public static double selectionSort(int v[]) {
		int menor,aux;//declaração de variáveis para menorposicao e da auxiliar que vai trocar os valores depois caso necessario
		
		double inicio, fim;
		
		inicio = System.currentTimeMillis();
		
		for(int x=0;x<v.length;x++) {
			menor = x; //assumi que a posicao inicial é a que possui o menor valor para poder compara-la futuramente
			for(int y=x+1;y<v.length;y++) {
				if(v[y]<v[menor]) { //comparo o valor do vetor y com o do menor valor e caso seja, a nova menor posição é a de y
					menor = y;
				}
			}
			if(v[menor]!=v[x]) { //deixando algoritmo estável para fazer a troca de valores
				aux=v[menor];
				v[menor] = v[x];
				v[x] = aux;
			}
		}
		
		fim = System.currentTimeMillis();
		
		return (fim-inicio)/1000;
	}
	
}
