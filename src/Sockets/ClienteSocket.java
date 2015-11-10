package Sockets;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteSocket
{
	
	public static void main (String[] args) throws IOException
	{
		
		// Utilizado para leitura do teclado
		Scanner in = new Scanner(System.in);
		
		// Variável para armazenar o texto que será digitado
		String texto = "";
		
		// Socket Cliente
		Socket cliente = null;
		
		// Stream (tubo) de saída de dados
		PrintStream saida = null;
		
		try
		{
			// Cria o socket com os parâmetros
			cliente = new Socket("127.0.0.1",7000);
			
			// Stream de saida de dados
			saida = new PrintStream(cliente.getOutputStream());
			
			do
			{
				// Lê o teclado do cliente
				texto = in.nextLine();
				
				// Imprime o texto para o stream de saída de dados (Servidor)
				saida.println(texto);
				System.out.println("Servidor: " + texto);
			}
			
			while(!"sair".equals(texto));
		}
		
		catch (IOException e)
		{
			System.out.println("Algo errado aconteceu");
		}
		
		finally
		{
			// Encerra o socket Cliente
			cliente.close();
		}
		
	}

}
