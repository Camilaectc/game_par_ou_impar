import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Jogador {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("IP", 8080);  // informe IP e porta do servidor
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Bem-vindo ao jogo Par ou Impar! Digite 'sair' para encerrar.");

            int rodada = 1;


            while (rodada <= 3) {
                String mensagemServidor = in.readLine();
                System.out.println(mensagemServidor);

                if (mensagemServidor.equals("Voce escolhe 'par' ou 'impar'?")) {
                    System.out.println("Escolha 'par' ou 'impar':");
                    String escolhaParImpar = consoleReader.readLine();
                    out.println(escolhaParImpar);
                } else if (mensagemServidor.startsWith("Jogador")) {
                    System.out.println(mensagemServidor);
                    System.out.println("Escolha um numero de 0 a 5:");
                    String escolha = consoleReader.readLine();

                    if (escolha.equals("sair")) {
                        out.println(escolha);
                        break;
                    }

                    int numero = Integer.parseInt(escolha);
                    System.out.println("Voce escolheu: " + numero);

                    out.println(numero);
                    String confirmacao = in.readLine();
                    System.out.println(confirmacao);

                } else if (mensagemServidor.startsWith("Resultado:")) {
                    // Exibir o resultado da rodada
                    System.out.println(mensagemServidor);
                } else if (mensagemServidor.startsWith("Vencedor:")) {
                    // Exibir o vencedor da rodada
                    System.out.println(mensagemServidor);
                } else if (mensagemServidor.equals("Fim do jogo!")) {

                    rodada++;
                }

            }

            String mensagemFimJogo = in.readLine();
            System.out.println(mensagemFimJogo);

            String mensagemVitorias = in.readLine();
            System.out.println(mensagemVitorias);

            String mensagemDerrotas = in.readLine();
            System.out.println(mensagemDerrotas);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
