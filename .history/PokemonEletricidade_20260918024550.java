public class PokemonEletricidade extends Pokemon{
    public PokemonEletricidade(String nome,String tipo, int nivel, int hp, int ataquebase ){
        super(nome,tipo,nivel,hp,ataquebase);
    }
    @Override
    public void atacar(){
        System.out.println(getnome() + " lançou uma rajada de choque!");
    }
     @Override 
    public void defender(){
        System.out.println(getnome()+" se defendeu");
    }
    @Override 
    public void dormir(){
        System.out.println(getnome()+" foi dormir");
    }
    
    
}
