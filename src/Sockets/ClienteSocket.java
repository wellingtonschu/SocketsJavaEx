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
		
		// Vari�vel para armazenar o texto que ser� digitado
		String texto = "";
		
		// Socket Cliente
		Socket cliente = null;
		
		// Stream (tubo) de sa�da de dados
		PrintStream saida = null;
		
		try
		{
			// Cria o socket com os par�metros
			cliente = new Socket("127.0.0.1",7000);
			
			// Stream de saida de dados
			saida = new PrintStream(cliente.getOutputStream());
			
			do
			{
				// L� o teclado do cliente
				texto = in.nextLine();
				
				// Imprime o texto para o stream de sa�da de dados (Servidor)
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
