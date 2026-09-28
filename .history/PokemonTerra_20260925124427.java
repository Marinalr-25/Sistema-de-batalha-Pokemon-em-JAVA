public class PokemonTerra extends Pokemon{
  Cores cor = new Cores();
    public PokemonTerra(String nome, int nivel, int hp, int ataquebase, int speed ){
        super(nome,"Terra",nivel,hp,ataquebase, speed);
    }
    @Override
    public void atacar(){
        System.out.printf("%s%s%s ergueu a terra contra o inimigo!%n", cor.getRosa(), getNome(), cor.getReset());
    }
        //instaceof + downcasting
        public void ataqueFuriaDaTerra() {
        System.out.printf(
            "%s%s finalizou o oponente com Fúria da Terra!%s%n",
            cor.getVermelho(),
            getNome(),
            cor.getReset()
        );
      } 
    
    @Override 
    public void subirNivel(){
      super.subirNivel();
      this.aumentarSpeed(5);
      this.aumentarHP(5);
      System.out.printf("%s%s subiu de nível!%S Nível: %d | HP: %d | Speed: %s%n", cor.getVerde(), getNome(), cor.getReset(), getNivel(), getHp(), getSpeed());
      }
}

