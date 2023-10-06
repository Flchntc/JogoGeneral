public class JogoGeneral {
    private Dado[] dados = new Dado[5];
    private int[] jogadas = new int[13];

    public void rolarDados(){
        for(int i = 0; i < 5; i++){
            dados[i] = new Dado();
            dados[i].roll();
        }
    }

    public String toString(){
        return "valores obtidos: "+dados[0].getSideUp()+"-"+dados[1].getSideUp()+"-"+dados[2].getSideUp()+"-"+dados[3].getSideUp()+"-"+dados[4].getSideUp();
    }

    public int validarJogada(int jogadaEscolhida) {
        switch (jogadaEscolhida) {
            case 1://jogada de 1
                int total=0;
                for(int i = 0; i < 5; i++){
                    if(dados[i].getSideUp() == 1){
                        total += 1;
                    }
                }
                if(total == 0){
                    System.out.println("Jogada Invalida");
                }
                return total;
            case 2://jogada de 2
                int total2=0;
                for(int i = 0; i < 5; i++){
                    if(dados[i].getSideUp() == 2){
                        total2 += 2;
                    }
                }
                if(total2 == 0){
                    System.out.println("Jogada Invalida");
                }
                return total2;
            case 3://jogada de 3
                int total3=0;
                for(int i = 0; i < 5; i++){
                    if(dados[i].getSideUp() == 3){
                        total3 += 3;
                    }
                }
                if(total3 == 0){
                    System.out.println("Jogada Invalida");
                }
                return total3;
            case 4://jogada de 4
                int total4=0;
                for(int i = 0; i < 5; i++){
                    if(dados[i].getSideUp() == 4){
                        total4 += 4;
                    }
                }
                if(total4 == 0){
                    System.out.println("Jogada Invalida");
                }
                return total4;
            case 5://jogada de 5
                int total5=0;
                for(int i = 0; i < 5; i++){
                    if(dados[i].getSideUp() == 5){
                        total5 += 5;
                    }
                }
                if(total5 == 0){
                    System.out.println("Jogada Invalida");
                }
                return total5;
            case 6://jogada de 6
                int total6=0;
                for(int i = 0; i < 5; i++){
                    if(dados[i].getSideUp() == 6){
                        total6 += 6;
                    }
                }
                if(total6 == 0){
                    System.out.println("Jogada Invalida");
                }
                return total6;
            case 7://trinca
                int total7=0;
                int[] cont = new int[6];
                for(int i = 0; i < 5; i++){
                    total7 += dados[i].getSideUp();
                    cont[i] = 0;
                }

                for(int i = 0; i < 5; i++){
                    int valor = dados[i].getSideUp();
                    cont[valor - 1]++;
                }
                
                for(int i = 0; i < 5; i++){
                    if(cont[i] >= 3){
                        return total7;
                    }
                }
                total7 = 0;
                System.out.println("Jogada Invalida");
                return total7;
            case 8://quadra
                int total8=0;
                int[] cont2 = new int[6];
                for(int i = 0; i < 5; i++){
                    total8 += dados[i].getSideUp();
                    cont2[i] = 0;
                }

                for(int i = 0; i < 5; i++){
                    int valor = dados[i].getSideUp();
                    cont2[valor - 1]++;
                }
                
                for(int i = 0; i < 5; i++){
                    if(cont2[i] >= 4){
                        return total8;
                    }
                }
                total8 = 0;
                System.out.println("Jogada Invalida");
                return total8;
            case 9://Fullhand ou fullhouse
                int[] cont3 = new int[6];
                for(int i = 0; i < 5; i++){
                    cont3[i] = 0;
                }

                for(int i = 0; i < 5; i++){
                    int valor = dados[i].getSideUp();
                    cont3[valor - 1]++;
                }
                
                for(int i = 0; i < 5; i++){
                    if((cont3[i] >= 3 && cont3[i++] == 2) || (cont3[i] == 2 && cont3[i++] == 3)){
                        return 25;
                    }
                }
                System.out.println("Jogada Invalida");
                return 0;
            case 10://Sequencia alta
                int[] numeros = new int[5];
                for(int i = 0; i < 5; i++){
                    numeros[i] = dados[i].getSideUp();
                }

                boolean trocou = true;
                while(trocou){  //aqui implementamos o bubblesort para ordenar e facilitar a verificacao da sequencia alta.
                    trocou = false;
                    for(int i = 0; i < 4; i++){
                        if(numeros[i] > numeros[i+1]){
                            int aux = numeros[i];
                            numeros[i] = numeros[i+1];
                            numeros[i+1] = aux;
                            trocou = true;
                        }
                    }
                }
                for(int i = 0; i < 4; i++){
                    if(numeros[i] == numeros[i+1] || numeros[i] > 6){ //aqui ele verificaria se tem uma sequencia de numeros iguais, o que impossibilita a sequencia alta
                        System.out.println("Jogada Invalida");
                        return 0;
                    }
                }
                for(int i = 0; i < 4; i++){
                    if(numeros[i+1] - numeros[i] != 1){ //verifica se a diferenca entre um numero sucessor e um antecessor é diferente de 1 o que significa que nao teria sequencia alta
                        System.out.println("Jogada Invalida");
                        return 0;
                    }
                }

                return 30;
            case 11://a logica do caso 11 é a mesma do caso 10 a unica diferenca eh uma verificacao para ver se nenhum dos numeros eh maior que 5, ja que 6 impede uma sequencia baixa
                int[] numeros2 = new int[5];
                for(int i = 0; i < 5; i++){
                    numeros2[i] = dados[i].getSideUp();
                }

                boolean troca = true;
                while(troca){  //aqui implementamos o bubblesort para ordenar e facilitar a verificacao da sequencia alta.
                    troca = false;
                    for(int i = 0; i < 4; i++){
                        if(numeros2[i] > numeros2[i+1]){
                            int aux = numeros2[i];
                            numeros2[i] = numeros2[i+1];
                            numeros2[i+1] = aux;
                            troca = true;
                        }
                    }
                }
                for(int i = 0; i < 4; i++){
                    if(numeros2[i] == numeros2[i+1] || numeros2[i] > 5){ //aqui ele verificaria se tem uma sequencia de numeros iguais, o que impossibilita a sequencia baixa
                        System.out.println("Jogada Invalida");
                        return 0;
                    }
                }
                for(int i = 0; i < 4; i++){
                    if(numeros2[i+1] - numeros2[i] != 1){ //verifica se a diferenca entre um numero sucessor e um antecessor é diferente de 1 o que significa que nao teria sequencia baixa
                        System.out.println("Jogada Invalida");
                        return 0;
                    }
                }
                return 40;
            case 12://General
                for(int i = 0; i < 4; i++){
                    if(dados[i].getSideUp() != dados[i+1].getSideUp()){
                        System.out.println("Jogada Invalida");
                        return 0;
                    }
                }
                return 50;
            case 13://Jogada aleatoria
                int total13=0;
                for(int i = 0; i < 5; i++){
                    total13+=dados[i].getSideUp();
                }
                return total13;
            default:
                return 0;
        }
    }

    public void pontuarJogada(int jogadaEscolhid,int total){//jogadaEscolhid referente a jogada escolhida, total referente a pontuacao.
        if(this.jogadas[jogadaEscolhid-1] == 0){
            this.jogadas[jogadaEscolhid-1] = total;
            if(total == 0){
                this.jogadas[jogadaEscolhid-1] = -1;
            }
        }
        else{
            System.out.println("Jogada ja escolhida!");
        }
    }

    public int[] getJogadas(){
        return jogadas;
    }
}

