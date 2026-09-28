public class PokemonVento extends Pokemon{
    public PokemonVento (String nome,String tipo, int nivel, int hp, int ataquebase ){
        super(nome,tipo,nivel,hp,ataquebase);
    }
    @Override
    public void atacar(){
        System.out.println(getnome() + " lançou um furacão");
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
