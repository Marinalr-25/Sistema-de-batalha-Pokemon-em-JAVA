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
      System.out.println("numero aleatorio"+ numero);
      return numero;
    }
    public int atualizarDano(int dano){
      if (calcularCritico() >= 20){
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
    System.out.println("Diferenca" + diferenca);
    
    if(diferenca == 1){
        dano = dano + 10;
    } else if ( diferenca == 4){
        dano = dano - 10;
      }

      System.out.println("dano"+ dano);
      dano = atualizarDano(dano);

        System.out.println("calcular critico "+ calcularCritico());
        System.out.println("dano final "+ dano);
        escolhido.atacar();
        alvo.defender();
      }
    }


