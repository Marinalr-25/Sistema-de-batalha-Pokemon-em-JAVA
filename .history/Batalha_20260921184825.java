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
    Random random = new Random();
    

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
        int dano = 0;
        int critico = calcularCritico();
        int alvoElemento = elementos.get(oponente.gettipo());
        int escolhidoElemento = elementos.get(meuPokemon.gettipo());
        int diferenca = (alvoElemento - escolhidoElemento + 5) % 5;
        // 1 = agua - fogo / fogo - vento / vento - terra / +10
        // 4 = fogo - agua / agua - eletricidade / eletricidade - terra / -10
        
        if(diferenca == 1){
          dano = (dano + (random.nextInt(21) + 10));
        } else if ( diferenca == 4){
          dano = dano + (random.nextInt(21) + 20);
        } else{
          dano = dano + (random.nextInt(21) + 15);
        }
        dano = atualizarDano(dano, critico);
        return dano;
      }

      //o dano nao ser um valor fixo, e sim aleatorio entre um padrao [20-40] para dar possibilidade do pokemon counterado de ganhar. Então um ataque que normalmente seria 25 poderia virar 50, por exemplo. Tornar a batalha DIFICIL mas nao IMPOSSIVEL
    

      public void realizarAtaque(Pokemon atacante, Pokemon defensor){
        atacante.atacar();
        int dano = calcularDano(atacante, defensor);
        System.out.println("Dano para ver o numero" + dano);
        if(foiCritico){
          System.out.printf("%s causou %d de %scrítico%s no oponente %s%n", atacante.getnome(), dano, cor.getRoxo(), cor.getReset(), defensor.getnome());
        }
        defensor.receberDano(dano);
        System.out.printf("O dano do %s foi de %d%n", atacante.getnome(), dano);
      }
      
    public void batalhar(){
      System.out.println("=".repeat(30));
      System.out.println(cor.getAmarelo() + cor.getNegrito() + "=== BATALHA POKÉMON ===" + cor.getReset());
      System.out.println("=".repeat(30));
      System.out.println(cor.getVerde() + "Escolhido:"+  cor.getReset() + escolhido.getnome());
      System.out.println(cor.getRoxo() + "Oponente:"+  cor.getReset() + alvo.getnome());

      boolean capturou = false;
      while (alvo.gethp() > 0 && escolhido.gethp() > 0){
        realizarAtaque(escolhido, alvo);
        if (alvo.gethp() <=0){
          break;
        }
        realizarAtaque(alvo, escolhido);
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
                System.out.println("Você tentou capturar o Pokémon!");
                capturou = true;
                break;
              } 
        }
      }
        if (!capturou){
          if (escolhido.gethp() > 0){
            System.out.printf("O pokemon %s foi o vencedor, então você %sganhou%s a batalha, Parabéns%n",  escolhido.getnome(),  cor.getVerde(), cor.getReset());
            
          }else{
            System.out.printf("O %s%s%s foi o vencedor, então você %sperdeu%s a batalha. Boa sorte na próxima%n", cor.getGanhdor(), alvo.getnome(), cor.getReset(), cor.getVermelho(), cor.getReset());

          }
        }
      }
    }



