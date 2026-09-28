public class PokemonFogo extends Pokemon {
  Cores cor = new Cores();
    public PokemonFogo(String nome, int nivel, int hp, int ataquebase ){
        super(nome,"Fogo",nivel,hp,ataquebase);
    }
    @Override
    public void atacar(){
        System.out.printf("%s%s%s lançou uma bola de fogo", cor.getVermelho(), getnome(), cor.getReset());
    }
}
