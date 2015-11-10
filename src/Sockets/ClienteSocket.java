package Sockets;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteSocket {
	
	public static void main (String[] args) throws IOException {
		
		Scanner in = new Scanner(System.in);
		
		String texto = "";
		
		Socket cliente = null;
		
		PrintStream saida = null;
		
		try{
			// Cria o cocket com os parâmetros
			cliente = new Socket("127.0.0.1",7000);
			
			// Stream de saida de dados
			saida = new PrintStream(cliente.getOutputStream());
			
			do{
				texto = in.nextLine();
				
				saida.println(texto);
				System.out.println("Servidor: " + texto);
			}while(!"sair".equals(texto));
		}catch (IOException e){
			System.out.println("Algo errado aconteceu");
		}finally{
			cliente.close();
		}
	}

}
