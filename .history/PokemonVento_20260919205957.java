public class PokemonVento extends Pokemon{
    public PokemonAr (String nome, int nivel, int hp, int ataquebase ){
        super(nome,"Ar",nivel,hp,ataquebase);
    }
    @Override
    public void atacar(){
        System.out.println(getnome() + " lançou um furacão");
    }

    
}
