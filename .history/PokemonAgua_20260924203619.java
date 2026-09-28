public class PokemonAgua extends Pokemon {
  Cores cor = new Cores();
    public PokemonAgua(String nome, int nivel, int hp, int ataquebase, int speed ){
        super(nome,"Agua", nivel,hp,ataquebase, speed);
    }

    
    @Override
    public void atacar(){
        System.out.printf("%s%s%s disparou uma onda gigantesca!%n", cor.getAzul(), getnome(), cor.getReset());
    }
    //instaceof + downcasting
    public void ataqueMareDevastadora() {
    System.out.printf(
        "%s%s finalizou o oponente com Maré Devastadora!%s%n",
        cor.getVermelho(), getnome(),cor.getReset()
    );
  } 

  @Override 
  public void subirNivel(){
    super.subirNivel();
    this.aumentarAtaque(1);
    System.out.printf("Parabéns. %s subiu de nivel\n +1 Nível | +5 HP | +1 Ataque Base\n Nível: %d | HP: %d | Ataque Base: %d", getnome(), getnivel(), gethp(), getataquebase());

    
    }

}

//porque brasa é uma referência do tipo Pokemon, e Pokemon não possui ataqueChamas()
    //     Calcula o dano
    //       ↓
    // Dano mata o alvo?
    //    ↙       ↘
    //  NÃO       SIM
    //  ↓          ↓
    // atacar()   instanceof
    //             ↓
    //         downcasting
    //             ↓
    //        ataqueChamas()