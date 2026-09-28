public class PokemonTerra extends Pokemon{
  Cores cor = new Cores();
    public PokemonTerra(String nome, int nivel, int hp, int ataquebase, int speed ){
        super(nome,"Terra",nivel,hp,ataquebase, speed);
    }
    @Override
    public void atacar(){
        System.out.printf("%s%s%s ergueu a terra contra o inimigo!%n", cor.getRosa(), getnome(), cor.getReset());
    }
        //instaceof + downcasting
        public void ataqueTerra() {
        System.out.printf(
            "%s%s finalizou o oponente com Fúria da Terra!%s%n",
            cor.getVermelho(),
            getnome(),
            cor.getReset()
        );
      } 
    
}

