<h1 align="center"> Star Wars B2W </h1>

<p align="center">
  API para castastro de planetas Star Wars, alguns dados são obtidos pela API pública do Star Wars: https://swapi.dev/
</p>

## Tecnologias

 * Java 1.8
 * SpringFramework 2.3.1.RELEASE
 * Banco de dados Oracle-xe-11g
 
## Features
 * Adicionar um planeta (com nome, clima e terreno)
 * Listar planetas
 * Buscar por nome
 * Buscar por ID
 * Remover planeta
 
 ## Como utilizar


### Cadastrando planeta na base de dados

**POST** `http://localhost:8090/api/v1/planeta`

```json

// request
{
  "nome": "Tatooine",
  "clima": "arid",
  "terreno": "desert"
}
```
```json
// response
{
  "id": "8a80cb81736a7ce201736a7d709f0001",
  "nome": "Tatooine",
  "clima": "arid",
  "terreno": "desert",
  "quantidadeFilmes": 5
}

```

### Listando planetas cadastrados na base de dados

**GET** `http://localhost:8090/api/v1/planeta/list`

```json

// response
[
 {
    "id": "8a80cb81736a7ce201736a7d709f0001",
    "nome": "Tatooine",
    "clima": "arid",
    "terreno": "desert",
    "quantidadeFilmes": 5
  },
  {
    "id": "8a80cb817368077401736808265f0001",
    "nome": "Yavin IV",
    "clima": "tropical",
    "terreno": "pedrejado",
    "quantidadeFilmes": 1
  }
]
```
### Buscando planeta na base de dados por meio do ID

**GET** `http://localhost:8090/api/v1/planeta/`**[ID]** </br>
`http://localhost:8090/api/v1/planeta/8a80cb81736a7ce201736a7d709f0001`
```json

// response 
{
  "nome": "Tatooine",
  "clima": "arid",
  "terreno": "desert",
  "quantidadeFilmes": 5
}
```

### Excluindo planeta na base de dados por meio do ID

**DELETE** `http://localhost:8090/api/v1/planeta/delete`**[ID]** </br>
`http://localhost:8090/api/v1/planeta/delete/8a80cb817364b351017364b3b29f0000`
```json

// response 
{
  "message": "Planeta excluído com sucesso"
}
```
## Criando banco de dados oracle
 
### start docker
```docker
docker pull oracleinanutshell/oracle-xe-11g
docker run -d -p 1521:1521 -e ORACLE_ALLOW_REMOTE=true oracleinanutshell/oracle-xe-11g
```

### Criando tabela planeta
```sql
CREATE TABLE planeta(
    id VARCHAR2(100) NOT NULL,
    nome VARCHAR2(100) NOT NULL,
    clima VARCHAR2(100) NOT NULL,
    terreno VARCHAR2(100) NOT NULL
);

ALTER USER <user> IDENTIFIED BY <nova senha>
```
