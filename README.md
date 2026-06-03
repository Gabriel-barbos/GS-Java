# SmartCity Alert - Global Solution Java 2026

## Sobre o Projeto

O **SmartCity Alert** e uma aplicacao Java desenvolvida para a disciplina de **Domain Driven Design - Java**, alinhada ao **ODS 9 - Industria, Inovacao e Infraestrutura**.

A proposta do sistema e simular uma plataforma inteligente de monitoramento urbano, permitindo o gerenciamento de ocorrencias relacionadas a infraestrutura da cidade, como enchentes, falta de energia, transito, riscos urbanos e problemas operacionais.

O projeto tem foco em Programacao Orientada a Objetos, modelagem bem estruturada, clareza de responsabilidades, boas praticas de Java e organizacao de codigo.

## Objetivo

Criar uma solucao simples, funcional e organizada capaz de registrar ocorrencias urbanas, listar ocorrencias cadastradas, gerar relatorios simples, resolver ocorrencias e simular notificacoes de alerta.

## Funcionalidades

- Registrar ocorrencias urbanas.
- Listar ocorrencias cadastradas.
- Resolver ocorrencias.
- Gerar relatorios simples.
- Simular notificacoes de alerta por sensores.

## Conceitos de Java Aplicados

| Conceito | Aplicacao |
| --- | --- |
| Encapsulamento | atributos privados e getters/setters |
| Heranca | especializacao das ocorrencias |
| Classe abstrata | classe `Ocorrencia` |
| Interface | interface `Notificavel` |
| Sobrescrita | `@Override` em relatorios |
| Sobrecarga | multiplos metodos de cadastro |
| Polimorfismo | uso de heranca e interfaces |
| Organizacao em pacotes | separacao de responsabilidades |

## Estrutura do Projeto

```txt
src/
|-- app/
|   `-- Main.java
|-- abstracts/
|   `-- Ocorrencia.java
|-- interfaces/
|   `-- Notificavel.java
|-- model/
|   |-- infraestrutura/
|   |   `-- Sensor.java
|   |-- ocorrencias/
|   |   |-- Enchente.java
|   |   |-- FaltaEnergia.java
|   |   `-- Transito.java
|   `-- usuario/
|       `-- Operador.java
|-- service/
|   |-- OcorrenciaService.java
|   `-- RelatorioService.java
`-- util/
    `-- Menu.java
```

## Fluxo do Sistema

```txt
1 - Registrar ocorrencia
2 - Listar ocorrencias
3 - Resolver ocorrencia
4 - Gerar relatorio
5 - Sair
```

## Como Executar

A partir da raiz do projeto:

```bash
cd src
javac app/Main.java
java app.Main
```

Tambem e possivel compilar para uma pasta de saida:

```bash
javac -d out -sourcepath src src/app/Main.java
java -cp out app.Main
```

## Roadmap de Desenvolvimento

1. `chore: create initial project structure`
2. `feat: add abstract occurrence model`
3. `feat: implement occurrence inheritance structure`
4. `feat: implement notification interface and sensors`
5. `feat: create occurrence service with method overloading`
6. `feat: implement interactive console menu`
7. `docs: finalize documentation and refactor project`

## Explicacao da Modelagem

### Classe Abstrata - `Ocorrencia`

Representa um conceito generico do sistema. Ela nao deve ser instanciada diretamente, servindo como base para os tipos especificos de ocorrencia.

### Heranca

As classes `Enchente`, `FaltaEnergia` e `Transito` herdam caracteristicas da classe `Ocorrencia`.

### Interface - `Notificavel`

Representa um comportamento compartilhado por classes capazes de emitir alertas. A classe `Sensor` implementa essa interface.

### Sobrescrita

Cada ocorrencia sobrescreve o metodo `gerarRelatorio()`, permitindo comportamento especifico para cada tipo.

### Sobrecarga

O sistema possui multiplos metodos de cadastro em `OcorrenciaService`, demonstrando flexibilidade na chamada dos metodos.

## Integrantes

- Nome: Gabriel Barbosa
- RM: 570133

- Nome: Vitor Carvalho Alexandre
- RM: 562298

- Nome: Pedro Rodrigues Almeida
- RM: 564711
 
- Nome: Alexandre Martins
- RM: 561732

## Possiveis
Evolucoes Futuras

- Integracao com banco de dados.
- Dashboard web.
- API REST.
- Aplicativo mobile.
- Integracao com sensores IoT.
- Notificacoes em tempo real.
- Integracao com APIs meteorologicas.
- Monitoramento geografico.
