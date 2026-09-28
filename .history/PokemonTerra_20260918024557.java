public class PokemonTerra extends Pokemon{
    public PokemonTerra(String nome,String tipo, int nivel, int hp, int ataquebase ){
        super(nome,tipo,nivel,hp,ataquebase);
    }
    @Override
    public void atacar(){
        System.out.println(getnome() + " lançou uma rajada de agua");
    }
    @Override 
    public void defender(){
        System.out.println(getnome()+" lançou uma rajada de terremoto!");
    }
    @Override 
    public void dormir(){
        System.out.println(getnome()+" foi dormir");
    }
    
}
