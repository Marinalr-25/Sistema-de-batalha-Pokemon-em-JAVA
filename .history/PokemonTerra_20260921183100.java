public class PokemonTerra extends Pokemon{
  Cores cor = new Cores();
    public PokemonTerra(String nome, int nivel, int hp, int ataquebase ){
        super(nome,"Terra",nivel,hp,ataquebase);
    }
    @Override
    public void atacar(){
        System.out.printf("%s%s%s ergueu a terra contra o inimigo!%n", cor.getAzul(), getnome(), cor.getReset());
    }
    
}

