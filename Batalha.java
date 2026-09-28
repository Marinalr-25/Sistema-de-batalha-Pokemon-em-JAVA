import java.util.Map;
import java.util.Random;
import java.util.Scanner;

// poseidon → é o argumento passado ao construtor.
// escolhido → é o atributo da Batalha que guarda o Poseidon.
// atacante → é o parâmetro de realizarAtaque que recebe o valor de escolhido.

public class Batalha {
    Pokemon escolhido;
    Pokemon alvo;
    Treinador treinador;
    Boolean foiCritico;
    boolean fugiu = false;

    Cores cor = new Cores();
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    public Batalha(Pokemon escolhido, Pokemon alvo, Treinador treinador){
      this.alvo = alvo;
      this.escolhido = escolhido;
      this.treinador = treinador;
    }

    //Sortea um numero aleatorio 
    public int calcularCritico(){
      Random random = new Random();
      int numero = random.nextInt(101);
      return numero;
    }
    //SOBRECARGA: Dependendo da qtd de parametros, ele pode usar qualquer uma das duas funções AtualizarDano:
    //1 argumento -> nao possui critico
    public int atualizarDano(int dano){
      foiCritico = false;
      return dano;
    }
    //2 argumentos ->  possui critico
    public int atualizarDano(int dano, int critico){
      foiCritico = false;
      if (critico <= 20){
        dano = dano * 2;
        foiCritico = true;
      } 
      return dano;
    }
    //calcula o dano dependendo do tipo do pokemon
    public int calcularDano(Pokemon meuPokemon, Pokemon oponente){
        Map<String, Integer> elementos = Map.of(
        "Agua", 1,
        "Fogo", 2,
        "Ar", 3,
        "Terra", 4,
        "Elétrico", 5
      );
        int dano;
        int critico = calcularCritico();
        int alvoElemento = elementos.get(oponente.getTipo());
        int escolhidoElemento = elementos.get(meuPokemon.getTipo());
        int diferenca = (alvoElemento - escolhidoElemento + 5) % 5;
        int ataqueBase = meuPokemon.getAtaquebase();
        
        //verifica se o meu pokemon é counter do alvo
        //se o resultado do calculo "diferenca" for 1 -> ele é counter
        if(diferenca == 1){
          dano = random.nextInt(11) + 20; // 20-30
        //se o resultado do calculo "diferenca" for 4 -> ele é counterizado
      } else if ( diferenca == 4){
        dano = random.nextInt(16) + 10; // 15-25
        //se o resultado do calculo "diferenca" diferente de 1 ou 4 -> o dano mantem padrao
        } else{
          dano = random.nextInt(16) + 10; // 15-25
        }

        //SOBRECARGA
        if (critico <= 20) {
          dano = atualizarDano(dano, critico);
        } else {
          dano = atualizarDano(dano);
        }
        return dano;
      }
      //verificar qual pokemon tem o maior speed
    public Pokemon verificarSpeed(Pokemon meuPokemon, Pokemon oponente){
        if (meuPokemon.getSpeed() > oponente.getSpeed()){
          return meuPokemon;
        } else{
          return oponente;
        }
      }
  
      //Verifica tipo, calcula dano, ataca e recebeDano
    public void realizarAtaque(Pokemon atacante, Pokemon defensor){
        //calcula o dano em base do elemento
        int dano = calcularDano(atacante, defensor);
        //instaceof + downcasting (acessar metodos que só possui em cada PokemonElemento)
        //se o dano for maior que o hp do defensor, ele usa um ataque especial dependendo de qual elemento o pokemon é
        if (dano >= defensor.getHp()) {
          if (atacante instanceof PokemonFogo) {
              PokemonFogo fogo = (PokemonFogo) atacante;
              fogo.ataqueChamasFinais();
          }else if (atacante instanceof PokemonAgua) {
              PokemonAgua agua = (PokemonAgua) atacante;
              agua.ataqueMareDevastadora();
          }else if (atacante instanceof PokemonAr) {
              PokemonAr ar = (PokemonAr) atacante;
              ar.ataqueTornadoSupremo();
          }else if (atacante instanceof PokemonTerra) {
              PokemonTerra terra = (PokemonTerra) atacante;
              terra.ataqueFuriaDaTerra();
          }else if (atacante instanceof PokemonEletricidade) {
              PokemonEletricidade eletrico = (PokemonEletricidade) atacante;
              eletrico.ataqueTempestadeEletrica();
          }
          //se o dano nao for maior que o hp, ele apenas ataca e segue a batalha normalmente
        } else {
            atacante.atacar();
        }
        
        //verifica se foi critico para exibir uma msg com critico
        if(foiCritico){
          System.out.printf("%s causou %d de %scrítico%s no oponente %s%n", atacante.getNome(), dano, cor.getRoxo(), cor.getReset(), defensor.getNome());
          //caso contrario, informa apenas o dano
        } else{
          System.out.printf("%s causou %d de dano no oponente %s%n",
        atacante.getNome(), dano, defensor.getNome());
        }
        //defensor recebe o dano do atacante e subtrai com o hp
        defensor.receberDano(dano);
      }

      //verifica a porcentagem de chance da captura
    public int calcularCaptura(int hpInicial, int hpRestante){
        int porcentagemVida = 100- ((hpRestante * 100) / hpInicial);
        return porcentagemVida;
      }

    //batalhar() retorna o valor booleano de capturou para no app retirar o pokemon selvagem da lista e adicionar na pokedex
    public boolean batalhar(){
      System.out.println("=".repeat(30));
      System.out.println(cor.getAmarelo() + cor.getNegrito() + "=== BATALHA POKÉMON ===" + cor.getReset());
      System.out.println("=".repeat(30));
      System.out.println(cor.getVerde() + "Escolhido:"+  cor.getReset() + escolhido.getNome());
      System.out.println(cor.getRoxo() + "Oponente:"+  cor.getReset() + alvo.getNome());
      System.out.println("-----------------------------------");
      
      
      boolean capturou = false;
      //se os dois estiverem vivos, a batalha inicia
      while (alvo.getHp() > 0 && escolhido.getHp() > 0){
        //verifica quem tem o maior speed e começa o round primeiro aquele q tiver o speed maior
        Pokemon primeiro = verificarSpeed(escolhido, alvo);
        if (primeiro == escolhido){
          realizarAtaque(escolhido, alvo);
          //verifica se depois do ataque do primeiro, se o alvo nao morreu
          if (alvo.getHp() > 0){
            realizarAtaque(alvo, escolhido);
          }
          //mesma lógica de cima, só muda que o oponente começa atacando
        } else {
          realizarAtaque(alvo, escolhido);
          if (escolhido.getHp() > 0){
            realizarAtaque(escolhido, alvo);
          }
        }
        //Mostra o hp dos dois após o final daquele round
        System.out.printf("HP do %s %d | HP do %s: %d%n", escolhido.getNome(), escolhido.getHp(), alvo.getNome(), alvo.getHp());
        //Se os dois pokemons estiverem vivos, a batalha continua
        if (alvo.getHp() > 0 && escolhido.getHp() > 0){
          int opcao;
          //se a opção digitada for letras ou diferente de 1 e 2, ele da erro e pede pra digitar novamente
          do{
            System.out.println("O que você deseja fazer?");
            System.out.println("1 - Atacar");
            System.out.println("2 - Capturar");
            if(scanner.hasNextInt()){
              opcao = scanner.nextInt();
              if(opcao != 1 && opcao != 2){
                System.out.printf("%sOpção inválida!%s\nDigite 1 ou 2 %n", cor.getVermelho(), cor.getReset());
              }
            } else{
                System.out.printf("%sOpção inválida! Digite apenas números%s%n", cor.getVermelho(), cor.getReset());
                scanner.nextLine();
                opcao = 0;
            }
          }while(opcao != 1 && opcao != 2);
            
            
              //Se digitar 1 Atacar, vai para o próximo round
              if (opcao == 1){
                System.out.println(cor.getAmarelo() + "PRÓXIMO ROUND" + cor.getReset());
                System.out.println(cor.getCinza() + "=".repeat(30) + cor.getReset());

                //Se digitar 2 Capturar, vai calcular a chance de captura
              } else if (opcao == 2){
                System.out.println("-----------------------------------");
                System.out.println("Você tentou capturar o Pokémon!");

                int chance = calcularCaptura(alvo.getHpInicial(), alvo.getHp());
                int numeroSorteadoChance = random.nextInt(100) + 1;
                if (numeroSorteadoChance <= chance){
                  System.out.println("-----------------------------------");
                  System.out.println("Você capturou o pokemon " + cor.getVerde() + alvo.getNome() + cor.getReset());
                  System.out.printf("Numero sorteado: %d. Porcentagem de chance: %d\n", numeroSorteadoChance, chance);
                  alvo.setHp(alvo.getHpInicial());
                  escolhido.setHp(escolhido.getHpInicial());
                  treinador.getPokedex().adicionarPokemon(alvo);
                  capturou = true;
                  break;
                }else{
                  System.out.println("-----------------------------------");
                  System.out.printf("%sO pokemon %s fugiuuuu%s\n",cor.getVermelho(), alvo.getNome(), cor.getReset());
                  System.out.printf("Numero sorteado: %d. Porcentagem de chance: %d\n", numeroSorteadoChance, chance);
                  alvo.setHp(alvo.getHpInicial());
                  escolhido.setHp(escolhido.getHpInicial());
                  capturou = false;
                  fugiu = true;
                  break;
                }
              } 
        }
      }
        //se ele nao capturou e o pokemon nao fugiu...
        if (!capturou && !fugiu){
          //se você venceu a batalha, sobe de nivel
          if (escolhido.getHp() > 0){
            System.out.println("-----------------------------------");
            System.out.printf("O seu pokemon %s foi o vencedor, então você %sganhou%s a batalha, Parabéns%n",  escolhido.getNome(),  cor.getVerde(), cor.getReset());
            alvo.setHp(alvo.getHpInicial());
            escolhido.setHp(escolhido.getHpInicial());
            escolhido.subirNivel();
          // se você perdeu a batalha, mostra a mensagem do alvo vencedor
          }else{
            System.out.println("-----------------------------------");
            System.out.printf("O oponente %s%s%s foi o vencedor, então você %sperdeu%s a batalha. Boa sorte na próxima%n", cor.getGanhdor(), alvo.getNome(), cor.getReset(), cor.getVermelho(), cor.getReset());
            alvo.setHp(alvo.getHpInicial());
            escolhido.setHp(escolhido.getHpInicial());
          }
        }
        return capturou;
      }
    }



