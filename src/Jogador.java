import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Jogador {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("192.168.15.11", 8080);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            System.out.println("Bem-vindo ao jogo Par ou Impar! Digite 'sair' para encerrar.");

            int rodada = 1;
            while (rodada <= 3) {
                String mensagemServidor = in.readLine();
                System.out.println(mensagemServidor);

                String perguntaParImpar = in.readLine();
                System.out.println(perguntaParImpar);
                System.out.println("Escolha um numero de 0 a 5:");
                String escolha = System.console().readLine();

                if (escolha.equals("sair")) {
                    break;
                }

                int numero = Integer.parseInt(escolha);
                System.out.println("Você escolheu: " + numero);

                out.println(numero);

                String resultado = in.readLine();
                System.out.println("Resultado: " + resultado);

                String vencedor = in.readLine();
                System.out.println("Vencedor: " + vencedor);

                rodada++;
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
