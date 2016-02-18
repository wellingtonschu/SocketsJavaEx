package Sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSocket
{
	public static void main(String[] args) throws IOException
	{

		// Cria o Servidor e seta como nulo
		ServerSocket servidor = null;

		// Cria uma cone��o para atender o cliente e seta como nulo
		Socket conexao = null;

		// Entrada de Dados
		BufferedReader entrada = null;

		try
		{
			
			/*
			 * Cria o ServerSocket na porta 7000 se estiver dispon�vel
			 * Lembrar de n�o utilizar portas abaixo de 1024,
			 * estas s�o utilizadas pelo sistema
			 */
			servidor = new ServerSocket(7000);
			
			/*
			 * Aguarda uma conex�o na porta especificada e retorna
			 * o socket que ir� comunicar com o cliente
			 */
			conexao = servidor.accept();

			// Cria um BufferedReader para o canal de stream de entrada de dados do socket conexao
			entrada = new BufferedReader(new InputStreamReader(conexao.getInputStream()));

			// Aguarda por algum dado e imprime a linha recebida quando recebe
			do
			{
				String texto = entrada.readLine();

				// Se o texto for nulo sai do la�o
				if (texto == null)
					break;
				System.out.println("Cliente: " + texto);
			}

			while (!"sair".equals(entrada.toString()));
		}

		catch (IOException e)
		{
			System.out.println("Algo Errado Aconteceu");
		}

		finally
		{
			// Encerra o socket de comunica��o
			conexao.close();

			// Encerra o ServerSocket
			servidor.close();
		}

	}

}