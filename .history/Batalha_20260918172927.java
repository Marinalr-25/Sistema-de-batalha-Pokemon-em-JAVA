public class Batalha {
    Pokemon alvo;
    Pokemon escolhido;

    public Batalha(Pokemon  alvo, Pokemon escolhido){
        this.alvo = alvo;
        this.escolhido = escolhido;
    }


    //ataquebase +10 ou -10
    public void batalhar(){
        System.out.println("Estou na batalha");
        int dano = escolhido.getataquebase(); //20
        System.out.println(dano);

        int diferenca = (alvo.gettipo() - escolhido.gettipo() + 5) % 5

        if (escolhido.gettipo() )

        
        escolhido.atacar();
        alvo.defender();
    }
}

