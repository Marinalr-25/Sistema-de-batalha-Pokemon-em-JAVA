public class PokemonVento extends Pokemon{
    public PokemonVento (String nome, int nivel, int hp, int ataquebase ){
        super(nome,"Vento",nivel,hp,ataquebase);
    }
    @Override
    public void atacar(){
        System.out.println(getnome() + " lançou um furacão");
    }

    
}
