import java.util.Scanner;

public class Campeonato {
    private Jogador[] jogadores = new Jogador[10];

    public void incluirJogador(String n, String tJ){//inclui um novo jogador
        for(int i = 0; i < jogadores.length; i++){
            if(jogadores[i] == null){
                jogadores[i] = new Jogador();
                jogadores[i].iniciaJogador(n,tJ);
                break;
            }
        }
    }

    public void removerJogador(String n){//remove o jogador escolhido atribuindo um espaco nulo ao seu vetor
        for(int i = 0; i < jogadores.length; i++){
            if(jogadores[i].getNome().equals(n)){
                jogadores[i] = null;
                break;
            }
        }
    }

    public void iniciarCampeonato() {//executa a rodada, permite o jogador escolher a sua jogada e informa as jogadas que ja foram escolhidas
        for (int a = 0; a < jogadores.length; a++) {
            Jogador jogadorAtual = jogadores[a];
            if (jogadorAtual != null) {
                jogadorAtual.jogarDados();
                System.out.println("Rolando dados para: " + jogadorAtual.getNome());
                System.out.println(jogadorAtual.toString());
    
                if (a < 13) {
                    System.out.print("1  2  3  4  5  6  7(T)  8(Q)  9(F) 10(S+)  11(S-)  12(G)  13(X)\n");
                    for(int i = 0; i < jogadores.length; i++){
                        if(jogadores[i] != null){
                            for(int j = 0; j < 13; j++){
                                jogadores[i].mostraJogadasExecutadas(j);
                            }
                            System.out.println();
                        }
                    }
                    
                } 
                if (jogadorAtual.getTipoJ().equalsIgnoreCase("M")) {
                    jogadorAtual.escolherJogada();
                } 
                else if (jogadorAtual.getTipoJ().equalsIgnoreCase("P")) {
                    Scanner input = new Scanner(System.in);
                    System.out.print("> ");
                    int jogada = input.nextInt();
                    jogadorAtual.escolherJogada(jogada);
                    input.close();
                }
            }
        }
    }
    

    public void mostrarCartela(){//mostra a cartela de jogadas durante o jogo
        for(int i = 0; i < jogadores.length; i++){
            if(jogadores[i] != null){
                System.out.print("      "+jogadores[i].getNome() + "("+jogadores[i].getTipoJ() + ")    ");
            }
        }
        System.out.println();
    
        for(int j = 0; j < 13; j++){
            System.out.print(" "+ (j+1));
            for(int i = 0; i < jogadores.length; i++){
                if(jogadores[i] != null){
                    jogadores[i].mostraJogadasCartela(j);
                }
            }
            System.out.println();
        }
    }
}
