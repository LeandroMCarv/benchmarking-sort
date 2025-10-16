package Programa;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		double somaTempo[][] = new double[5][9]; 
		double mediaTempo[][] = new double[5][9];
		int op,v[];
		int contCase[] = new int[5]; //contadores para possibilitarem a média dos tempos
		
		String filePath = "./Backup.csv";
        File file = new File(filePath);

        if (file.exists()) {
        	Arquivo.downloadBackup(contCase, somaTempo, mediaTempo);	// Preenche as matrizes somaTempo e mediaTempo, e o vetor conCase com os valores gravados no arquivo
        } else {
        	Arquivo.criarBackup(); 
        }

		
		do {
			Exibe.menu();
			
			op = sc.nextInt();
			
			switch(op) {
				case 0:
					System.out.println("Saindo...");
					break;
				case 1:
					v = new int[100]; //declara que o vetor v poderá armazenar 100 posições
					Exibe.tempoGasto(v, op, somaTempo);	// Calcula o tempo gasto de cada algoritmo de ordenação para o respectivo tamanho de vetor
					contCase[0]++;
					Arquivo.uploadBackup(contCase, somaTempo, mediaTempo);	// Atualizamos o arquivo com os novos dados obtidos com a nova execução
					break;
				case 2:
					v = new int[1000]; //declara que o vetor v poderá armazenar 1000 posições
					Exibe.tempoGasto(v, op, somaTempo);
					contCase[1]++;
					Arquivo.uploadBackup(contCase, somaTempo, mediaTempo);
					break;
				case 3:
					v = new int[10000]; //declara que o vetor v poderá armazenar 10000 posições
					Exibe.tempoGasto(v, op, somaTempo);
					contCase[2]++;
					Arquivo.uploadBackup(contCase, somaTempo, mediaTempo);
					break;
				case 4:
					v = new int[100000]; //declara que o vetor v poderá armazenar 100000 posições
					Exibe.tempoGasto(v, op, somaTempo);
					contCase[3]++;
					Arquivo.uploadBackup(contCase, somaTempo, mediaTempo);
					break;
				case 5:
					v = new int[1000000]; ////declara que o vetor v poderá armazenar 1000000 posições
					Exibe.tempoGasto(v, op, somaTempo);
					contCase[4]++;
					Arquivo.uploadBackup(contCase, somaTempo, mediaTempo);
					break;
				default:
					System.out.println("Opcao invalida, tente novamente..."); //mensagem de erro caso o usuario tente um valor menor que 0 e maior que 5
					System.in.read();
					break;
			}	
		}while(op!=0);//caso o usuario digite 0, ele reconhece que ele quer sair e sai do loop
		sc.close();
	}
}