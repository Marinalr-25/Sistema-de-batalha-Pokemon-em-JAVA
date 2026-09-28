public class PokemonEletricidade extends Pokemon{
    Cores cor = new Cores();
    public PokemonEletricidade(String nome, int nivel, int hp, int ataquebase, int speed ){
        super(nome,"Elétrico",nivel,hp,ataquebase, speed);
    }
    @Override
    public void atacar(){
        System.out.printf("%s%s%s deu choque do trovão%n", cor.getAmarelo(), getnome(), cor.getReset());
    }

        public void ataqueTempestadeEletrica() {
        System.out.printf(
            "%s%s finalizou o oponente com Tempestade Elétrica!%s%n",
            cor.getVermelho(),
            getnome(),
            cor.getReset()
        );
      } 

    @Override 
    public void subirNivel(){
      super.subirNivel();
      this.aumentarSpeed(10);
      this.aumentarAtaque(2);
      System.out.printf("%s%s subiu de nível!%S Nível: %d | Ataque Base: %d | Speed: %s%n", cor.getVerde(), getnome(), cor.getReset(), getnivel(), gethp(), getspeed());
      }
    

}
