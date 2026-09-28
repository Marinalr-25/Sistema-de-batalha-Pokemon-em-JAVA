public class PokemonAgua extends Pokemon {
  Cores cor = new Cores();
    public PokemonAgua(String nome, int nivel, int hp, int ataquebase ){
        super(nome,"Agua", nivel,hp,ataquebase);
    }
    @Override
    public void atacar(){
        System.out.printf("%s%s%s lançou um tsunami!", cor.getRoxo(), getnome(), cor.getReset());
    }
}