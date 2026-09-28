public class PokemonTerra extends Pokemon{
    public PokemonTerra(String nome,String tipo, int nivel, int hp, int ataquebase ){
        super(nome,tipo,nivel,hp,ataquebase);
    }
    @Override
    public void atacar(){
        System.out.println(getnome() + " lançou um terremoto");
    }


    
}
