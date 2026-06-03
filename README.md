# SmartCity Alert - Global Solution Java 2026

## Sobre o Projeto

O **SmartCity Alert** e uma aplicacao Java desenvolvida para a disciplina de **Domain Driven Design - Java**, alinhada ao **ODS 9 - Industria, Inovacao e Infraestrutura**.

A proposta do sistema e simular uma plataforma inteligente de monitoramento urbano, permitindo o gerenciamento de ocorrencias relacionadas a infraestrutura da cidade, como enchentes, falta de energia, transito, riscos urbanos e problemas operacionais.

O projeto tem foco em Programacao Orientada a Objetos, modelagem bem estruturada, clareza de responsabilidades, boas praticas de Java e organizacao de codigo.

## Objetivo

Criar uma solução simples, funcional e organizada capaz de registrar ocorrencias urbanas, listar ocorrencias cadastradas, gerar relatorios simples, resolver ocorrencias e simular notificacoes de alerta.

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

## Classes Principais

Abaixo estão descritas de forma resumida as responsabilidades das principais classes do sistema:

- **`Main`** ([Main.java](file:///c:/java/GS-Java/src/app/Main.java)): Ponto de entrada da aplicação que inicia e controla o fluxo do menu.
- **`Ocorrencia`** ([Ocorrencia.java](file:///c:/java/GS-Java/src/abstracts/Ocorrencia.java)): Classe abstrata que serve de modelo para os diferentes tipos de incidentes, contendo atributos como id, descrição e status.
- **`Enchente`, `FaltaEnergia`, `Transito`** (`model/ocorrencias/`): Subclasses que herdam de `Ocorrencia`, especializando o comportamento para cada tipo específico de incidente.
- **`Sensor`** ([Sensor.java](file:///c:/java/GS-Java/src/model/infraestrutura/Sensor.java)): Representa um sensor urbano inteligente capaz de disparar alertas automáticos ao implementar a interface `Notificavel`.
- **`Operador`** ([Operador.java](file:///c:/java/GS-Java/src/model/usuario/Operador.java)): Representa o usuário operacional responsável por registrar ou resolver ocorrências no sistema.
- **`OcorrenciaService`** ([OcorrenciaService.java](file:///c:/java/GS-Java/src/service/OcorrenciaService.java)): Gerencia o ciclo de vida das ocorrências (cadastro, listagem e resolução) aplicando regras de negócio.
- **`RelatorioService`** ([RelatorioService.java](file:///c:/java/GS-Java/src/service/RelatorioService.java)): Responsável por processar dados de ocorrências para exibição e geração de relatórios de métricas.
- **`Menu`** ([Menu.java](file:///c:/java/GS-Java/src/util/Menu.java)): Classe utilitária com métodos estáticos para formatação e exibição do menu interativo no console.
- **`Notificavel`** ([Notificavel.java](file:///c:/java/GS-Java/src/interfaces/Notificavel.java)): Interface que define o contrato para qualquer componente que possa emitir notificações/alertas.

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

- Nome: Adicionar nome
- RM: Adicionar RM

## Possiveis Evolucoes Futuras

- Integracao com banco de dados.
- Dashboard web.
- API REST.
- Aplicativo mobile.
- Integracao com sensores IoT.
- Notificacoes em tempo real.
- Integracao com APIs meteorologicas.
- Monitoramento geografico.
