public class PokemonAgua extends Pokemon {
    public PokemonAgua(String nome,String tipo, int nivel, int hp, int ataquebase ){
        super(nome,tipo,nivel,hp,ataquebase);
    }
    @Override
    public void atacar(){
        System.out.println("\033[35m" + getnome() + "\033[0m   lançou um tsunami!");
    }


}