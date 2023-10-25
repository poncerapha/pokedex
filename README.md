https://github.com/poncerapha/pokedex/assets/38406330/0d7ad315-3dee-472b-8986-39a249e01f6a


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
$ git clone https://github.com/poncerapha/pokedex.git
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

## Futuras Melhorias

### Jetpack Compose

Jetpack Compose é um moderno toolkit de UI para o desenvolvimento de aplicativos Android. Ele permite que você crie interfaces de usuário de forma declarativa, usando componentes compostos, tornando o desenvolvimento de interfaces de usuário mais simples e flexível. Com Compose, você pode criar aplicativos Android de forma mais eficiente, aproveitando a natureza reativa e a programação funcional.

Para saber mais sobre o Jetpack Compose, visite [a documentação oficial](https://developer.android.com/jetpack/compose?gclid=CjwKCAjw-eKpBhAbEiwAqFL0mq6W1-98qW5uiDgMC7YGTtTuJGD2DcpiExLDUcNyAKTlV_JZrawl1hoCwlYQAvD_BwE&gclsrc=aw.ds).

### Room

Room é uma biblioteca da arquitetura Android Jetpack que simplifica o acesso a bancos de dados SQLite no Android. Ela fornece uma camada de abstração sobre o SQLite e ajuda a gerenciar o acesso a dados de forma mais organizada e eficiente. Com o Room, você pode definir esquemas de banco de dados em classes Java/Kotlin e realizar operações de CRUD de maneira simples.

Para saber mais sobre o Room, visite [a documentação oficial](https://developer.android.com/jetpack/androidx/releases/room).

### State Flow

State Flow é uma classe da biblioteca Kotlin Coroutines que fornece uma maneira reativa de propagar e observar mudanças de estado no aplicativo. Ele é amplamente usado para lidar com fluxos de dados em tempo real e gerenciar a comunicação assíncrona entre componentes do aplicativo. State Flow é uma escolha popular para lidar com eventos e notificações em aplicativos Android modernos.

Para saber mais sobre o State Flow, visite [a documentação oficial](https://developer.android.com/kotlin/flow/stateflow-and-sharedflow).

### Espresso

Espresso é uma estrutura de teste automatizado desenvolvida pelo Google para testar aplicativos Android. Ele é usado para criar testes funcionais que simulam a interação do usuário com o aplicativo. Espresso permite que você escreva testes que verificam se a interface do usuário responde corretamente às ações do usuário, como toques, gestos e digitação. É uma ferramenta valiosa para garantir a qualidade e a estabilidade de seus aplicativos Android.

Para saber mais sobre o Espresso, visite [a documentação oficial](https://developer.android.com/training/testing/espresso).

## Contribuição

Se você deseja contribuir para o projeto, sinta-se à vontade para abrir problemas (issues) e enviar solicitações de pull (pull requests) para melhorias e correções. Certifique-se de seguir as diretrizes de contribuição do projeto.
