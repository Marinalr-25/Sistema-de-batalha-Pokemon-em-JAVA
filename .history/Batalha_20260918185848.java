import java.util.Map;
import java.util.Random;

public class Batalha {
    Pokemon alvo;
    Pokemon escolhido;

    public Batalha(Pokemon alvo, Pokemon escolhido){
        this.alvo = alvo;
        this.escolhido = escolhido;
    }

    public int calcularCritico(){
        return 80;
      }

    //ataquebase +10 ou -10
    public void batalhar(){
      System.out.println("Estou na batalha");
      Map<String, Integer> elementos = Map.of(
        "Agua", 1,
        "Fogo", 2,
        "Vento", 3,
        "Terra", 4,
        "Eletrico", 5
      );
      
      double dano = escolhido.getataquebase(); //20
      int alvoElemento = elementos.get(alvo.gettipo());
      int escolhidoElemento = elementos.get(escolhido.gettipo());
      int diferenca = (alvoElemento - escolhidoElemento + 5) % 5;
      System.out.println("diferenca" + diferenca);
      
      // Random random = new Random();
      // int numero = random.nextInt(101);
      // System.out.println("numero aleatorio"+ numero);
      // int critico = 2;

      // if (numero <= 80){
      //   dano = dano * critico;
      // }
      
      if(diferenca == 1){
        dano = dano + 10;
      } else if ( diferenca == 4){
        dano = dano - 10;
      }else{
        if (calcularCritico() >= 20){
          double critico = 0.2;
          dano = dano * critico;
        }
        dano = dano * calcularCritico();
        System.out.println("calcular critico "+calcularCritico());
        System.out.println("dano "+ dano);
      
      }

      escolhido.atacar();
      alvo.defender();
        
        // escolhido.atacar();
        // alvo.defender();
    }
}

