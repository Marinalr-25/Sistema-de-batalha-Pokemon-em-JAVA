public class PokemonTerra extends Pokemon{
  Cores cor = new Cores();
    public PokemonTerra(String nome, int nivel, int hp, int ataquebase, int speed ){
        super(nome,"Terra",nivel,hp,ataquebase, speed);
    }

    @Override
    public void atacar(){
        if (ataquebase >= 20) {
          System.out.printf("%s%s%s ergueu um terremoto devastador contra o inimigo!", cor.getAzul(), getnome(), cor.getReset());
        } else {
            System.out.printf("lançou pedras contra o inimigo!", cor.getAzul(), getnome(), cor.getReset());
        }
    }
}

