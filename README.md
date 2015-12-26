# testassigment

Сборка: mvn package

Сборка для запуска без mysql (БД в памяти): mvn package -P h2

Запуск: java -jar test-assigment-1.0.jar

Тестовая страница: http://localhost:8080/

Пользователь и пароль: user / user

REST операции :

GET http://localhost:8080/rest/person - список всех людей

GET http://localhost:8080/rest/person/{id} - данные конкретного лица

POST http://localhost:8080/rest/person - добавление человека

POST http://localhost:8080/rest/person/{id}/addresses - добавление адреса человеку

Создание БД и пользователя:

create database testassigment;

grant usage on *.* to user@localhost identified by "user";

grant all privileges on testassigment.* to user@localhost;

Приложение подключается к БД с урл: jdbc:mysql://localhost/testassigment (user/user)