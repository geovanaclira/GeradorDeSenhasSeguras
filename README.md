# 🔐 Gerenciador de Senhas Seguras

Este projeto Java é um **Gerenciador de Senhas** desenvolvido com foco em **segurança da informação**, ideal para praticar conceitos como criptografia, autenticação e boas práticas de armazenamento seguro de credenciais.

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
- Organização por pacotes:
model – entidades da aplicação
repository – manipulação de arquivos
service – regras de negócio
util – funcionalidades auxiliares
test – estrutura para testes organizados por camada

## 🗂 Estrutura de Pastas


## 🔒 Funcionalidades

- Cadastro de senhas com criptografia segura
- Remoção, listagem e busca por serviço
- Criptografia com **BCrypt**
- Verificação de vazamento de senha via API
- Autenticação com 2FA (código enviado simulado no terminal)
- Geração de senha aleatória segura

## ▶️ Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   
2. Compile e execute o projeto:
    ```bash
   cd src
   javac br/com/geovana/gerenciador/Main.java
   java br.com.geovana.gerenciador.Main
   
3. O arquivo credenciais.txt será criado automaticamente no diretório do projeto.

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
- Este projeto foi fundamental para praticar:

- Conceitos de segurança da informação
- Utilização de bibliotecas externas em Java
- Manipulação de arquivos
- Boas práticas de programação segura
- Integração com APIs externas

