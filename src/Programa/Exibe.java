package Programa;

import java.io.IOException; //Biblioteca utilizada para que o usuário visualize os tempos de execução antes de voltar ao menu, necessitando que ele dê alguma entrada para continuar

public class Exibe {
	public static void menu() { //método que será chamado para printar o menú
		System.out.println("\tMENU DE ORGANIZACAO DE VETORES");
		System.out.println("\n0-Sair");
		System.out.println("1-Organizar vetor de tamanho 100");
		System.out.println("2-Organizar vetor de tamanho 1000");
		System.out.println("3-Organizar vetor de tamanho 10000");
		System.out.println("4-Organizar vetor de tamanho 100000");
		System.out.println("5-Organizar vetor de tamanho 1000000");
		System.out.print("Opcao escolhida: ");
	}
	
	public static void tempoGasto(int v[], int op, double somaTempo[][]) throws IOException { //Método utilizado para medir o tempo de execução dos métodos de classificação não recursivos dados em sala
		
		int tamanhoVetor = v.length;	// Recebe o tamanho do vetor analisado para ser usado na exibição dos dados
		double bubble, insertion, selection;
		
		double tempoExecucao[] = new double[9]; //tempoExecucao será usado para printar no CONSOLE os valores dos tempos das execuções atuais
		
		int vC[] = new int[v.length];//cópia do vetor crescente
		int vD[] = new int[v.length];//cópia do vetor decrescente
		int vA[] = new int[v.length];//cópia do vetor aleatório
		
		//TEMPO DE EXECUÇÃO BubbleSort
		PreencheVetor.vetorCrescente(v,vC); //Chama o método para preencher o vetor de maneira que os valores sejam do menor p/ maior
		System.out.printf("\nTempo gasto pelo Bubble Sort\nUm vetor crescente de tamanho %d: ", tamanhoVetor);
		bubble = Ordena.bubbleSort(v);	// O vetor é ordenado pelo bubble e depois a variavel bubble recebe o tempo que foi gasto
		tempoExecucao[0] = bubble;
		somaTempo[op-1][0]+= bubble;
		System.out.println(bubble + " segundo(s).");
		
		PreencheVetor.vetorDecrescente(v,vD); //Chama o método para preencher o vetor de maneira que os valores sejam do maior p/ menor
		System.out.printf("Um vetor decrescente de tamanho %d: ", tamanhoVetor);
		bubble = Ordena.bubbleSort(v);
		tempoExecucao[1] = bubble;
		somaTempo[op-1][1]+= bubble;
		System.out.println(bubble + " segundo(s).");
		
		PreencheVetor.vetorAleatorio(v,vA); //Chama o método para preencher o vetor de maneira que os valores sejam aleatórios
		System.out.printf("Um vetor aleatório de tamanho %d: ", tamanhoVetor);
		bubble = Ordena.bubbleSort(v);
		tempoExecucao[2] = bubble;
		somaTempo[op-1][2]+= bubble;
		System.out.println(bubble + " segundo(s).");
		
		
		//TEMPO DE EXECUÇÃO InsertionSort
		PreencheVetor.recuperaVetor(v, vC); // CRESCENTE
		System.out.printf("\nTempo gasto pelo Insertion Sort\nUm vetor crescente de tamanho %d: ", tamanhoVetor);
		insertion = Ordena.insertionSort(v);
		tempoExecucao[3] = insertion;
		somaTempo[op-1][3]+= insertion;
		System.out.println(insertion + " segundo(s).");
		
		PreencheVetor.recuperaVetor(v, vD); // DECRESCENTE
		System.out.printf("Um vetor decrescente de tamanho %d: ", tamanhoVetor);
		insertion = Ordena.insertionSort(v);
		tempoExecucao[4] = insertion;
		somaTempo[op-1][4]+= insertion;
		System.out.println(insertion + " segundo(s).");
		
		PreencheVetor.recuperaVetor(v, vA); // ALEATÓRIO
		System.out.printf("Um vetor aleatório de tamanho %d: ", tamanhoVetor);
		insertion = Ordena.insertionSort(v);
		tempoExecucao[5] = insertion;
		somaTempo[op-1][5]+= insertion;
		System.out.println(insertion + " segundo(s).");
		
		
		//TEMPO DE EXECUÇÃO SelectionSort
		PreencheVetor.recuperaVetor(v, vC); // CRESCENTE
		System.out.printf("\nTempo gasto pelo Selection Sort\nUm vetor crescente de tamanho %d: ", tamanhoVetor);
		selection = Ordena.selectionSort(v);
		tempoExecucao[6] = selection;
		somaTempo[op-1][6]+= selection;
		System.out.println(selection + " segundo(s).");
		
		PreencheVetor.recuperaVetor(v, vD); // DECRESCENTE
		System.out.printf("Um vetor decrescente de tamanho %d: ", tamanhoVetor);
		selection = Ordena.selectionSort(v);
		tempoExecucao[7] = selection;
		somaTempo[op-1][7]+= selection;
		System.out.println(selection + " segundo(s).");
		
		PreencheVetor.recuperaVetor(v, vA); // ALEATÓRIO
		System.out.printf("Um vetor aleatório de tamanho %d: ", tamanhoVetor);
		selection = Ordena.selectionSort(v);
		tempoExecucao[8] = selection;
		somaTempo[op-1][8]+= selection;
		System.out.println(selection + " segundo(s).");
		
		
		//FINAL DAS ORDENAÇÕES
		System.out.println("\nPressione Enter para retornar ao programa...");
		System.in.read();//aguarda o usuário apertar enter para continuar (ou ele pode digitar alguma tecla e dar imput, também funciona)
	}
	
	
}