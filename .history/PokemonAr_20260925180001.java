public class PokemonAr extends Pokemon{
  Cores cor = new Cores();
    public PokemonAr (String nome, int nivel, int hp, int ataquebase, int speed ){
        super(nome,"Ar",nivel,hp,ataquebase, speed);
    }
    //metodo herdado da classe mae, mas possui comportamentos diferentes para cada classe
    @Override
    public void atacar(){
        System.out.printf("%s%s%s criou um poderoso ciclone!%n", cor.getRoxo(), getNome(), cor.getReset());
    }
        //instaceof + downcasting -> só pode acessar se o Pokemon for do tipo Agua
        public void ataqueTornadoSupremo() {
        System.out.printf(
            "%s%s finalizou o oponente com Tornado Supremo!%s%n",
            cor.getVermelho(),
            getNome(),
            cor.getReset()
        );
      } 

    //metodo para subir de nivel. Definido um padrao para cada elemento
    @Override 
    public void subirNivel(){
      super.subirNivel();
      this.aumentarSpeed(20);
      System.out.printf("%s%s subiu de nível!%s%n Nível: %d | Speed: %d%n", cor.getVerde(), getNome(), cor.getReset(), getNivel(),  getSpeed());
      }
}
