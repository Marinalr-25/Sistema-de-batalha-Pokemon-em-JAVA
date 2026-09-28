public class PokemonAgua extends Pokemon {
  Cores cor = new Cores();
    //construtor da classe pokemonAgua
    public PokemonAgua(String nome, int nivel, int hp, int ataquebase, int speed ){
      //Tipo já é definido para nao correr o risco de criar um pokemonAgua do tipo Fogo
        super(nome,"Agua", nivel,hp,ataquebase, speed);
    }

    //metodo herdado da classe mae, mas possui comportamentos diferentes para cada classe
    @Override
    public void atacar(){
        System.out.printf("%s%s%s disparou uma onda gigantesca!%n", cor.getAzul(), getNome(), cor.getReset());
    }
    //instaceof + downcasting -> só pode acessar se o Pokemon for do tipo Agua
    public void ataqueMareDevastadora() {
    System.out.printf(
        "%s%s finalizou o oponente com Maré Devastadora!%s%n",
        cor.getVermelho(), getNome(),cor.getReset()
    );
  } 

  //metodo para subir de nivel. Definido um padrao para cada elemento
  @Override 
  public void subirNivel(){
    //classes herdadas da classe mae
    super.subirNivel();
    this.aumentarAtaque(2);
    this.aumentarHP(5);
    System.out.printf("%s%s subiu de nível!%s%n Nível: %d | HP: %d | Ataque Base: %d%n", cor.getVerde(), getNome(), cor.getReset(), nivel, getHp(), getAtaquebase());
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