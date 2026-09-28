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
        System.out.println(PokemonAgua.ataquebase());
        


        escolhido.atacar();
        alvo.defender();
    }
}

