# 📘 Módulo 2 – Clean Code e Histórias de Usuário

## 🎯 Objetivo

Ensinar o trainee a escrever **código limpo e legível** e aplicar esse conhecimento na **implementação de histórias de usuário reais**, usando o projeto `CodeCraftMentor` como base prática.

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

## 💮 Princípios que aplicaremos no projeto

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

## 🚀 Histórias de Usuário

Durante este módulo, também abordamos a implementação de **User Stories** (histórias de usuário), seguindo o modelo usado em ferramentas como o Azure DevOps (VSTS).

Cada funcionalidade implementada será representada por um **Product Backlog Item (PBI)**.

Formato:
> **Como** [persona/usuário]  
> **Quero** [funcionalidade]  
> **Para** [benefício]

---

## ✅ Atividades práticas (PBIs)

### 📅 PBI 1 – Cadastro de Produto
**Como** vendedor da loja  
**Quero** cadastrar um novo produto com nome, quantidade e preço  
**Para** que ele fique disponível para vendas

**Tarefas:**
- Criar classe `Produto` com:
  - `String nome`
  - `Integer quantidade`
  - `BigDecimal valorUnitario`
  - `BigDecimal valorTotal`
- Na classe `ProdutoService`, calcular o `valorTotal` como:
  ```java
  valorTotal = valorUnitario.multiply(BigDecimal.valueOf(quantidade));
  ```
- Aplicar boas práticas de Clean Code (nomes claros, separação de responsabilidades)

---

### 📅 PBI 2 – Cadastro de Cliente
**Descritivo:**
O sistema deve permitir o cadastro de um cliente com as seguintes informações:
- Nome completo
- Documento (CPF ou CNPJ)
- E-mail de contato

Esses dados devem ser armazenados e organizados de forma que o cliente possa posteriormente ser vinculado a um pedido de venda. O nome e o e-mail do cliente deverão estar disponíveis para exibição em resumos de pedidos.

Além do cadastro, o sistema deve apresentar uma forma de **visualizar um resumo do cliente**, contendo apenas nome e e-mail, para facilitar a identificação rápida nas telas de pedido.

> Este PBI foca no domínio do cliente. Ainda **não há necessidade de persistência em banco de dados ou uso de framework** (como Spring), pois o objetivo é aplicar os fundamentos de programação orientada a objetos, composição e boas práticas de Clean Code.

---

### 📅 PBI 3 – Registrar Pedido
**Como** atendente  
**Quero** registrar um pedido com cliente e produto  
**Para** manter o controle de vendas e faturamento

**Tarefas:**
- Criar classe `Pedido` com:
  - `Cliente cliente`
  - `Produto produto`
- Criar `PedidoService` com método `registrar(Pedido pedido)`
- Criar método `exibirResumo()` com informações:
  - Nome e email do cliente
  - Nome, quantidade e valor total do produto

#### 🧉 O que é Composição de Objetos?
Composição é quando um objeto é **composto por outros objetos**. Em vez de repetir atributos de cliente e produto, reutilizamos suas classes dentro de `Pedido`:

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

> 💡 **Dica:** Use composição quando um objeto **faz parte** ou **pertence** a outro. Isso deixa o código mais **organizado, reutilizável e fácil de entender**.

---

Próximo módulo: [Módulo 3 – SOLID](../modulo-3/README.md)
