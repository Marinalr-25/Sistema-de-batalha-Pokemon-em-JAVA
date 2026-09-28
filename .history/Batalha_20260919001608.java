import java.util.Map;
import java.util.Random;

public class Batalha {
    Pokemon escolhido;
    Pokemon alvo;
    

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
      if (critico <= 20){
        dano = dano * 2;
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
    

    public void batalhar(){
      System.out.println("\\033[36m COMEÇANDO A BATALHA\\033[0m");
      System.out.println("Escolhido: " + escolhido.getnome());
      System.out.println("Alvo: " + alvo.getnome());
      while (alvo.gethp() > 0 && escolhido.gethp() > 0){
        int dano = calcularDano(escolhido, alvo);
        escolhido.atacar();
        calcularDano(escolhido, alvo);
        alvo.receberDano(dano);

        System.out.printf("dano do %s foi de %d%n", escolhido.getnome(), dano);
        System.out.printf("hp do %s: %d%n", alvo.getnome(), alvo.gethp());
        if (alvo.gethp() > 0){
          alvo.atacar();
          dano = calcularDano(alvo, escolhido);
          escolhido.receberDano(dano);
          System.out.printf("dano do %s foi de %d%n", alvo.getnome(), dano);
          System.out.printf("hp do %s: %d%n", escolhido.getnome(), escolhido.gethp());
          System.out.println("\033[35m mais um round\033[0m");
          }
        }
      }
    }
    

