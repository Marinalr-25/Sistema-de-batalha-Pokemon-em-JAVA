public class PokemonTerra extends Pokemon{
    public PokemonTerra(String nome, int nivel, int hp, int ataquebase ){
        super(nome,"Terra",nivel,hp,ataquebase);
    }
    @Override
    public void atacar(){
        System.out.println(getnome() + " lançou um terremoto");
    }


    
}
