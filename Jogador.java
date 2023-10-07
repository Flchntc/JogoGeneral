import java.util.Random;

public class Jogador {
    private String nome;
    private String tipoJogador;
    private JogoGeneral jogoG = new JogoGeneral();

    public void iniciaJogador(String n, String tJ){//inicia a classe jogador
        this.nome = n;
        this.tipoJogador = tJ;
    }

    public void jogarDados(){
        jogoG.rolarDados();
    }

    public String toString(){
        return "valores obtidos: "+jogoG;
    }

    public void escolherJogada(int jogadaEscolhida){//escolherJogada para o jogador humano
        int total;
        total = jogoG.validarJogada(jogadaEscolhida);
        jogoG.pontuarJogada(jogadaEscolhida, total);
    }

    public void escolherJogada(){//escolherJogada para o jogador maquina
        int total = 0;
        Random random = new Random();
        int jEscMaq;
        jEscMaq = random.nextInt(13) + 1;
        while(total == 0){
            total = jogoG.validarJogadaBot(jEscMaq);
            jEscMaq = random.nextInt(13) + 1;
        }
        jogoG.pontuarJogada(jEscMaq, total);
    }

    public void mostraJogadasExecutadas(int i){//funcao para mostrar as jogadas executadas durante a partida
        int[] jogadasExecutadas = jogoG.getJogadas();
        if(i < 6){
            if(jogadasExecutadas[i] == 0 || jogadasExecutadas[i] == -1){
                System.out.print("-" + "  ");
            }
            else{
                System.out.print("" + jogadasExecutadas[i]+ "  ");
            }
        }
        else{
            if(jogadasExecutadas[i] == 0 || jogadasExecutadas[i] == -1){
                System.out.print("-" + "      ");
            }
            else{
                if(jogadasExecutadas[i] < 10){
                    System.out.print("" + jogadasExecutadas[i] + "      ");
                }
                else{
                    System.out.print("" + jogadasExecutadas[i] + "     ");
                }
                System.out.print("" + jogadasExecutadas[i]+ "      ");
            }   
        }
    }

    public void mostraJogadasCartela(int i){//funcao para mostrar as jogadas estruturada para o formato da cartela
        int[] jogadasExecutadas = jogoG.getJogadas();
        if(i < 9){
            if(jogadasExecutadas[i] == 0 || jogadasExecutadas[i] == -1){
                System.out.print("      X" + "     ");
            }
            else{
                System.out.print("      " + jogadasExecutadas[i] + "     ");
            }
        }
        else{
            if(jogadasExecutadas[i] == 0 || jogadasExecutadas[i] == -1){
                System.out.print("     X" + "      ");
            }
            else{
                if(jogadasExecutadas[i] < 10){
                    System.out.print("     " + jogadasExecutadas[i] + "      ");
                }
                else{
                    System.out.print("     " + jogadasExecutadas[i] + "    ");
                }
            }
        }
        System.out.print("     ");
    }

    public String getNome(){
        return nome;
    }
    public String getTipoJ(){
        return tipoJogador;
    }

}
