# 📘 Módulo 2 – Clean Code

## 🎯 Objetivo

Ensinar o desenvolvedor a escrever **código limpo e legível**, usando o projeto `CodeCraftMentor` como base prática. O objetivo é reforçar que um código fácil de entender é também mais fácil de manter, testar e evoluir.

---

## ✨ O que é Clean Code?

Clean Code é um conjunto de boas práticas para escrever código:
- Simples
- Legível
- Coeso
- Sem duplicações
- De fácil manutenção

> "Código limpo é como uma prosa bem escrita." – Robert C. Martin

---

## 🧼 Princípios que aplicaremos no projeto

### 1. Nomes significativos
- Nomeie classes, variáveis e métodos com clareza e intenção
- Evite nomes genéricos como `data`, `var1`, `doStuff`
- Exemplo: prefira `valorTotalPedido` a `v` ou `x`

### 2. Pequenas funções com propósito
- Uma função deve fazer **uma única coisa** e bem feita
- Pequenas funções são mais testáveis e reutilizáveis

### 3. Evite comentários desnecessários
- Escreva código autoexplicativo
- Comentários devem explicar o **porquê**, não o **como**

### 4. Código bem formatado
- Espaços e quebras de linha ajudam a leitura
- Use organização visual para separar blocos lógicos

### 5. Evite duplicação de lógica
- Extraia métodos e reutilize-os
- Se há repetição, há espaço para abstração

### 6. Classes e responsabilidades bem definidas
- Uma classe deve ter uma única razão para mudar (SRP – Princípio da Responsabilidade Única)

---

## 🚀 Aplicação no projeto `CodeCraftMentor`

Durante este módulo, revisaremos as entidades `Cliente`, `Produto` e `Pedido`, e criaremos os serviços responsáveis pelo cadastro e manipulação desses objetos de forma clara, reutilizável e seguindo os princípios de Clean Code.

---

## ✅ Atividades práticas

### Atividade 1 – Cadastro de Produto

- Atualize a classe `Produto` com os seguintes atributos:
  - `String nome`
  - `Integer quantidade`
  - `BigDecimal valorUnitario`
  - `BigDecimal valorTotal`

- Crie a lógica na camada de serviço (`ProdutoService`) que, ao receber o produto, calcule e atribua o `valorTotal` como:
  ```java
  valorTotal = valorUnitario.multiply(BigDecimal.valueOf(quantidade));
  ```

- Aplique nomes significativos, evite duplicações e mantenha a classe coesa.

### Atividade 2 – Cadastro de Cliente

- Crie a entidade `Cliente` com os seguintes atributos:
  - `String nome`
  - `String documento`
  - `String email`

- Implemente a classe `ClienteService` com o método `cadastrar(Cliente cliente)`

- Crie um método `resumo()` na entidade que retorne, por exemplo:
  ```java
  public String resumo() {
      return "Cliente: " + nome + " | Email: " + email;
  }
  ```

### Atividade 3 – Cadastro de Pedido (opcional para desafio extra)

- Crie a entidade `Pedido`, que contenha um `Produto` e um `Cliente`
- Implemente a classe `PedidoService` com o método `registrar(Pedido pedido)`
- No método `exibirResumo()`, apresente as seguintes informações:
  - Nome do cliente
  - Email do cliente
  - Nome do produto
  - Quantidade e valor total

> 💡 Dica: Use composição quando um objeto faz parte ou pertence a outro. 
Por exemplo, um Pedido tem um Cliente e um Produto. Em vez de criar todos os dados como atributos soltos, crie objetos separados (Cliente, Produto) e use-os dentro da classe Pedido. Isso deixa o código mais organizado, reutilizável e fácil de manter.

#### 🧩 O que é Composição de Objetos?

Composição é um princípio da orientação a objetos onde **uma classe é composta por outras**. No caso do `Pedido`, ele é formado por um `Produto` e um `Cliente`, ao invés de ter atributos soltos como `nomeProduto`, `nomeCliente`, etc.

```java
public class Pedido {
    private Cliente cliente;
    private Produto produto;

    public String exibirResumo() {
        return "Pedido de " + cliente.getNome() + " (" + cliente.getEmail() + ")\n" +
               "Produto: " + produto.getNome() + "\n" +
               "Quantidade: " + produto.getQuantidade() + "\n" +
               "Total: R$" + produto.getValorTotal();
    }
}
```

✅ **Benefícios da composição:**
- Reaproveitamento de código
- Redução da duplicação, código mais claro e reutilizável
- Melhor separação de responsabilidades
- Facilita manutenção e leitura
- Representa melhor a realidade

> Composição promove reutilização sem acoplamento excessivo. Prefira-a à herança quando possível.

---

Próximo módulo: [Módulo 3 – SOLID](../modulo-3/README.md)

