import java.util.Map;

public class Batalha {
    Pokemon alvo;
    Pokemon escolhido;

    public Batalha(Pokemon alvo, Pokemon escolhido){
        this.alvo = alvo;
        this.escolhido = escolhido;
    }

    

    //ataquebase +10 ou -10
    public void batalhar(){
      System.out.println("Estou na batalha");
      escolhido.atacar();
      alvo.defender();
      int dano = escolhido.getataquebase(); //20
      System.out.println("Dano base: " + dano);

      Map<String, Integer> elementos = Map.of(
      "Agua", 1,
      "Fogo", 2,
      "Vento", 3,
      "Terra", 4,
      "Eletrico", 5
      );
      int alvoElemento = elementos.get(alvo.gettipo());
      int escolhidoElemento = elementos.get(escolhido.gettipo());
      int diferenca = (alvoElemento - escolhidoElemento + 5) % 5;
      System.out.println("diferenca" + diferenca);
      
      if(diferenca == 1){
        dano = dano + 10;
        System.out.println("diferenca" + diferenca);
        System.out.println("dano" + dano);
      } else if ( diferenca == 4){
        dano = dano - 10;
        System.out.println("diferenca" + diferenca);
        System.out.println("dano" + dano);
      }

        
        // escolhido.atacar();
        // alvo.defender();
    }
}

