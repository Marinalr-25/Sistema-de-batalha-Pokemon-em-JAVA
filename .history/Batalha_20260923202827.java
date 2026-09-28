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
        int alvoElemento = elementos.get(oponente.gettipo());
        int escolhidoElemento = elementos.get(meuPokemon.gettipo());
        int diferenca = (alvoElemento - escolhidoElemento + 5) % 5;


        
        
        if(diferenca == 1){
          dano = random.nextInt(11) + 20; // 20-30
          //nextInt(16) -> 0 até 15
          // + 15 -> 0+15, 1+15, 2+15
        } else if ( diferenca == 4){
          dano = random.nextInt(16) + 10; // 15-25
        } else{
          dano = random.nextInt(16) + 10; // 15-25
        }
        dano = atualizarDano(dano, critico);
        return dano;
      }

      public Pokemon verificarSpeed(Pokemon meuPokemon, Pokemon oponente){
        if (meuPokemon.getspeed() > oponente.getspeed()){
          return meuPokemon;
        } else{
          return oponente;
        }
      }
    

      public void realizarAtaque(Pokemon atacante, Pokemon defensor){
        atacante.atacar();
        int dano = calcularDano(atacante, defensor);
        System.out.println("dano dentro de realizarAtaque: " + dano);
        if(foiCritico){
          System.out.printf("%s causou %d de %scrítico%s no oponente %s%n", atacante.getnome(), dano, cor.getRoxo(), cor.getReset(), defensor.getnome());
        }
        defensor.receberDano(dano);
        System.out.printf("O dano do %s foi de %d%n", atacante.getnome(), dano);
      }

      public int calcularCaptura(int hpInicial, int hpRestante){
        int porcentagemVida = 100- ((hpRestante * 100) / hpInicial);
        return porcentagemVida;
      }
      
    public boolean batalhar(){
      System.out.println("=".repeat(30));
      System.out.println(cor.getAmarelo() + cor.getNegrito() + "=== BATALHA POKÉMON ===" + cor.getReset());
      System.out.println("=".repeat(30));
      System.out.println(cor.getVerde() + "Escolhido:"+  cor.getReset() + escolhido.getnome());
      System.out.println(cor.getRoxo() + "Oponente:"+  cor.getReset() + alvo.getnome());
      System.out.println("-----------------------------------");
      if(escolhido.gettipo().equals(alvo.gettipo())){
        
      }
      boolean capturou = false;
      while (alvo.gethp() > 0 && escolhido.gethp() > 0){
        Pokemon primeiro = verificarSpeed(escolhido, alvo);
        if (primeiro == escolhido){
          realizarAtaque(escolhido, alvo);
          if (alvo.gethp() > 0){
            realizarAtaque(alvo, escolhido);
          }
        } else {
          realizarAtaque(alvo, escolhido);
          if (escolhido.gethp() > 0){
            realizarAtaque(escolhido, alvo);
          }
        }

        System.out.printf("HP do %s %d | HP do %s: %d%n", escolhido.getnome(), escolhido.gethp(), alvo.getnome(), alvo.gethp());

        if (alvo.gethp() > 0 && escolhido.gethp() > 0){
          
          System.out.println("O que você deseja fazer?");
          System.out.println("1 - Atacar");
          System.out.println("2 - Capturar");
  
            int opcao = scanner.nextInt();
            while(opcao != 1 && opcao != 2){
              
              System.out.println("Opção inválida!\nDigite 1 - Para Atacar ou 2 - Para Capturar");
              opcao = scanner.nextInt();
            }
              if (opcao == 1){
                System.out.println(cor.getAmarelo() + "PRÓXIMO ROUND" + cor.getReset());
                System.out.println(cor.getCinza() + "=".repeat(30) + cor.getReset());
              } else if (opcao == 2){
                System.out.println("-----------------------------------");
                System.out.println("Você tentou capturar o Pokémon!");
                ArrayList<Pokemon> listaVictor = new ArrayList<>();

                int chance = calcularCaptura(alvo.gethpInicial(), alvo.gethp());
                int numeroSorteadoChance = random.nextInt(100) + 1;
                if (numeroSorteadoChance <= chance){
                  System.out.println("-----------------------------------");
                  System.out.println("Você capturou o pokemon " + cor.getVerde() + alvo.getnome() + cor.getReset());
                  System.out.printf("Numero sorteado: %d. Numero da chance: %d%n", numeroSorteadoChance, chance);
                  alvo.sethp(alvo.gethpInicial());
                  escolhido.sethp(escolhido.gethpInicial());
                  treinador.getpokedex().adicionarPokemon(alvo);
                  capturou = true;
                  
                  break;
                }else{
                  System.out.println("-----------------------------------");
                  System.out.printf("O pokemon %s fugiuuuu\n", alvo.getnome());
                  System.out.printf("Numero sorteado: %d. Numero da chance: %d%n", numeroSorteadoChance, chance);
                  alvo.sethp(alvo.gethpInicial());
                  escolhido.sethp(escolhido.gethpInicial());
                  capturou = false;
                  fugiu = true;
                  break;
                }
              } 
        }
      }
        if (!capturou && !fugiu){
          if (escolhido.gethp() > 0){
            System.out.println("-----------------------------------");
            System.out.printf("O seu pokemon %s foi o vencedor, então você %sganhou%s a batalha, Parabéns%n",  escolhido.getnome(),  cor.getVerde(), cor.getReset());
            alvo.sethp(alvo.gethpInicial());
            escolhido.sethp(escolhido.gethpInicial());
            
          }else{
            System.out.println("-----------------------------------");
            System.out.printf("O oponente %s%s%s foi o vencedor, então você %sperdeu%s a batalha. Boa sorte na próxima%n", cor.getGanhdor(), alvo.getnome(), cor.getReset(), cor.getVermelho(), cor.getReset());
            alvo.sethp(alvo.gethpInicial());
            escolhido.sethp(escolhido.gethpInicial());
          }
        }
        
        return capturou;
      }
    }



