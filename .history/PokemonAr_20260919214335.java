public class PokemonAr extends Pokemon{
  Cores cor = new Cores();
    public PokemonAr (String nome, int nivel, int hp, int ataquebase ){
        super(nome,"Ar",nivel,hp,ataquebase);
    }
    @Override
    public void atacar(){
        System.out.printf("%s%s%s jogou um furacão", cor.getAzul(), getnome(), cor.getReset());
    }

    
}
