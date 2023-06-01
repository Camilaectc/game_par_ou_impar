# Jogo Par ou Ímpar

## Descrição

O jogo "Par ou Ímpar" é um jogo simples em que dois jogadores competem para determinar se a soma dos números escolhidos é par ou ímpar. O objetivo do jogo é acertar se o resultado será par ou ímpar e ser o primeiro a alcançar um número específico de vitórias.

## Funcionamento do Jogo

O jogo é jogado entre dois jogadores, Jogador 1 e Jogador 2. Cada jogador terá a oportunidade de escolher um número de 0 a 5 em cada rodada. A soma dos números escolhidos pelos jogadores será calculada e determinará se o resultado é par ou ímpar.

O jogador que acertar o resultado (par ou ímpar) é declarado vencedor da rodada. Após cada rodada, o número de vitórias de cada jogador é atualizado.

O jogo continua por um número fixo de rodadas. No final das rodadas, o jogador com o maior número de vitórias é declarado vencedor do jogo.

## Instruções de Uso

1. **Execute o servidor:**

    - Abra um terminal ou prompt de comando.
    - Navegue até o diretório onde os arquivos do jogo estão localizados.
    - Compile e execute o arquivo `Servidor.java`.

      ```bash
      javac Servidor.java
      java Servidor
      ```

    - O servidor estará aguardando a conexão dos jogadores.

2. **Execute os jogadores:**

    - Abra dois terminais ou prompts de comando separados.
    - Navegue até o diretório onde os arquivos do jogo estão localizados.
    - Compile e execute o arquivo `Jogador.java` em cada terminal.

      ```bash
      javac Jogador.java
      java Jogador
      ```

    - Os jogadores serão conectados ao servidor e poderão jogar.

3. **Jogando o jogo:**

    - Cada jogador receberá instruções e fará suas escolhas em cada rodada.
    - Os jogadores devem digitar um número de 0 a 5 quando solicitado.
    - O jogo continuará até o final das rodadas.
    - Após o término do jogo, o número de vitórias de cada jogador será exibido.

4. **Execute o jogo Jogador vs. CPU:**
   
   - Execute o passo 1.
   - Abra um terminal ou prompt de comando.
   - Navegue até o diretório onde os arquivos do jogo estão localizados.
   - Compile e execute o arquivo `JogadorVsCPU.java`.

     ```bash
     javac JogadorVsCPU.java
     java JogadorVsCPU
     ```

   - O jogo será iniciado e você poderá jogar contra a CPU.

5. **Jogando contra a CPU:**

   - Você será solicitado a escolher entre jogar como Jogador 1 ou Jogador 2.
   - Faça sua escolha digitando '1' para Jogador 1 ou '2' para Jogador 2.
   - Em cada rodada, você fará sua escolha de número de 0 a 5.
   - A CPU fará sua escolha automaticamente.
   - O jogo continuará até o final das rodadas.
   - Após o término do jogo, o número de vitórias de cada jogador será exibido.

## Requisitos do Sistema

- Java  Development Kit (JDK) instalado
- Ambiente de desenvolvimento ou terminal para executar os comandos

## Contribuição

Contribuições são bem-vindas! Se você tiver sugestões, melhorias ou correções para o jogo, fique à vontade para enviar um pull request.

## Participantes

- Camila Evelyn Correa Teixeira da Costa RA: 125111350341
- Gean Lucas de Souza Lima RA: 125111359133
- Paloma Aparecida dos Santos Silva RA: 125111375946
- Bruno Marcomini Gimenes Pereira RA: 125111348740
