docker run --name some-mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql:5.7

docker rm javaapp ; docker run --name javaapp --link some-mysql -e 'MYSQLS_HOSTNAME=some-mysql' -e 'MYSQLS_PORT=3306' -e 'MYSQLS_USERNAME=root' -e 'MYSQLS_PASSWORD=my-secret-pw' -e 'PORT=8080' -e 'MYSQLS_DATABASE=mysql' -p 8080:8080  jexampleapp
