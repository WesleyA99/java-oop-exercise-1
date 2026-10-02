# Exercícios Java — Cadastro de Usuário e Conta Bancária

Projeto de exercícios da disciplina/curso, com foco em POO (Programação Orientada a Objetos), separação de responsabilidades, validação de dados e tratamento de erros com exceções.

## Estrutura do projeto

```
src/
  Main.java
  Usuario.java
  ValidateCPF.java
  UserRegistration.java
  BankAccount.java
  BankAccountMenu.java
```

Todos os arquivos ficam na pasta `src`, sem uso de pacotes (package), mantendo a organização simples para o estágio atual do aprendizado.

## Visão geral das classes

| Classe | Responsabilidade |
|---|---|
| `Usuario` | Guarda os dados da pessoa (nome e CPF). Não conhece teclado nem regras de validação externas. |
| `ValidateCPF` | Regra pura de validação de formato do CPF (11 dígitos). Não depende de interação com o usuário. |
| `UserRegistration` | Interage com o teclado para cadastrar um usuário: pede nome, pede CPF (com validação e repetição em caso de erro), confirma os dados antes de prosseguir. |
| `BankAccount` | Representa a conta bancária: saldo, limite de cheque especial, operações de depósito, saque, pagamento de boleto e verificação de uso do cheque especial. Não imprime nada na tela — apenas calcula e, em caso de erro, lança uma exceção (`IllegalArgumentException`). |
| `BankAccountMenu` | Menu interativo do banco: mostra as opções, lê a escolha do usuário, chama os métodos de `BankAccount` e trata os erros lançados por eles com `try/catch`. |
| `Main` | Ponto de entrada do programa. Apenas cria o `Scanner` e chama `BankAccountMenu.iniciar(scanner)`. |

## Regras de negócio implementadas

### Cadastro de usuário
- Nome não pode ser vazio.
- CPF deve ter exatamente 11 dígitos numéricos.
- Após digitar nome e CPF, o usuário confirma se os dados estão corretos antes de prosseguir; se não confirmar, o cadastro é refeito.

### Conta bancária
- O limite de cheque especial é calculado **uma única vez**, no momento da criação da conta, a partir do valor do depósito inicial:
  - Depósito ≤ R$500,00 → limite de R$50,00
  - Depósito > R$500,00 → limite de 50% do valor depositado
- É possível sacar ou pagar boletos usando o saldo somado ao limite de cheque especial.
- Ao depositar, se a conta estava usando cheque especial, é cobrada uma taxa de 20% sobre o valor que estava sendo usado, descontada do saldo após a entrada do depósito.
- Operações inválidas (valores negativos, saldo insuficiente) lançam `IllegalArgumentException`, tratada no menu.

## Menu interativo

```
1 - Consultar saldo
2 - Consultar cheque especial
3 - Depositar
4 - Sacar
5 - Pagar boleto
6 - Verificar se está usando cheque especial
7 - Consultar dados (nome/cpf)
8 - Sair
```

## Como executar

1. Abra a pasta do projeto no VS Code (com a extensão *Extension Pack for Java* instalada).
2. Abra o arquivo `src/Main.java`.
3. Clique em **Run** (acima do método `main`) ou pressione `F5`.
4. Siga as instruções no terminal integrado: digite nome, CPF, confirme os dados, depois digite o valor do depósito inicial para criar a conta.
5. Use o menu numérico para testar as operações.

## Conceitos praticados

- Separação de responsabilidades (dados vs. validação vs. interação vs. orquestração)
- Encapsulamento (atributos `private` com `get`/`set`)
- Construtores e inicialização de estado
- Estruturas de repetição (`do-while`, `while`) para validação de entrada
- Tratamento de erros com `throw` / `try-catch` (`IllegalArgumentException`)
- Organização de projeto em pasta `src`
