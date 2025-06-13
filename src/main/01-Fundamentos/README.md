# 📘 Módulo 1 – Fundamentos do Java

## 🎯 Objetivo

Apresentar os **conceitos essenciais da linguagem Java** que todo desenvolvedor precisa saber antes de avançar para arquitetura, boas práticas ou frameworks.

---

## 🧱 Estrutura básica de um programa Java

Um programa Java começa com uma classe pública que contém um método `main`, que é o ponto de entrada da aplicação. Toda execução se inicia por esse método.

---

## 🔢 Tipos de variáveis

Java possui tipos primitivos como `int`, `double`, `boolean`, além de tipos por referência como `String`. Variáveis armazenam dados que podem ser utilizados no decorrer do programa.

---

## 🧠 Tipagem por objeto

Em Java, além dos tipos primitivos, também podemos utilizar tipos por objeto (referência), como `Integer`, `Double`, `Boolean`, e qualquer classe criada pelo desenvolvedor.

Esses tipos são úteis quando precisamos:
- Trabalhar com valores nulos (ex: ao buscar dados de um banco de dados);
- Usar coleções genéricas (`List<Integer>`, `Map<String, Boolean>`, etc);
- Utilizar métodos utilitários associados a esses objetos.

**Quando usar objetos como atributos:**
- Se o valor pode ser `null`, prefira o tipo objeto (ex: `Integer`, `Boolean`);
- Se você precisa usar o tipo em coleções (`List`, `Set`, `Map`);
- Em DTOs e entidades que representam dados externos ou persistidos.

**Quando evitar:**
- Em cálculos intensos onde o desempenho importa, prefira os tipos primitivos por serem mais leves.

---

## 🔁 Condicionais

As estruturas condicionais, como `if` e `else`, permitem que o programa tome decisões com base em determinadas condições, controlando o fluxo da aplicação.

---

## 🔄 Laços de repetição

Laços como `for` e `while` permitem executar um bloco de código várias vezes. São úteis para percorrer listas ou repetir tarefas até que uma condição seja satisfeita.

---

## 📦 Classes com atributos e métodos

Classes são moldes de objetos. Elas definem atributos (características) e métodos (ações). São a base da programação orientada a objetos (POO) em Java.

---

## 🧩 Construtores e encapsulamento

Construtores são usados para inicializar objetos com valores. Encapsulamento é o princípio de esconder os dados internos das classes, permitindo o acesso controlado por meio de métodos `get` e `set`.

Construtores são usados para inicializar objetos com valores. Encapsulamento é o princípio de esconder os dados internos das classes, permitindo o acesso controlado por meio de métodos `get` e `set`.

---

## 🗂 Organização do projeto (estrutura de diretórios)

```text
src/
 └── main/
     └── java/
         └── com/
             └── package com.code.craft.mentor;/
                 ├── model/
                 ├── app/
                 ├── controller/
                 ├── dto/
                 ├── repository/
                 └── service/
```

- `model/`: entidades do domínio
- `controller/`: controladores da API
- `dto/`: objetos de transferência de dados
- `repository/`: interfaces de persistência
- `service/`: lógica de negócio
- `app/`: ponto de entrada da aplicação

---

## 💉 Injeção de Dependência

Injeção de dependência é um princípio fundamental para manter o código desacoplado e fácil de testar. Em vez de uma classe criar diretamente suas dependências, elas são "injetadas" de fora — geralmente por frameworks como o Spring.

### Antes do Spring – Conceito puro

Antes de falarmos de frameworks, é importante entender a base do conceito:

```java
public class PedidoService {
    private PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }
}
```

Aqui, `PedidoService` **não cria** um `PedidoRepository` internamente. Em vez disso, ele recebe essa dependência por meio do construtor. Isso torna a classe mais fácil de testar e reutilizar.

### Vantagens de usar injeção de dependência
- **Baixo acoplamento**: classes conhecem apenas o que precisam
- **Facilidade para testes**: podemos usar mocks ou fakes
- **Manutenção mais simples**: mudanças em uma classe têm menos impacto nas demais
- **Organização**: responsabilidades bem divididas

### Quando aplicar
- Sempre que uma classe depender de outra para funcionar
- Sempre que precisar alternar a implementação de uma interface
- Em serviços, repositórios e controladores

### Como funciona no Spring
Usamos a anotação `@Autowired` para indicar que queremos que o Spring forneça uma instância de uma classe:

```java
@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }
}
```
Nesse exemplo, o `PedidoRepository` será injetado automaticamente pelo Spring. Isso permite que a lógica de negócio (service) não dependa diretamente de como os dados são buscados.

---
## ✅ Atividades práticas

### Atividade 1

> Crie uma classe `Cliente` com os seguintes atributos:
> - `nome` (String)
> - `email` (String)
> - `ativo` (boolean)

Implemente:
- Um construtor com os três atributos
- Métodos `get` e `set`
- Um método `exibirInformacoes()` que imprime os dados do cliente no console

### Atividade 2

> Crie uma classe `Pedido` com os seguintes atributos:
> - `numero` (String)
> - `valorTotal` (Double)
> - `pago` (Boolean)
> - `cliente` (Cliente)

Implemente:
- Construtor completo
- Métodos `get` e `set`
- Um método `resumo()` que imprima:
  "Pedido [numero] - Pago: Sim/Não - Total: R$ [valor] - Cliente: [nome] - Email: [email]"

### Atividade 3

> Simule um cenário com injeção de dependência sem usar o Spring.

1. Crie uma interface `Notificador` com um método `notificar(String mensagem)`.
2. Crie uma classe `EmailNotificador` que implementa a interface e imprime no console:
   "Enviando e-mail: [mensagem]".
3. Crie uma classe `ServicoDeAviso` que receba um `Notificador` no construtor e tenha um método `enviarAviso()` que utilize o notificador para enviar uma mensagem.
4. Crie uma classe principal (`main`) que instancie `EmailNotificador`, injete no `ServicoDeAviso` e chame o método `enviarAviso()`.

> Objetivo: Demonstrar como a dependência (`Notificador`) pode ser injetada no serviço, permitindo a troca fácil de implementações e promovendo baixo acoplamento.

Próximo módulo: [Módulo 2 – Clean Code](../02-CleanCode/README.md)
