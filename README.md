# Conversor de Moedas - Projeto Java

Este projeto é um **Conversor de Moedas** desenvolvido em Java, que utiliza a API ExchangeRate-API para obter taxas de câmbio atualizadas em tempo real. O programa oferece uma interface textual via console para o usuário escolher entre diferentes opções de conversão de moedas.

---

## Funcionalidades

- Conversão dinâmica de moedas usando dados da API ExchangeRate-API.
- Suporte para pelo menos 6 opções diferentes de conversão entre moedas, incluindo:
  - BRL (Real Brasileiro)
  - USD (Dólar Americano)
  - ARS (Peso Argentino)
  - CLP (Peso Chileno)
  - Outros conforme código no projeto
- Interface de menu interativa via console.
- Tratamento de erros simples, com mensagens para entradas inválidas e falha na consulta à API.

---

## Tecnologias Utilizadas

- **Java 11** — versão mínima requerida para rodar o projeto.
- **Maven** — para gerenciamento de dependências e execução do projeto.
- **Gson** — biblioteca para manipulação e análise de dados JSON.
- **HttpClient (Java 11)** — para realizar requisições HTTP à API.
- **API ExchangeRate-API** — fonte dos dados de taxa de câmbio em tempo real.

---

## API ExchangeRate

Este projeto utiliza a API pública [ExchangeRate-API](https://www.exchangerate-api.com/) para obter as taxas de câmbio atualizadas.  
Uma chave de API válida foi usada (inserida diretamente no código na classe `ExchangeRateService`).

---

## Como Executar

### Pré-requisitos

- Ter Java 11 (ou superior) instalado.
- Ter Maven instalado (ou usar Maven Wrapper se configurado).

### Rodando o projeto via terminal

```bash
mvn compile
mvn exec:java -Dexec.mainClass=br.com.conversor.Main

Em seguida, siga as instruções do menu no console.
Estrutura do Projeto

conversor-moedas/
├── pom.xml
└── src/
    └── main/
        └── java/
            └── br/
                └── com/
                    └── conversor/
                        ├── Main.java
                        ├── ExchangeRateService.java
                        └── Conversor.java

Observações

    Caso não tenha Maven instalado, o projeto pode ser aberto em IDEs que suportem Maven (como VS Code com extensão Java).

    O projeto está preparado para ser facilmente compilado e executado via linha de comando.

    As taxas de câmbio dependem da disponibilidade da API ExchangeRate-API.

    Para alterações ou melhorias, basta modificar as classes na pasta src/main/java.

Autor

Projeto desenvolvido por [Gui Brauna].

Se tiver dúvidas ou problemas, abra uma issue no repositório do GitHub.
Obrigado por usar o Conversor de Moedas!
