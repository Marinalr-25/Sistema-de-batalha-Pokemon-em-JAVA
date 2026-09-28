public class PokemonAgua extends Pokemon {
  Cores cor = new Cores();
    public PokemonAgua(String nome, int nivel, int hp, int ataquebase, int speed ){
        super(nome,"Agua", nivel,hp,ataquebase, speed);
    }

    
    @Override
    public void atacar(){
        System.out.printf("%s%s%s disparou uma onda gigantesca!%n", cor.getAzul(), getnome(), cor.getReset());
    }
}