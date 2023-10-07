import java.util.Scanner;

public class usaCampeonato {
    public static void main(String[] args) throws InterruptedException {
        Campeonato j = new Campeonato();
        String n;
        String t;

        Scanner input = new Scanner(System.in);
        int opcao = 0;
        do{
            System.out.println("|________________________|");
            System.out.println("|*..:: Jogo General ::..*|");
            System.out.println("|________________________|");
            System.out.println("|1 - Incluir jogadores   |");
            System.out.println("|2 - Remover Jogador     |");
            System.out.println("|3 - Executar Rodada     |");
            System.out.println("|4 - Mostrar Cartela     |");
            System.out.println("|5 - Gravar Dados        |");
            System.out.println("|6 - Ler Dados           |");
            System.out.println("|7- Finalizar Jogo       |");
            System.out.println("|________________________|");
            System.out.print("Entre com uma opcao: ");
            opcao = input.nextInt();
            input.nextLine();
            switch(opcao){
                case 1:// incluir jogador 
                    System.out.print("Informe o nome do Jogador: ");//nome jogador
                    n = input.nextLine();

                    System.out.print("Entre com o tipo de jogador(M para maquina ou P para pessoa): ");//tipo jogador
                    t = input.nextLine();

                    j.incluirJogador(n,t);
                    break;
                case 2: //remover jogador
                    System.out.print("Informe o nome do Jogador a ser removido: ");//nome jogador
                    n = input.nextLine();

                    j.removerJogador(n);
                    break;
                case 3://iniciar campeonato
                    j.iniciarCampeonato();
                    break;
                case 4://mostrar cartela
                    j.mostrarCartela();
                    break;
                case 5://gravar dados
                    j.gravar_arquivo();
                    System.out.println("Arquivo Gerado");
                    break;
                case 6:
                    j.lerDoArquivo();
                    break;
                case 7://sair
                    System.out.println("\nFinalizando Jogo General....\n");
                    Thread.sleep(2000);
                    System.out.print("");
                    break;
                default:
                    System.out.println("Opcao invalida. Tente novamente");
                }
            }
            while(opcao != 7);
            input.close();
    }
}