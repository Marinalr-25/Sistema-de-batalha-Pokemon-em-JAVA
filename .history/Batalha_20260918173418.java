import java.util.Map;

public class Batalha {
    Pokemon alvo;
    Pokemon escolhido;

    public Batalha(Pokemon alvo, Pokemon escolhido){
        this.alvo = alvo;
        this.escolhido = escolhido;
    }
    int alvoElemento = elementos.get(alvo.gettipo());
    int escolhidoElemento = elementos.get(escolhido.gettipo());

    //ataquebase +10 ou -10
    public void batalhar(){
        System.out.println("Estou na batalha");
        int dano = escolhido.getataquebase(); //20
        System.out.println(dano);

        Map<String, Integer> elementos = Map.of(
        "Agua", 1,
        "Fogo", 2,
        "Vento", 3,
        "Terra", 4,
        "Eletrico", 5
    );

        int diferenca = ( alvo.gettipo() - escolhido.gettipo() + 5) % 5;
        System.out.println(diferenca);

      

        
        escolhido.atacar();
        alvo.defender();
    }
}

