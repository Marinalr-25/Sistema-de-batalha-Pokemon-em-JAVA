public class PokemonAr extends Pokemon{
  Cores cor = new Cores();
    public PokemonAr (String nome, int nivel, int hp, int ataquebase, int speed ){
        super(nome,"Ar",nivel,hp,ataquebase, speed);
    }

    @Override
    public void atacar(){
        if (ataquebase >= 20) {
          System.out.printf("%s%s%s criou um poderoso ciclone!%n", cor.getAzul(), getnome(), cor.getReset());
        } else {
            System.out.printf("%s%s%s lançou um pequeno redemoinho%n", cor.getAzul(), getnome(), cor.getReset());
        }
    }
}
