import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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

    public void iniciarCampeonato() throws InterruptedException {//executa a rodada, permite o jogador escolher a sua jogada e informa as jogadas que ja foram escolhidas
        System.out.println("Executando Rodada....");
        Thread.sleep(2000);
        System.out.print("");
        for (int a = 0; a < jogadores.length; a++) {
            Jogador jogadorAtual = jogadores[a];
            if (jogadorAtual != null) {
                jogadorAtual.jogarDados();
                System.out.println("Rolando dados para: " + jogadorAtual.getNome());
                Thread.sleep(2000);
                System.out.println("");
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
                    System.out.println("Escolhendo Jogada....");
                    Thread.sleep(2000);
                    System.out.println("");
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
    
    public void mostrarCartela() throws InterruptedException{//mostra a cartela de jogadas durante o jogo
        System.out.println("Gerando Cartela....");
        Thread.sleep(1000);
        System.out.print("");
        for(int i = 0; i < jogadores.length; i++){
            if(jogadores[i] != null){
                System.out.print("    "+jogadores[i].getNome() + "("+jogadores[i].getTipoJ() + ")  ");
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

    public void gravar_arquivo() throws InterruptedException{/*Gravar em arquivo*/
        System.out.println("Gerando Arquivo(Jogadores.dat)....");
        Thread.sleep(1000);
        System.out.print("");
        File arquivo = new File("jogadores.dat");
        try {
            FileOutputStream fout = new FileOutputStream(arquivo);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            // gravando o vetor de pessoas no arquivo
                oos.writeObject(jogadores);
                oos.flush();
                oos.close();
                fout.close();
            }
        catch (Exception ex) {
            System.err.println("erro: " + ex.toString());
        }
    }

    public void lerDoArquivo() throws InterruptedException{
        System.out.println("Lendo Arquivo(Jogadores.dat)....");
        Thread.sleep(1000);
        System.out.print("");
        File arquivo = new File("jogadores.dat");
        try {
            FileInputStream fin = new FileInputStream(arquivo);
            ObjectInputStream oin = new ObjectInputStream(fin);
            /*Lendo os objetos de um arquivo e fazendo a
            coercao de tipos*/
            
            Jogador[] JogadorArq = (Jogador[]) oin.readObject();
            oin.close();
            fin.close();
            
            //Uma forma de diferente do for para percorrer vetores
            for (Jogador p : JogadorArq) {
                if(p != null){
                    System.out.println("-----------------------------------------------------------------------------");
                    for(int i = 0; i < jogadores.length; i++){
                        if(jogadores[i] != null){
                            System.out.print("     "+jogadores[i].getNome() + "("+jogadores[i].getTipoJ() + ")  ");
                        }
                    }
                    System.out.println();
                    System.out.println("-----------------------------------------------------------------------------");
                
                    for(int j = 0; j < 13; j++){
                        System.out.print(" "+ (j+1));
                        for(int i = 0; i < jogadores.length; i++){
                            if(jogadores[i] != null){
                                jogadores[i].mostraJogadasCartela(j);
                            }
                        }
                        System.out.println();
                    }
                        System.out.println("-----------------------------------------------------------------------------");
                }
            }
            }catch (Exception ex) {
                System.err.println("erro: " + ex.toString());
            }
    }
}