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
        boolean foiCritico = true;
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
    

      // public void realizarAtaque(Pokemon atacante, Pokemon defensor){

      // }
      //poseidon escolhido
      //raiva alvo
    public void batalhar(){
      System.out.println("=".repeat(30));
      System.out.println("\033[33m COMEÇANDO A BATALHA\033[0m");
      System.out.println("=".repeat(30));
      System.out.println("\033[32mEscolhido:\033[0m " + escolhido.getnome());
      System.out.println("\033[31mAlvo:\033[0m " + alvo.getnome());
      while (alvo.gethp() > 0 && escolhido.gethp() > 0){
        int dano = calcularDano(escolhido, alvo);
        escolhido.atacar();
        alvo.receberDano(dano);
        //System.out.printf("%s causou %d de crítico no oponente %s%n", escolhido.getnome(), dano, alvo.getnome());
        
        System.out.printf("dano do %s foi de %d%n", escolhido.getnome(), dano);
        System.out.printf("hp do %s: %d%n", alvo.getnome(), alvo.gethp());
        if (alvo.gethp() > 0){
          alvo.atacar();
          dano = calcularDano(alvo, escolhido);
          escolhido.receberDano(dano);
          
          System.out.printf("dano do %s foi de %d%n", alvo.getnome(), dano);
          System.out.printf("hp do %s: %d%n", escolhido.getnome(), escolhido.gethp());
          System.out.println("\033[35m PRÓXIMO ROUND\033[0m");
        }
      }
        if (escolhido.gethp() > 0){
          System.out.printf("O pokemon %s foi o vencedor", escolhido.getnome());
        }else{
          System.out.printf("O pokemon %s foi o vencedor", alvo.getnome());
        }
      }
    }
    //definir um vencedor OK
    //informar quando for critico
    //opcao de batalhar novamente ou sair

