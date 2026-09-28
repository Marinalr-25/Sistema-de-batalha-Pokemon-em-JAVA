import java.util.Map;
import java.util.Random;

public class Batalha {
    Pokemon alvo;
    Pokemon escolhido;

    public Batalha(Pokemon escolhido, Pokemon alvo){
      this.alvo = alvo;
      this.escolhido = escolhido;
    }

    public int calcularCritico(){
      Random random = new Random();
      int numero = random.nextInt(101);
      return numero;
    }

    int critico = calcularCritico();


    public int atualizarDano(int dano, int critico){
      if (critico >= 20){
        dano = dano * 2;
      } 
      return dano;
    }
    
    public void batalhar(){
      Map<String, Integer> elementos = Map.of(
        "Agua", 1,
        "Fogo", 2,
        "Vento", 3,
        "Terra", 4,
        "Eletrico", 5
      );

    
    int dano = escolhido.getataquebase();

    int alvoElemento = elementos.get(alvo.gettipo());
    int escolhidoElemento = elementos.get(escolhido.gettipo());

    int diferenca = (alvoElemento - escolhidoElemento + 5) % 5;
    System.out.println("Diferenca linha 45 " + diferenca);
    
    if(diferenca == 1){
        dano = dano + 10;
    } else if ( diferenca == 4){
        dano = dano - 10;
      }

      System.out.println("dano linha 53 "+ dano);
      dano = atualizarDano(dano, critico);

        System.out.println("calcular critico linha 56 "+ calcularCritico());
        System.out.println("dano final linha 57 "+ dano);

        escolhido.atacar();
        alvo.defender();
      }
    }


