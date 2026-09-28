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
        public void ataqueTornado() {
        System.out.printf(
            "%s%s finalizou o oponente com Tornado final!%s%n",
            cor.getVermelho(),
            getnome(),
            cor.getReset()
        );
      } 

    
}
