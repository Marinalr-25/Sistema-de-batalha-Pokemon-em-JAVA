public class Pokemon{
    //Um atributo private só pode ser acessado diretamente dentro da própria classe.
    //---------------------

    //private
    //    ↓
    // somente a própria classe
    //---------------------
    // protected
    //    ↓
    // própria classe + subclasses
    //---------------------
    // public
    //    ↓
    // qualquer classe
    //---------------------
    
    private String nome;
    private String tipo;
    private int nivel;
    private int hp;
    private  int hpInicial;
    protected int ataquebase;
    private int speed;
    
    public String getnome(){
        return nome;
    }
    public void setnome(String nome){
        this.nome = nome;
    }
    public String gettipo(){
        return tipo;
    }
    public void settipo(String tipo){
        this.tipo = tipo;
    }
    public int getnivel(){
        return nivel;
    }
    public void setnivel(int nivel){
      if (nivel > 0){
        this.nivel = nivel;
      }
    }
    public int gethpInicial(){
        return hpInicial;
    }
    public int gethp(){
        return hp;
    }
    public void sethp(int hp){
      if (hp >= 0){
        this.hp = hp;
      }
    }
    public int getataquebase(){
        return ataquebase;
    }
    public void setataquebase(int ataquebase){
      if(ataquebase > 0 ){
        this.ataquebase = ataquebase;
      }
    }
    public int getspeed(){
        return speed;
    }
    public void setspeed(int speed){
        if(speed > 0 ){
        this.ataquebase = speed;
      }
    }

    //PokemonAgua poseidon= new PokemonAgua("Poseidon",1,135,15);
    public Pokemon(String nome, String tipo, int nivel, int hpInicial, int ataquebase, int speed){
        this.nome = nome;
        this.tipo = tipo;
        this.nivel = nivel;
        this.hpInicial = hpInicial;
        this.hp = hpInicial;
        this.ataquebase = ataquebase;
        this.speed = speed;
    }
    
    @Override
    public String toString() {
        return "nome: " + nome + " | Tipo: " + tipo + " | Nível: " + nivel  +  " | HP: " + hp + " | Ataque Base " + ataquebase + " | Speed: " + speed;
    }
    void atacar(){
    }
    // void defender(){
    // }

    void receberDano(int dano){
      int novoHp = hp - dano;
      if (novoHp < 0){
        novoHp = 0;
      }
      sethp(novoHp);
    }
    void subirNivel(){
      nivel++;
    }
}
