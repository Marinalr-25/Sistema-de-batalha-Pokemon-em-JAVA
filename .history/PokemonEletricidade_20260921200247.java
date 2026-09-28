public class PokemonEletricidade extends Pokemon{
    Cores cor = new Cores();
    public PokemonEletricidade(String nome, int nivel, int hp, int ataquebase, int speed ){
        super(nome,"Elétrico",nivel,hp,ataquebase, speed);
    }
    @Override
    public void atacar(){
        System.out.printf("%s%s%s deu choque do trovão%n", cor.getAmarelo(), getnome(), cor.getReset());
    }

}
