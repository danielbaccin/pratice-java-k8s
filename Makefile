build:
	mvn clean install; \
	docker build --force-rm -t pratice-java-k8s .

run-db: stop-db rm-db
	docker run --name mysql57 -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456 -e MYSQL_USER=java -e MYSQL_PASSWORD=1234 -e MYSQL_DATABASE=pratice_java_k8s -d mysql/mysql-server:5.7

run-app: stop-app rm-app
	docker run --name myapp -p 8080:8080 -d -e DATABASE_SERVER_NAME=mysql57 --link mysql57:mysql57 pratice-java-k8s:latest
