## Sistema de biblioteca

### Rotas
- crud de biblioteca: /library
- Crud de estudantes: /student
- Crud de professores /professor
- Crud de bibliotecarios: /librarian
- livros cadastrados no sistema: /book
- Coleção de uma biblioteca: /collection 
- criação de emprestimos: /borrow
- entrada de devolução: /return

### Sub-rotas:
- Get ALL: /{rota}
- Delete: /{rota}/{id}
- Put: /{rota}/{id}, corpo json(atualização de todos campos)
- Post: /{rota}, corpo em json

### Estudantes / Professores:
- Get by name: /{rota}/name/{string}
- Get by registration: /{rota}/registration/{string}

### emprestimo / devolução:
- Get by personId: /{rota}/person/{uuid}