package Programa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Locale;
import java.io.IOException;


public class Arquivo {
	
	public static void criarBackup() throws IOException {

		
		FileWriter arquivo = new FileWriter("./Backup.csv");
		try (PrintWriter gravarArq = new PrintWriter(arquivo)) {
			for(int i = 0;i < 95;i++) {
				gravarArq.println("0.0");	// Inicializamos o arquivo com 95 linhas e zeramos todas elas
			}
		}
		
		arquivo.close();
		
	}
	
	public static void downloadBackup(int contCase[], double somaTempo[][], double mediaTempo[][]) {
		
		try {
			
			FileReader arquivo = new FileReader("./Backup.csv");
			BufferedReader lerArq = new BufferedReader(arquivo);
			
			int i = 0, j = 0, k = 0, l = 0, m = 0, cont = 0;
			
			String linha = lerArq.readLine();
			
			while(linha != null) {
				
				if(cont < 45) {
					if(j == 9) {
						j=0;
						i++;
					}
						
					somaTempo[i][j] = Double.parseDouble(linha);	// Lemos os dados das somas dos tempos guardadas no arquivo e colocamos na matriz somaTempo[][]
					j++;
						
				} else if(cont >= 45 && cont < 50) {
					contCase[k] = Integer.parseInt(linha);
					k++;
				} else {
					if(m == 9) {
						m=0;
						l++;
					}
					mediaTempo[l][m] = Double.parseDouble(linha);	// Lemos os dados das medias dos tempos guardadas no arquivo e colocamos na matriz mediaTEmpo[][]
					m++;
					
				}
				
				linha = lerArq.readLine();
				cont++;
			} 
			
			arquivo.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void uploadBackup(int contCase[], double somaTempo[][], double mediaTempo[][]) throws IOException {
		
		
		FileWriter arquivo = new FileWriter("./Backup.csv");

		
		try (PrintWriter gravarArq = new PrintWriter(arquivo)) {
			for(int i = 0; i < 5; i++) {
				for(int j = 0; j < 9; j++) {
					if(contCase[i] == 0) {
						gravarArq.println("0.0");
					} else {
						gravarArq.println(String.format(Locale.US, "%.3f", (somaTempo[i][j])));	// Guardamos os valores das somas dos tempos da linha 1 até a 45
						
					}
				}
			}
			
			for(int i = 0; i<5; i++) {
				gravarArq.println(contCase[i]);	// Guardamos os valores das execuções da linha 46 até a 50
			}
			
			for(int i = 0; i < 5; i++) {
				for(int j = 0; j < 9; j++) {
					if(contCase[i] == 0) {
						gravarArq.println("0.0");
					} else {
						gravarArq.println(String.format(Locale.US, "%.3f", (somaTempo[i][j])/contCase[i]));	// Gravamos as medias dos tempos a partir da linha 51 até a ultima
						
					}
				}
			}
		}
		
		arquivo.close();
	}
	
}
