import java.util.Map;
import java.util.Random;
import java.util.Scanner;

// poseidon → é o argumento passado ao construtor.
// escolhido → é o atributo da Batalha que guarda o Poseidon.
// atacante → é o parâmetro de realizarAtaque que recebe o valor de escolhido.

public class Batalha {
    Pokemon escolhido;
    Pokemon alvo;
    Boolean foiCritico;

    Cores cor = new Cores();
    Scanner scanner = new Scanner(System.in);
    

    public Batalha(Pokemon escolhido, Pokemon alvo){
      this.alvo = alvo;
      this.escolhido = escolhido;
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
        int dano = 20;
        int critico = calcularCritico();
        int alvoElemento = elementos.get(oponente.gettipo());
        int escolhidoElemento = elementos.get(meuPokemon.gettipo());
        int diferenca = (alvoElemento - escolhidoElemento + 5) % 5;
        if(diferenca == 1){
          dano = dano + 10;
        } else if ( diferenca == 4){
          dano = dano - 10;
        }
        dano = atualizarDano(dano, critico);
        return dano;
      }
    

      public void realizarAtaque(Pokemon atacante, Pokemon defensor){
        atacante.atacar();
        int dano = calcularDano(atacante, defensor);
        if(foiCritico){
          System.out.printf("%s causou %d de crítico no oponente %s%n", atacante.getnome(), dano, defensor.getnome());
        }
        defensor.receberDano(dano);
        System.out.printf("O dano do %s foi de %d%n", atacante.getnome(), dano);
      
      }
      //poseidon escolhido
      //raiva alvo

      //MOSTRAR HP A CADA ROUND
      
    public void batalhar(){
      System.out.println("=".repeat(30));
      System.out.println(cor.getAmarelo() + cor.getNegrito() + "=== BATALHA POKÉMON ===" + cor.getReset());
      System.out.println("=".repeat(30));
      System.out.println(cor.getVerde() + "Escolhido:"+  cor.getReset() + escolhido.getnome());
      System.out.println(cor.getRoxo() + "Oponente:"+  cor.getReset() + alvo.getnome());

      boolean capturou = false;
      while (alvo.gethp() > 0 && escolhido.gethp() > 0){
        realizarAtaque(escolhido, alvo);
        if (alvo.gethp() > 0){
          realizarAtaque(alvo, escolhido);
          System.out.printf("HP do %s %d | HP do %s: %d%n", escolhido.getnome(), escolhido.gethp(), alvo.getnome(), alvo.gethp());
          
          System.out.println("O que você deseja fazer?");
          System.out.println("1 - Atacar");
          System.out.println("2 - Capturar");

          int opcao = scanner.nextInt();
            if (opcao == 1){
              System.out.println(cor.getAmarelo() + "PRÓXIMO ROUND" + cor.getReset());
              System.out.println(cor.getCinza() + "=".repeat(30));
            } else if (opcao == 2){
              System.out.println("Você tentou capturar o Pokémon!");
              capturou = true;
              break;
            }
        }
      }
        if (!capturou){
          if (escolhido.gethp() > 0){
            System.out.printf("O pokemon %s foi o vencedor, então você %sganhou%s a batalha, Parabéns", escolhido.getnome(), cor.getVerde(), cor.getReset());
          }else{
            System.out.printf("O pokemon %s foi o vencedor, então você %sperdeu%s a batalha. Boa sorte na próxima", alvo.getnome(), cor.getVermelho(), cor.getReset());
          }
        }
      }
    }



