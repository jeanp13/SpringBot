# SpringBot setup

<h2> Instalar NodeJS</h2>
- Instalar NodeJS (Habilitar a opção de comando no terminal) : https://nodejs.org
- Testar o comando <b>npm</b> no terminal

<h2> Instalar Apache Maven</h2>
- Instalar o apache maven : https://www.apache.org/
- Configurar variável de ambiente do maven Exemplo: <b>C:\Program Files\apache-maven-3.3.3\bin</b>

<h2>IDE Eclipse</h2>
- Baixar e instalar a IDE eclipse: https://eclipse.org/downloads/
- Instalar o plugin JBoss Tools : http://tools.jboss.org/

<h2>Banco de Dados</h2>
- Instar o SQL SERVER 

<h2> GIT </h2>
- Instalar o GIT SCM : https://git-scm.com/
- Habilitar o git na ALFA executar o comando <b>git config --global url."https://".insteadOf git://</b>
- Instalar o GitHub Desktop : https://desktop.github.com/
- Clonar o repositório SpringBot para a workspace : https://github.com/millysfabrielle/SpringBot.git

<h2>Bower</h2>
- Instalar o Bower de modo Global (http://bower.io/) : <b>npm install -g bower</b>

<h2>Grunt</h2>
- Instalar o Grunt de modo Global (http://gruntjs.com/) : <b>npm install -g grunt-cli</b>


<h2>Navegar até a pasta do projeto para executar os comandos abaixo</h2>
- Habilitar o Grunt para o projeto : <b>npm install grunt --save-dev</b>
- Grunt Task para copiar arquivos do Bower : <b>npm install grunt-bowercopy --save-dev</b>
- Grunt Task para injetar dependência do Bower : <b>npm install --save-dev grunt-include-source</b>
- Importar dependências do bower :  <b>bower install</b>
- Copiar dependências do Bower : <b>grunt bowercopy</b>
- Incluir dependências do Bower : <b>grunt include-source</b>
- Executar o projeto : <b>mvn spring-boot:run</b>

<h2>Bootstrap Template</h2>
- http://startbootstrap.com/template-overviews/sb-admin-2/

