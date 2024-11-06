# Conversor de Moedas

## 📄 Descrição

O **Conversor de Moedas** é uma aplicação em Java que permite a conversão de valores em USD (Dólar Americano) para diversas moedas latino-americanas, como ARS, BOB, BRL, CLP, COP e USD. A aplicação utiliza uma API externa para obter as taxas de câmbio em tempo real e exibe um menu interativo para que o usuário possa selecionar a moeda desejada.

## 🛠️ Funcionalidades

- **Conversão de Moedas**: Converte um valor em USD para várias moedas selecionáveis (ARS, BOB, BRL, CLP, COP, USD).
- **Obtenção de Taxas de Câmbio em Tempo Real**: Utiliza a API Exchangerate-API para obter as taxas de câmbio atualizadas.
- **Filtragem de Moedas**: Exibe apenas as moedas latino-americanas predefinidas.
- **Interface de Menu Interativo**: O usuário pode selecionar a moeda de destino através de um menu simples.

## 📸 Demonstração

Aqui estão algumas imagens mostrando as funcionalidades do Conversor de Moedas:

![Menu de Conversão](C:\Users\arthu\OneDrive\Pictures\Screenshots\Conversor/Menu.png)
*Menu interativo para selecionar a moeda de destino.*

![Resultado da Conversão](caminho/para/imagem2.png)
*Exemplo de conversão de USD para BRL (Real Brasileiro).*


## 📂 Estrutura do Projeto
```plaintext
conversor-de-moedas/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── TaxasDeCambio.java
│   │   │   ├── ServicoDeCambio.java
│   │   │   └── Menu.java
├── pom.xml
```
## 🚀 Como Rodar o Projeto

### Pré-requisitos

- **Java** (JDK 11 ou superior)
- **Maven** (para gerenciamento de dependências)
- **Conexão com a Internet** (para acessar a API de taxas de câmbio)

### Instalação e Execução
1. **Clone o repositório:**
   ```bash
   git clone https://github.com/arthur810FR/ConversorDeMoedas.git
2. **Navegue até o diretório do projeto:**
   ```bash
   cd desafiosLogicaProgramacao
3. **Abra o projeto na sua IDE e execute as classe Menu para o projeto rodar.**

## 🧰 Tecnologias Utilizadas

- **Java 11+** - Linguagem de programação
- **Maven** - Gerenciamento de dependências
- **Gson** - Biblioteca para manipulação de JSON
- **Exchangerate-API** - API de taxas de câmbio

## 💡 Exemplos de Uso

1. **Conversão de Moeda**
   - Escolha uma moeda de destino (como BRL para Real Brasileiro).
   - Digite o valor em USD que deseja converter.
   - O sistema exibirá o valor convertido na moeda selecionada.

2. **Visualização de Taxas de Câmbio**
   - Acesse o menu e visualize as taxas de câmbio filtradas para as moedas disponíveis.

## 📞 Contato
**Arthur Francisco Guedes Azevedo**

- [LinkedIn](https://www.linkedin.com/in/arthur-azevedo-desenvolvedor/)
- [Email](mailto:arthurfranciscoazevedo@gmail.com)
