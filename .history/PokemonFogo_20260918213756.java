public class PokemonFogo extends Pokemon {
    public PokemonFogo(String nome,String tipo, int nivel, int hp, int ataquebase ){
        super(nome,tipo,nivel,hp,ataquebase);
    }
    @Override
    public void atacar(){
        System.out.println(getnome() + " lançou uma bola de fogo");
    }
    @Override 
    public void defender(){
        System.out.println(getnome()+" defendeu do ataque do oponente");
    }
    
}
