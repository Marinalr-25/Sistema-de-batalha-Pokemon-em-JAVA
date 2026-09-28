public class PokemonEletricidade extends Pokemon{
    Cores cor = new Cores();
    public PokemonEletricidade(String nome, int nivel, int hp, int ataquebase, int speed ){
        super(nome,"Elétrico",nivel,hp,ataquebase, speed);
    }

    @Override
    public void atacar(){
        if (ataquebase >= 20) {
          System.out.printf("%s%s%s deu choque do trovão%n", cor.getAzul(), getnome(), cor.getReset());
        } else {
            System.out.printf("%s%s%s deu choque do trovão%n", cor.getAzul(), getnome(), cor.getReset());
        }
    }

}
