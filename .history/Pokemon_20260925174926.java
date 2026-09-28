public class Pokemon{
    //Um atributo private só pode ser acessado diretamente dentro da própria classe.
    //---------------------
    // "por que nivel é protected?" porque as subclasses precisam acessar diretamente o nível herdado durante subirNivel()
    
    //Atributos da classe Pokemon
    private String nome;
    private String tipo;
    protected int nivel;
    private int hp;
    private  int hpInicial;
    private int ataquebase;
    private int speed;
    
    
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getTipo(){
        return tipo;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public int getNivel(){
        return nivel;
    }
    public void setNivel(int nivel){
      if (nivel > 0){
        this.nivel = nivel;
      } else{
        System.out.println("Erro: o nível deve ser maior que 0.\n Nível definido: Nível 1");
        this.nivel = 1;
      }
    }
    public int getHpInicial(){
        return hpInicial;
    }
    public int getHp(){
        return hp;
    }
    public void setHp(int hp){
      if (hp >= 0){
        this.hp = hp;
      } else{
        this.hp = 100;
      }
    }
    public int getAtaquebase(){
        return ataquebase;
    }
    public void setAtaquebase(int ataquebase){
      if(ataquebase > 0 ){
        this.ataquebase = ataquebase;
      }
    }
    public int getSpeed(){
        return speed;
    }
    public void setSpeed(int speed){
        if(speed > 0 ){
        this.speed = speed;
      }
    }

    //PokemonAgua poseidon= new PokemonAgua("Poseidon",1,135,15);
    public Pokemon(String nome, String tipo, int nivel, int hpInicial, int ataquebase, int speed){
        this.nome = nome;
        this.tipo = tipo;
        setNivel(nivel);
        setHp(hpInicial);
        setAtaquebase(ataquebase);
        setSpeed(speed);
        this.hpInicial = this.hp;
    }
    
    @Override
    public String toString() {
        return "nome: " + nome + " | Tipo: " + tipo + " | Nível: " + nivel  +  " | HP: " + hp + " | Ataque Base " + ataquebase + " | Speed: " + speed;
    }
    void atacar(){
    }

    void receberDano(int dano){
      int novoHp = hp - dano;
      if (novoHp < 0){
        novoHp = 0;
      }
      setHp(novoHp);
    }

    void subirNivel(){
      nivel++;
    }
    void aumentarAtaque(int valor){
      ataquebase += valor;
    }
    void aumentarHP(int valor){
      hpInicial += valor;
      hp = hpInicial;
    }
    void aumentarSpeed(int valor){
      speed += valor;
    }
}
