# Nome do Projeto
Sistema de batalha Pokémon
## 📌 Sobre o projeto
O Pokémon Batalha é um sistema desenvolvido em Java que simula batalhas entre diferentes tipos de Pokémon. O projeto foi desenvolvido com o objetivo de aplicar conceitos de Programação Orientada a Objetos, como herança, polimorfismo, encapsulamento e sobrescrita de métodos.

## 🎯 Objetivo 
O objetivo do projeto é desenvolver um jogo de batalha Pokémon utilizando conceitos de Programação Orientada a Objetos. Durante o desenvolvimento foram aplicados conceitos como:
- Classes e objetos 
- Encapsulamento 
- Herança 
- Polimorfismo 
- Sobrescrita de métodos 
- Overload

## 🛠️ Tecnologias utilizadas
 - Java 
- JDK 21 
- VS Code

## 📂 Estrutura do projeto 
```text
pokemonBatalhaaa/ 
├── App.java 
├── Pokemon.java 
├── PokemonAgua.java 
├── PokemonFogo.java 
├── PokemonTerra.java 
├── PokemonAr.java 
├── PokemonEletrico.java 
├── Treinador.java 
├── Pokedex.java 
├── Batalha.java 
└── Cores.java
```

## ⚙️ Como executar
1. Clone o repositório.
2. Abra o projeto em uma IDE Java ou VS Code Studio.
3. Configure o JDK.
4. Execute javac *.java (Para compilar os arquivos)
5. Excute Java APP (Para inicializar o projeto/jogo)

## 🎮 Como utilizar
O jogador escolhe seu treinador e Pokémon, enfrenta Pokémon selvagens aleatórios, podendo atacar ou tentar capturá-los.
Em atacar, vai ser calculado o dano e subtraído do Hp do alvo. Quanto menos HP, mais chance de captura-lo.
Em capturar, é calculado a chance em base do Hp do alvo, se capturado, é adicionado a sua lista Pokedex, se o pokémon fugir, você terá uma nova chance de captura-lo em outra batalha.
Se ele vencer a batalha e matar o oponente, ele sobe de nível e pode tentar captura-lo em outra batalha.
Após qualquer batalha, pode batalhar novamente, consultar a Pokédex ou sair do jogo.

## 📋 Funcionalidades
* Escolha do treinador
* Visualização da Pokédex
* Captura de Pokémon
* Batalhas entre Pokémons
* Sistema de vantagem entre tipos
* Cálculo de dano
* Sistema de nível
* Sistema de velocidade
* Ataques específicos para cada tipo
* Evolução por nível
* Menu de interação no terminal

# 12 Requisitos POO

## 5 ou mais classes além da main
Classes adicionadas: Pokémon, Pokédex, Treinador, Batalha, PokemonAgua, PokemonFogo, PokemonTerra, PokemonAr, PokemonEletricidade

## Herança
A classe de Pokemons Elementos foi herdada da classe Pokemon, assim podendo ter acesso a atributos e métodos da classe mãe.

## 1 super + 2 subs
A superClasse é o Pokemon enquanto as subsClasses são os pokémons elementos. (PokemonAgua, PokemonFogo, PokemonTerra, PokemonAr, PokemonEletricidade)

## Private, get set, 2 validações
Usamos Private para quando queremos deixar que o atributo seja acessado apenas pela classe mãe e garantindo o encapsulamento. 
Para as subsClasses acessarem/modificarem é preciso utilizar o método get e set. Ex: Se você deseja pegar o nome do pokémon, é utilizado getNome(), e para alterar um valor setHp().
Também foi utilizado validações nos setters para impedir valores negativos em Hp, Nível, ataqueBase e Speed

## Protect + justificativa
O atributo nível foi definido como protected porque ele pertence à classe Pokémon, mas precisa ser acessado diretamente pelas subclasses durante o comportamento de evolução.
Na subclasse, utilizo nivel++ para aumentar o nível e depois aplico os bônus específicos daquele tipo de Pokémon.

## Override + for each: 
Overrride: Utilizado para acessar o método atacar(), porém cada pokémon tem seu estilo de ataque. Assim sobrescrevendo cada ataque dependendo do PokemonElemento.
For Each: Utilizado para percorrer a lista de Pokemon da Pokédex do Treinador para exibir o nome de cada ataque.

## Sobrecarga: 
Utilizado em calcular o dano do Pokémon que está atacando. 
Existem diferentes 2 versões do método calcularDano():
calcularDano(int dano) 
calcularDano(int dano, int critico)
Quando o ataque é crítico, é utilizada a versão que recebe os dois parâmetros. Caso contrário, é utilizada a versão que recebe apenas o dano.

## Intanceof + downcasting:
Utilizado para verificar se determinado pokémon pertence a uma classe específica e em seguida utilizado o downcasting para transformar aquele Pokemon em PokemonElemento para conseguir acessar um método que só a subclasse possui.
Ex: Quando o Pokemon for finalizar o alvo, ele verifica de de qual tipo é aquele Pokemon e após isso, acessa o método que só aquele Pokemon tem. 

## Tipos primitivos e String:
Utilizado String para definir nome e tipo dos Pokémons
Utilizado Int para definir Hp, Nível, Ataque Base e Speed do Pokémon
Utilizado Booleano no método batalhar, e retornar verdadeiro ou falso
O resultado da captura é utilizado para verificar se o Pokémon deve ser removido da lista de Pokémon selvagens e adicionado à Pokédex do treinador.

## Menu Scanner 4 ou mais opções:
- Escolher Treinador
- Acessar a Pokédex
- Iniciar uma batalha
- Escolher Pokémon que vai batalhar dependendo da quantidade de Pokémon que aquele treinador possui
- Atacar
- Capturar
- Sair

## nextInt/nextLine + Validação:
nextInt utilizado para ler ou capturar as opções do usuário digitado no terminal.
O nextLine() também é utilizado para realizar a leitura de textos.

## Compila e executa sem erros
O projeto é compilado utilizando o comando:
javac *.java
Após a compilação, o programa é executado com:
java App
Dessa forma, todos os arquivos .java são compilados e, em seguida, a classe App é executada como ponto de entrada do programa.

## Nomes PascalCase/camelCase
Utilizado PascalCase em nome das Classes (PokemonAgua, Treinador, Pokédex) e camelCase para métodos (atacar(), ataqueTempestadeEletrica(), pokemonSelvagem)


## 👩‍💻 Autores
* Marina Lopes Roberto 
* Eduardo Rabelo Necchio 
* Victor Toresin da Silva 

## 📄 Licença
Projeto desenvolvido para **fins acadêmicos** no curso de Engenharia de Software.
