import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

public class JogadorVsCPU {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("IP", 8080); // informe IP e porta do servidor

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            String input;
            Random random = new Random();

            System.out.println("Bem-vindo ao jogo Par ou Impar! Digite 'sair' para encerrar.");
            System.out.println("Escolha um numero de 0 a 5:");

            while ((input = stdIn.readLine()) != null && !input.equals("sair")) {
                int jogador = Integer.parseInt(input);
                int cpu = random.nextInt(6); // Escolha aleatória da CPU

                out.println(jogador); // Envio do número escolhido pelo jogador
                out.flush();

                System.out.println("Voce escolheu: " + jogador);
                System.out.println("A CPU escolheu: " + cpu);

                int soma = jogador + cpu;
                String resultado = (soma % 2 == 0) ? "par" : "impar";

                System.out.println("A soma dos numeros e: " + soma);
                System.out.println("Resultado: " + resultado);

                String vencedor = in.readLine(); // Leitura do vencedor enviado pelo servidor
                System.out.println("Vencedor: " + vencedor);

                System.out.println("\nEscolha um numero de 0 a 5:");
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
