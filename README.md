# testassigment

������: mvn package
������ ��� ������� ��� mysql (�� � ������): mvn package -P h2

������: java -jar test-assigment-1.0.jar

�������� ��������: http://localhost:8080/
������������ � ������: user / user

REST �������� :
GET http://localhost:8080/rest/person - ������ ���� �����
GET http://localhost:8080/rest/person/{id} - ������ ����������� ����
POST http://localhost:8080/rest/person - ���������� ��������
POST http://localhost:8080/rest/person/{id}/addresses - ���������� ������ ��������

�������� �� � ������������:
create database testassigment;
grant usage on *.* to user@localhost identified by "user";
grant all privileges on testassigment.* to user@localhost;

���������� ������������ � �� � ���: jdbc:mysql://localhost/testassigment (user/user)