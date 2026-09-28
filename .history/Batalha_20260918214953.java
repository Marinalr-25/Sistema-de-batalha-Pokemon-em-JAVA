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

    public int atualizarDano(int dano, int critico){
      if (critico <= 20){
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
    int critico = calcularCritico();
    int alvoElemento = elementos.get(alvo.gettipo());
    int escolhidoElemento = elementos.get(escolhido.gettipo());
    int diferenca = (alvoElemento - escolhidoElemento + 5) % 5;
    System.out.println("alvoElemento: " + alvoElemento);
    System.out.println("escolhidoElemento: " + escolhidoElemento);
    System.out.println("diferenca: " + diferenca);
    System.out.println("critico: " + critico);
    
    
    if(diferenca == 1){
        dano = dano + 10;
    } else if ( diferenca == 4){
      dano = dano - 10;
    }
    System.out.println("Dano: " + dano);
    dano = atualizarDano(dano, critico);
    System.out.println("dano final "+ dano);

        escolhido.atacar();
        alvo.receberDano(dano);
        System.out.println("HP depois do dano: " + alvo.gethp());
        if (alvo.estaDerrotado()){
          System.out.println("O pokemon foi derrotado");
          System.out.println("hp: " + alvo.gethp());
        } else{
          System.out.println("Continua a batalha");
          System.out.println("hp: " + alvo.gethp());
        }
      }
    }


