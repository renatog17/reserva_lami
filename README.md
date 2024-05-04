# Reserva de Laboratórios de Informática (LAMI) - UCSAL

## Descrição

Este é um sistema de reserva de laboratórios de informática (LAMI) desenvolvido para a Universidade Católica do Salvador (UCSAL). Ele permite que professores e estudantes reservem horários nos laboratórios de informática disponíveis para uso acadêmico.

## Funcionalidades

### Para Reservantes (Professores e Estudantes)
- **Reservar LAMI**: Os usuários podem reservar um laboratório de informática para um período de tempo específico.
- **Cadastro**: Novos usuários podem se cadastrar no sistema para fazer reservas.

### Para Administradores
- **Desativar LAMI**: Administradores têm a capacidade de desativar temporariamente um laboratório de informática, por exemplo, para manutenção.
- **Cadastrar Novo LAMI**: Administradores podem adicionar novos laboratórios de informática ao sistema.
- **Gerenciar Reservas**: Visualizar e gerenciar todas as reservas feitas nos laboratórios.

## Tecnologias Utilizadas

- Spring Framework: Utilizado para o desenvolvimento do backend da aplicação.
- Spring Security: Fornece autenticação e controle de acesso.
- Spring Data: Facilita o acesso e a manipulação de dados com o banco de dados.
- MySQL: Banco de dados relacional utilizado para armazenar as informações do sistema.

## Instalação e Configuração

1. Clone este repositório:

git clone https://github.com/seu-usuario/reserva-lami-ucsal.git


2. Importe o projeto em sua IDE preferida.

3. Configure as variáveis de ambiente e as propriedades do banco de dados no arquivo `application.properties`.

4. Execute o projeto. O Spring Boot iniciará o servidor na porta padrão.

## Endpoints da API

- **POST /reservante**: Cria um novo reservante no sistema.

- **POST /reserva**: Cria uma nova reserva de laboratório.

- **POST /lami**: Cria um novo laboratório de informática.

- **PATCH /lami/desativar**: Desativa temporariamente um laboratório de informática.

- **PATCH /lami/ativar**: Ativa um laboratório de informática que estava desativado.

- **POST /auth/login**: Autentica um usuário no sistema e fornece um token de acesso.


## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir uma issue ou enviar um pull request.

## Autores

- [Renato](https://github.com/renatog17)

## Licença

Este projeto está licenciado sob a [Licença MIT](https://opensource.org/licenses/MIT).
