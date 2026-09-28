public class PokemonFogo extends Pokemon {
    public PokemonFogo(String nome, int nivel, int hp, int ataquebase ){
        super(nome,"Fogo",nivel,hp,ataquebase);
    }
    @Override
    public void atacar(){
        System.out.println("\033[31m" + getnome() + "\033[0m  lançou uma bola de fogo");
    }
}
