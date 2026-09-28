# Sistema de Gestão de Alunos

Estrutura inicial com frontend em HTML/CSS/JavaScript, API REST em Java e banco MySQL.

## Estrutura

- `frontend/`: página inicial, estilos e JavaScript do navegador.
- `backend/`: API Spring Boot com Maven.
- `database/schema.sql`: criação do banco e da tabela inicial de alunos.
- `src/main/`: scaffold Java anterior criado pelo VS Code; mantido sem alterações.

## Pré-requisitos

- JDK 17 ou superior
- Maven 3.9 ou superior
- MySQL 8 ou compatível

## Iniciar

1. No MySQL, execute `database/schema.sql`.
2. No PowerShell, configure as credenciais usadas pela API:

	```powershell
	$env:DB_USERNAME = "root"
	$env:DB_PASSWORD = "sua-senha"
	```

3. Inicie a API a partir da raiz do repositório:

	```powershell
	mvn -f backend/pom.xml spring-boot:run
	```

4. Abra `frontend/index.html` no navegador ou use a extensão Live Server do VS Code.
5. Teste a API em `http://localhost:8080/api/health`.

A página e a API são esqueletos iniciais; a integração entre a interface e a API e as operações de alunos ainda precisam ser implementadas.