# 🔐 Gerenciador de Senhas Seguras

Aplicação em Java desenvolvida para armazenar e gerenciar senhas de forma segura, com foco em criptografia, autenticação e boas práticas de segurança da informação.

## 🎯 Objetivo

Permitir que usuários armazenem, gerenciem e verifiquem a segurança de suas senhas, utilizando:
- Criptografia com **BCrypt**
- Armazenamento seguro em arquivo `.txt`
- Autenticação com **verificação de dois fatores (2FA)**
- **Verificação de vazamento** de senhas via API pública (Have I Been Pwned)
- **Geração automática** de senhas seguras e aleatórias

## 🛠 Tecnologias Utilizadas
- Java
- jBCrypt (para criptografia)
- API externa `https://api.pwnedpasswords.com/`
- Git & GitHub (versionamento)
- Organização por pacotes: <br>
  `model` – entidades da aplicação <br>
  `repository` – manipulação de arquivos <br>
  `service` – regras de negócio <br>
  `util` – funcionalidades auxiliares <br>
  `test` – estrutura para testes organizados por camada

## 🗂 Estrutura de Pastas
```bash
   src/
   └── br.com.geovana.gerenciador/
       ├── main/
       │   └── App.java                 # Classe principal (main)
       ├── model/                       # Classes Credencial e Usuario
       ├── repository/                 # ArquivoRepository e CredencialRepository
       ├── service/                    # Autenticacao, 2FA, Criptografia, Gerenciador
       ├── util/                       # Gerador de senha e verificador de vazamento
       └── test/                       # Subpastas para testes unitários por camada
```

## 🔒 Funcionalidades

- Cadastro de senhas com criptografia segura
- Remoção, listagem e busca por serviço
- Criptografia com **BCrypt**
- Verificação de vazamento de senha via API
- Autenticação com 2FA (código enviado simulado no terminal)
- Geração de senha aleatória segura
- Login com credenciais salvas.

## ▶️ Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/geovanaclira/GeradorDeSenhasSeguras.git
   
2. Importe o projeto em uma IDE como IntelliJ ou Eclipse

3. Adicione a biblioteca `jbcrypt-0.4.jar` ao classpath.
   
4.  Compile e execute a classe `App.java`
   
5. Siga o menu interativo no terminal

6. Todas as credenciais são armazenadas em `credenciais.txt`

## 📴 Modo Offline 
O sistema conta com um modo offline. Essa funcionalidade permite que o usuário continue utilizando o gerenciador de senhas mesmo sem conexão com a internet.
Caso não haja internet no momento da verificação da senha, o sistema:
- Notifica que está no modo offline.
- Ignora a verificação de vazamento com a API Have I Been Pwned.
- Permite seguir com o fluxo normalmente, evitando falhas.

Mensagem exibida em modo offline:
`Modo offline: Sem conexão com a internet. Pulando verificação de vazamento.`

## 📋 Requisitos Atendidos
- Criptografia (BCrypt)	
- Armazenamento seguro	
- Autenticação com 2FA	
- Geração de senhas seguras	
- Verificação de vazamentos	
- Documentação e versionamento
- Java puro sem frameworks

## ⚠️ Segurança
- Todas as senhas são armazenadas criptografadas. O código foi revisado para evitar vulnerabilidades conhecidas. Qualquer exceção é tratada adequadamente.

## 🧠 Aprendizados
- Conceitos de segurança da informação
- Utilização de bibliotecas externas em Java
- Manipulação de arquivos
- Boas práticas de programação segura
- Integração com APIs externas

