public class Batalha {
    Pokemon alvo;
    Pokemon escolhido;

    public Batalha(Pokemon  alvo, Pokemon escolhido){
        this.alvo = alvo;
        this.escolhido = escolhido;
    }
    public void batalhar(){
        System.out.println("Estou na batalha");

        escolhido.atacar();
        alvo.atacar();
    }
}

