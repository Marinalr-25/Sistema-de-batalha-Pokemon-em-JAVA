public class PokemonAr extends Pokemon{
  Cores cor = new Cores();
    public PokemonAr (String nome, int nivel, int hp, int ataquebase, int speed ){
        super(nome,"Ar",nivel,hp,ataquebase, speed);
    }
    @Override
    public void atacar(){
        System.out.printf("%s%s%s criou um poderoso ciclone!%n", cor.getRoxo(), getnome(), cor.getReset());
    }
        //instaceof + downcasting
        public void ataqueTornadoSupremo() {
        System.out.printf(
            "%s%s finalizou o oponente com Tornado Supremo!%s%n",
            cor.getVermelho(),
            getnome(),
            cor.getReset()
        );
      } 

    @Override 
    public void subirNivel(){
      super.subirNivel();
      this.aumentarSpeed(20);
      System.out.printf("%s%s subiu de nível!%S Nível: %d | Ataque Base: %d%n", cor.getVerde(), getnome(), cor.getReset(), getnivel(), gethp(), getataquebase());
      }
}
