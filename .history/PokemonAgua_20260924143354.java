public class PokemonAgua extends Pokemon {
  Cores cor = new Cores();
    public PokemonAgua(String nome, int nivel, int hp, int ataquebase, int speed ){
        super(nome,"Agua", nivel,hp,ataquebase, speed);
    }

    
    @Override
    public void atacar(){
        if (ataquebase >= 20) {
          System.out.printf("%s%s%s disparou uma onda gigantesca!%n", cor.getAzul(), getnome(), cor.getReset());
        } else {
            System.out.printf("%s%s%s disparou uma onda!%n", cor.getAzul(), getnome(), cor.getReset());
        }
    }
}