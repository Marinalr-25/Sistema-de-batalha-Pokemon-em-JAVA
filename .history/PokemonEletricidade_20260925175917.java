public class PokemonEletricidade extends Pokemon{
    Cores cor = new Cores();
    public PokemonEletricidade(String nome, int nivel, int hp, int ataquebase, int speed ){
        super(nome,"Elétrico",nivel,hp,ataquebase, speed);
    }
    @Override
    public void atacar(){
        System.out.printf("%s%s%s deu choque do trovão%n", cor.getAmarelo(), getNome(), cor.getReset());
    }

        public void ataqueTempestadeEletrica() {
        System.out.printf(
            "%s%s finalizou o oponente com Tempestade Elétrica!%s%n",
            cor.getVermelho(),
            getNome(),
            cor.getReset()
        );
      } 

    //metodo para subir de nivel. Definido um padrao para cada elemento
    @Override 
    public void subirNivel(){
      super.subirNivel();
      this.aumentarSpeed(5);
      this.aumentarAtaque(2);
      System.out.printf("%s%s subiu de nível!%s%n Nível: %d | Ataque Base: %d | Speed: %s%n", cor.getVerde(), getNome(), cor.getReset(), getNivel(), getAtaquebase(), getSpeed());
      }
    

}
