# Módulo 3 — Princípios SOLID

Neste módulo, vamos aprender e aplicar os **princípios SOLID**, que são boas práticas para escrever código limpo, organizado e de fácil manutenção. Também vamos reforçar a separação entre as camadas da aplicação e utilizar injeção de dependência com o Spring Boot.

---

## ✅ O que é SOLID?

**SOLID** é um acrônimo para cinco princípios da programação orientada a objetos que ajudam a escrever código mais confiável e flexível. Vamos ver cada um deles com uma explicação simples e exemplos do nosso projeto.

---

## 🔹 1. S — Single Responsibility Principle (Princípio da Responsabilidade Única)

> Uma classe deve ter **apenas um motivo para mudar**.

### 💡 Exemplo:

A classe `ClienteService` cuida apenas da **regra de negócio** dos clientes. A classe `ClienteRepository` cuida apenas da **persistência no banco de dados**.

```java
public class ClienteService {
    public Cliente cadastrar(Cliente cliente) {
        // Regras de validação
        return cliente;
    }
}
```

---

## 🔹 2. O — Open/Closed Principle (Aberto para Extensão, Fechado para Modificação)

> Podemos **adicionar novos comportamentos** sem precisar **alterar** o código existente.

### 💡 Exemplo:

Queremos calcular o preço com desconto. Podemos criar uma interface:

```java
public interface Desconto {
    BigDecimal aplicar(BigDecimal valor);
}
```

E diferentes estratégias:

```java
public class DescontoFixo implements Desconto {
    public BigDecimal aplicar(BigDecimal valor) {
        return valor.subtract(BigDecimal.valueOf(10));
    }
}

public class DescontoPorcentagem implements Desconto {
    public BigDecimal aplicar(BigDecimal valor) {
        return valor.multiply(BigDecimal.valueOf(0.9)); // 10% de desconto
    }
}
```

---

## 🔹 3. L — Liskov Substitution Principle (Princípio da Substituição de Liskov)

> Se `ClasseA` herda de `ClasseB`, então podemos usar `ClasseA` no lugar de `ClasseB` **sem problemas**.

### 💡 Exemplo:

Se temos uma classe `Produto`, podemos criar:

```java
public class ProdutoFisico extends Produto {
    // Calcula frete
}

public class ProdutoDigital extends Produto {
    // Não tem frete
}
```

Ambos podem ser tratados como `Produto`, mas cada um tem seu comportamento específico.

---

## 🔹 4. I — Interface Segregation Principle (Princípio da Segregação de Interfaces)

> É melhor ter **interfaces pequenas** e específicas do que uma única interface com muitos métodos.

### 💡 Exemplo:

No status do pedido, em vez de uma interface com vários métodos:

```java
public interface PedidoService {
    void pagar();
    void enviar();
    void concluir();
}
```

Criamos interfaces separadas:

```java
public interface PedidoPagavel {
    void pagar(Pedido pedido);
}

public interface PedidoEnviavel {
    void enviar(Pedido pedido);
}
```

Assim, cada classe implementa só o que **realmente precisa**.

---

## 🔹 5. D — Dependency Inversion Principle (Princípio da Inversão de Dependência)

> Dependa de **interfaces**, não de implementações.

### 💡 Exemplo:

Em vez de fazer isso:

```java
private ClienteRepository repo = new ClienteRepository(); // errado
```

Fazemos isso:

```java
private final IClienteRepository repo;

public ClienteService(IClienteRepository repo) {
    this.repo = repo;
}
```

E o Spring injeta a implementação real. Isso facilita testes e troca de implementação.

---

## 🧱 Camadas do Projeto

Nosso projeto está dividido em camadas, para organizar melhor o código:

* **controller:** Recebe as requisições HTTP (ex: POST, GET, PUT).
* **service:** Contém a lógica de negócio.
* **repository:** Acesso ao banco de dados.
* **dto:** Dados usados na entrada/saída da API.
* **model/domain:** Entidades que representam o negócio.

---

## 🚀 O que vamos construir?

Vamos criar endpoints REST para:

### Cliente

* `POST /clientes` — Criar cliente
* `PUT /clientes/{id}` — Atualizar cliente
* `GET /clientes` — Listar todos

### Produto

* `POST /produtos`
* `PUT /produtos/{id}`
* `GET /produtos`

---

## 🧰 Testes e Injeção de Dependência

* Usaremos o Spring para injeção de dependência via construtor.
* Os testes serão simples no começo, mas vamos evoluir com testes unitários e de integração.

---

## 📚 Conclusão
Os princípios SOLID ajudam a escrever código limpo, organizado e mais fácil de manter. Vamos aplicar cada um deles no nosso projeto de forma prática e gradual.

---
## ✅ Atividade prática
### 📦 Refatoração do Módulo de Produto
#### 🎯 Objetivos da Atividade
- O produto deve ter os seguintes atributos:
    - `id`
    - `nome`
    - `preço`
    - `estoque`
    - `descrição`
  
- Refatorar o módulo de Produto para:
    - Aplicar Clean Architecture
    - Seguir princípios SOLID
    - Melhorar coesão, reutilização e desacoplamento
- Implementar endpoints REST para:
    - ✅ Cadastro de Produto
    - ✏️ Atualização de Produto
    - 🔍 Listagem de Produtos
- Separar claramente caso necessário:
    - Entidades de Domínio
    - DTOs contextuais
    - Interfaces e serviços
    - Validações reutilizáveis
    - Mapeamento com MapStruct

---


