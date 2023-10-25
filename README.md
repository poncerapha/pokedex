<p align="center">
  <img alt="Pokedex logo" src=".github/logo.svg" width="400px" />
</p>

<p align="center" fontSize="60px">
  Pokédex
</p>

<p align="center">
  <img alt="Layout da aplicação" width="100%" src="./.github/screenshot.png" />
</p>

# Pokédex App

O Pokédex App é uma aplicação Android que permite aos usuários explorar informações sobre diferentes Pokémon. Ele utiliza as seguintes tecnologias principais: Koin, Epoxy e MockK.

## Pré-requisitos

Antes de começar a trabalhar com o projeto, certifique-se de ter o seguinte instalado em seu ambiente de desenvolvimento:

- Android Studio
- Kotlin
- Gradle

## Configuração

Siga as etapas abaixo para configurar o projeto em sua máquina:

1. Clone este repositório:

```bash
$ git clone https://github.com/poncerapha/pokedex.git && cd pokedex
```

2. Abra o projeto no Android Studio.

3. Execute a sincronização do Gradle para garantir que todas as dependências sejam baixadas e configuradas.

4. Compile o projeto e instale-o em um emulador ou dispositivo Android.

## Tecnologias Principais

### Koin

O Koin é utilizado para gerenciar a injeção de dependência em todo o aplicativo. Ele permite a criação de módulos para fornecer e injetar dependências em componentes do Android, tornando o código mais limpo e desacoplado.

Para saber mais sobre o Koin, visite [a documentação oficial](https://insert-koin.io/).

### Epoxy

O Epoxy é uma biblioteca de criação de interfaces de usuário que facilita a construção de listas complexas e desempenho otimizado no Android. O aplicativo utiliza o Epoxy para criar exibições de lista personalizadas para exibir informações sobre Pokémon.

Para saber mais sobre o Epoxy, visite [a documentação oficial](https://github.com/airbnb/epoxy).

### MockK

O MockK é uma biblioteca Kotlin que auxilia na criação de objetos fictícios (mocks) para testes unitários e de integração. É amplamente utilizado no projeto para escrever testes de unidade e garantir a qualidade do código.

Para saber mais sobre o MockK, visite [a documentação oficial](https://mockk.io/).

## Contribuição

Se você deseja contribuir para o projeto, sinta-se à vontade para abrir problemas (issues) e enviar solicitações de pull (pull requests) para melhorias e correções. Certifique-se de seguir as diretrizes de contribuição do projeto.