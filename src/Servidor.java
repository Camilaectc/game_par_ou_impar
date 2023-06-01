import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080); //informe a porta onde o servidor está sendo carregado
            System.out.println("Aguardando a conexao do Jogador 1...");
            Socket jogador1Socket = serverSocket.accept();
            System.out.println("Jogador 1 conectado.");

            System.out.println("Aguardando a conexao do Jogador 2...");
            Socket jogador2Socket = serverSocket.accept();
            System.out.println("Jogador 2 conectado.");

            BufferedReader jogador1In = new BufferedReader(new InputStreamReader(jogador1Socket.getInputStream()));
            PrintWriter jogador1Out = new PrintWriter(jogador1Socket.getOutputStream(), true);

            BufferedReader jogador2In = new BufferedReader(new InputStreamReader(jogador2Socket.getInputStream()));
            PrintWriter jogador2Out = new PrintWriter(jogador2Socket.getOutputStream(), true);

            int rodada = 1;
            int vitoriasJogador1 = 0;
            int vitoriasJogador2 = 0;

            while (rodada <= 3) {
                System.out.println("Rodada " + rodada);

                jogador1Out.println("Voce escolhe 'par' ou 'impar'?");
                String jogador1ParImpar = jogador1In.readLine();
                System.out.println("Jogador 1 escolheu: " + jogador1ParImpar);

                jogador2Out.println("Voce escolhe 'par' ou 'impar'?");
                String jogador2ParImpar = jogador2In.readLine();
                System.out.println("Jogador 2 escolheu: " + jogador2ParImpar);

                if (jogador1ParImpar.equalsIgnoreCase(jogador2ParImpar)) {
                    jogador1Out.println("Opção invalida. Escolha diferente de " + jogador2ParImpar);
                    jogador2Out.println("Opção invalida. Escolha diferente de " + jogador1ParImpar);
                    continue;
                }

                jogador1Out.println("Jogador 1: Escolha um numero de 0 a 5.");
                String jogador1EscolhaStr = jogador1In.readLine();
                int jogador1Escolha = Integer.parseInt(jogador1EscolhaStr);
                System.out.println("Jogador 1 escolheu: " + jogador1Escolha);

                jogador2Out.println("Jogador 2: Escolha um numero de 0 a 5.");
                String jogador2EscolhaStr = jogador2In.readLine();
                int jogador2Escolha = Integer.parseInt(jogador2EscolhaStr);
                System.out.println("Jogador 2 escolheu: " + jogador2Escolha);

                int soma = jogador1Escolha + jogador2Escolha;
                System.out.println("A soma dos numeros e: " + soma);

                String resultado = (soma % 2 == 0) ? "par" : "impar";
                System.out.println("Resultado: " + resultado);

                String vencedor;
                if ((jogador1Escolha % 2 == 0 && resultado.equals("par"))
                        || (jogador1Escolha % 2 != 0 && resultado.equals("impar"))) {
                    vencedor = "Jogador 1";
                    vitoriasJogador1++;
                } else {
                    vencedor = "Jogador 2";
                    vitoriasJogador2++;
                }
                System.out.println("Vencedor: " + vencedor);

                jogador1Out.println("Resultado: " + resultado);
                jogador1Out.println("Vencedor: " + vencedor);

                jogador2Out.println("Resultado: " + resultado);
                jogador2Out.println("Vencedor: " + vencedor);

                rodada++;
            }

            jogador1Out.println("Fim do jogo!");
            jogador1Out.println("Numero de vitorias do Jogador 1: " + vitoriasJogador1);
            jogador1Out.println("Numero de derrotas do Jogador 1: " + vitoriasJogador2);

            jogador2Out.println("Fim do jogo!");
            jogador2Out.println("Numero de vitorias do Jogador 2: " + vitoriasJogador2);
            jogador2Out.println("Numero de derrotas do Jogador 2: " + vitoriasJogador1);

            jogador1Socket.close();
            jogador2Socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
