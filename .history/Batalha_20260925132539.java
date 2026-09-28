import java.util.ArrayList;
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

    public int calcularCritico(){
      Random random = new Random();
      int numero = random.nextInt(101);
      return numero;
    }
    //SOBRECARGA: Dependendo da qtd de parametros, ele pode usar qualquer uma das duas funções AtualizarDano:
    public int atualizarDano(int dano){
      foiCritico = false;
      return dano;
    }
    public int atualizarDano(int dano, int critico){
      foiCritico = false;
      if (critico <= 20){
        dano = dano * 2;
        foiCritico = true;
      } 
      return dano;
    }
    
    public int calcularDano(Pokemon meuPokemon, Pokemon oponente){
        Map<String, Integer> elementos = Map.of(
        "Agua", 1,
        "Fogo", 2,
        "Ar", 3,
        "Terra", 4,
        "Elétrico", 5
      );
        int dano = 0;
        int critico = calcularCritico();
        int alvoElemento = elementos.get(oponente.getTipo());
        int escolhidoElemento = elementos.get(meuPokemon.getTipo());
        int diferenca = (alvoElemento - escolhidoElemento + 5) % 5;
        int ataqueBase = meuPokemon.getAtaquebase();
        
        if(diferenca == 1){
          dano = random.nextInt(11) + 20; // 20-30
          //nextInt(16) -> 0 até 15
          // + 15 -> 0+15, 1+15, 2+15
        } else if ( diferenca == 4){
          dano = random.nextInt(16) + 10; // 15-25
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

      public Pokemon verificarSpeed(Pokemon meuPokemon, Pokemon oponente){
        if (meuPokemon.getSpeed() > oponente.getSpeed()){
          return meuPokemon;
        } else{
          return oponente;
        }
      }
    

      public void realizarAtaque(Pokemon atacante, Pokemon defensor){
          
        int dano = calcularDano(atacante, defensor);
        //instaceof + downcasting (acessar metodos que só possui em cada PokemonElemento)
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
        } else {
            atacante.atacar();
        }
        
        if(foiCritico){
          System.out.printf("%s causou %d de %scrítico%s no oponente %s%n", atacante.getNome(), dano, cor.getRoxo(), cor.getReset(), defensor.getNome());
        } else{
          System.out.printf("%s causou %d de dano no oponente %s%n",
        atacante.getNome(), dano, defensor.getNome());
        }
        defensor.receberDano(dano);
      }

      public int calcularCaptura(int hpInicial, int hpRestante){
        int porcentagemVida = 100- ((hpRestante * 100) / hpInicial);
        return porcentagemVida;
      }
      
    public boolean batalhar(){
      System.out.println("=".repeat(30));
      System.out.println(cor.getAmarelo() + cor.getNegrito() + "=== BATALHA POKÉMON ===" + cor.getReset());
      System.out.println("=".repeat(30));
      System.out.println(cor.getVerde() + "Escolhido:"+  cor.getReset() + escolhido.getNome());
      System.out.println(cor.getRoxo() + "Oponente:"+  cor.getReset() + alvo.getNome());
      System.out.println("-----------------------------------");
      if(escolhido.getTipo().equals(alvo.getTipo())){
        
      }
      boolean capturou = false;
      while (alvo.getHp() > 0 && escolhido.getHp() > 0){
        Pokemon primeiro = verificarSpeed(escolhido, alvo);
        if (primeiro == escolhido){
          realizarAtaque(escolhido, alvo);
          if (alvo.getHp() > 0){
            realizarAtaque(alvo, escolhido);
          }
        } else {
          realizarAtaque(alvo, escolhido);
          if (escolhido.getHp() > 0){
            realizarAtaque(escolhido, alvo);
          }
        }

        System.out.printf("HP do %s %d | HP do %s: %d%n", escolhido.getNome(), escolhido.getHp(), alvo.getNome(), alvo.getHp());

        if (alvo.getHp() > 0 && escolhido.getHp() > 0){
          System.out.println("O que você deseja fazer?");
          System.out.println("1 - Atacar");
          System.out.println("2 - Capturar");
          int opcao;

          do{
            if (scanner.hasNextInt()){
              opcao = scanner.nextInt();
              if(opcao != 1 && opcao != 2){
                System.out.println("Opção inválida!\nDigite 1 - Para Atacar ou 2 - Para Capturar");
              }
            } else{
              System.out.println("Digite apenas números!");
              scanner.nextLine();
              opcao = 0;
            }
          }while(opcao != 1 && opcao != 2);

            if (opcao == 1){
                System.out.println(cor.getAmarelo() + "PRÓXIMO ROUND" + cor.getReset());
                System.out.println(cor.getCinza() + "=".repeat(30) + cor.getReset());
            } else if (opcao == 2){
              System.out.println("-----------------------------------");
              System.out.println("Você tentou capturar o Pokémon!");
            }
          
          

  
            // while(opcao != 1 && opcao != 2){
              
            //   System.out.println("Opção inválida!\nDigite 1 - Para Atacar ou 2 - Para Capturar");
            //   opcao = scanner.nextInt();
            // }
            //   if (opcao == 1){
            //     System.out.println(cor.getAmarelo() + "PRÓXIMO ROUND" + cor.getReset());
            //     System.out.println(cor.getCinza() + "=".repeat(30) + cor.getReset());
            //   } else if (opcao == 2){
            //     System.out.println("-----------------------------------");
            //     System.out.println("Você tentou capturar o Pokémon!");
                

                int chance = calcularCaptura(alvo.getHpInicial(), alvo.getHp());
                int numeroSorteadoChance = random.nextInt(100) + 1;
                if (numeroSorteadoChance <= chance){
                  System.out.println("-----------------------------------");
                  System.out.println("Você capturou o pokemon " + cor.getVerde() + alvo.getNome() + cor.getReset());
                  System.out.printf("Numero sorteado: %d. Porcentagem de chance: %d%%%n", numeroSorteadoChance, chance);
                  alvo.setHp(alvo.getHpInicial());
                  escolhido.setHp(escolhido.getHpInicial());
                  treinador.getPokedex().adicionarPokemon(alvo);
                  capturou = true;
                  
                  break;
                }else{
                  System.out.println("-----------------------------------");
                  System.out.printf("%sO pokemon %s fugiuuuu%s\n",cor.getVermelho(), alvo.getNome(), cor.getReset());
                  System.out.printf("Numero sorteado: %d. Porcentagem de chance: %d%%%n", numeroSorteadoChance, chance);
                  alvo.setHp(alvo.getHpInicial());
                  escolhido.setHp(escolhido.getHpInicial());
                  capturou = false;
                  fugiu = true;
                  break;
                }
              } 
        }
      
        if (!capturou && !fugiu){
          if (escolhido.getHp() > 0){
            System.out.println("-----------------------------------");
            System.out.printf("O seu pokemon %s foi o vencedor, então você %sganhou%s a batalha, Parabéns%n",  escolhido.getNome(),  cor.getVerde(), cor.getReset());
            alvo.setHp(alvo.getHpInicial());
            escolhido.setHp(escolhido.getHpInicial());
            escolhido.subirNivel();
            
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



