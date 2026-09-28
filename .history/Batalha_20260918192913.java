import java.util.Map;
// import java.util.Random;

public class Batalha {
    Pokemon alvo;
    Pokemon escolhido;

    public Batalha(Pokemon alvo, Pokemon escolhido){
        this.alvo = alvo;
        this.escolhido = escolhido;
    }

    int dano = escolhido.getataquebase();

    int alvoElemento = elementos.get(alvo.gettipo());
    int escolhidoElemento = elementos.get(escolhido.gettipo());
    int diferenca = (alvoElemento - escolhidoElemento + 5) % 5;
    System.out.println("diferenca" + diferenca);

    public int calcularCritico(){
        return 80;
      }
    public int atualizarDano(int dano){
        if (calcularCritico() >= 20){
          dano = dano * 2;
        } 
        return dano;
      }

      if(diferenca == 1){
        dano = dano + 10;
      } else if ( diferenca == 4){
        dano = dano - 10;
      }
      dano = dano * atualizarDano(dano);
        
        System.out.println("calcular critico "+calcularCritico());
        System.out.println("dano "+ dano);
      
      }

    //ataquebase +10 ou -10
    
      
       //20
      
      
      // Random random = new Random();
      // int numero = random.nextInt(101);
      // System.out.println("numero aleatorio"+ numero);
      // int critico = 2;

      // if (numero <= 80){
      //   dano = dano * critico;
      // }
      
      
      escolhido.atacar();
      alvo.defender();
        
        // escolhido.atacar();
        // alvo.defender();
    }
}

