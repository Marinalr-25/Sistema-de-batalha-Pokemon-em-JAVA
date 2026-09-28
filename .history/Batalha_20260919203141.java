import java.util.Map;
import java.util.Random;

// poseidon → é o argumento passado ao construtor.
// escolhido → é o atributo da Batalha que guarda o Poseidon.
// atacante → é o parâmetro de realizarAtaque que recebe o valor de escolhido.

public class Batalha {
    Pokemon escolhido;
    Pokemon alvo;
    Boolean foiCritico;
    

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
        "Vento", 3,
        "Terra", 4,
        "Eletrico", 5
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
        System.out.printf("dano do %s foi de %d%n", atacante.getnome(), dano);
        System.out.printf("hp do %s: %d%n", defensor.getnome(), defensor.gethp());
      }
      //poseidon escolhido
      //raiva alvo
      
    public void batalhar(){
      System.out.println("=".repeat(30));
      System.out.println("\033[1m\033[93m=== BATALHA POKÉMON ===\033[0m");
      System.out.println("=".repeat(30));
      System.out.println("\033[32mEscolhido:\033[0m " + escolhido.getnome());
      System.out.println("\033[31mAlvo:\033[0m " + alvo.getnome());
      while (alvo.gethp() > 0 && escolhido.gethp() > 0){
        realizarAtaque(escolhido, alvo);
        if (alvo.gethp() > 0){
          realizarAtaque(alvo, escolhido);
          System.out.println("\033[35m PRÓXIMO ROUND\033[0m");
        }
      }
        if (escolhido.gethp() > 0){
          System.out.printf("O pokemon %s foi o vencedor, então você \033[32mganhou\033[0m a batalha, Parabéns", escolhido.getnome());
        }else{
          System.out.printf("O pokemon %s foi o vencedor, então você \033[31mperdeu\033[0m a batalha. Boa sorte na próxima", alvo.getnome());
        }
      }
    }



