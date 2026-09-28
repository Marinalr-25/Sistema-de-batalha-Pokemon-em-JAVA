public class PokemonAgua extends Pokemon {
    public PokemonAgua(String nome,String tipo, int nivel, int hp, int ataquebase ){
        super(nome,tipo,nivel,hp,ataquebase);
    }
    @Override
    public void atacar(){
        System.out.println(getnome() + " lançou um tsunami!");
    }
    @Override 
    public void defender(){
        System.out.println(getnome()+" se defendeu");
    }

}