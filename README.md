Fenix-framework database exemple for a student list: aluno(code+name)

  create database:

	mysql -p -u root

	Enter password: rootroot

	mysql> CREATE DATABASE alunos;

	mysql> \q


  compile and run with: mvn package exec:java

  commands (<enter> for help):

  	Add member with: + number name

  	Remove member with: - number

	Lookup name by number: = number

  	Find members by regular expression with: ? regex (ex. ? Maria.*)

  	List all with: *

  	Quit with: q

  	Delete all (!) with: $

(c)reis.santos@tecnico.ulisboa.pt, 2017
