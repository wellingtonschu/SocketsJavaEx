package Sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSocket {
	public static void main(String[] args) throws IOException {
		// Cria o Servidor e seta como nulo;
		ServerSocket servidor = null;

		// Cria uma coneção para atender o cliente e seta como nulo
		Socket conexao = null;

		// Entrada de Dados
		BufferedReader entrada = null;

		try {
			servidor = new ServerSocket(7000);

			conexao = servidor.accept();

			entrada = new BufferedReader(new InputStreamReader(conexao.getInputStream()));

			do {
				String texto = entrada.readLine();
				if (texto == null)
					break;
				System.out.println("Cliente: " + texto);
			} while (!"sair".equals(entrada.toString()));
		} catch (IOException e) {
			System.out.println("Algo Errado Aconteceu");
		} finally {
			conexao.close();
			servidor.close();
		}
	}
}