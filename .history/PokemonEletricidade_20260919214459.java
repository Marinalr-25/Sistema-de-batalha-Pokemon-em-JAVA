public class PokemonEletricidade extends Pokemon{
    Cores cor = new Cores();
    public PokemonEletricidade(String nome, int nivel, int hp, int ataquebase ){
        super(nome,"Elétrico",nivel,hp,ataquebase);
    }
    @Override
    public void atacar(){
        System.out.printf("%s%s%s deu choque do trovão", cor.getAmarelo(), getnome(), cor.getReset());
    }

}
