Para ejecutar este proyecto debe agregar al fichero tomcat-users.xml local o global -al menos- los siguientes roles y usuarios:
	<role rolename="ADMIN"/>
	<role rolename="ORD"/>
	<user password="admin" roles="ADMIN" username="admin"/>

Utiliza el realm por defecto de tomcat: UserDatabase

---

Si se desea ejecutar el prouecto con un REALM en BD se debe:
1. Indicar el nuevo realm en el web.xml
2. Agregar el realm al server.xml
			<Realm className="org.apache.catalina.realm.JDBCRealm"
			driverName="org.gjt.mm.mysql.Driver"
			connectionURL="jdbc:mysql://localhost/blogbd?user=user&amp;password=123"
			userTable="users" userNameCol="user_name" userCredCol="user_pass"
			userRoleTable="user_roles" roleNameCol="role_name"
			resourceName="UserJdbcDatabase" />
3. Ejecutar en BD el siguiente script de BD:
	create table users (
	  user_name         varchar(15) not null primary key,
	  user_pass         varchar(15) not null
	);
	
	create table user_roles (
	  user_name         varchar(15) not null,
	  role_name         varchar(15) not null,
	  primary key (user_name, role_name)
	);
	
	INSERT INTO users(user_name, user_pass) VALUES('admin', 'admin');
	INSERT INTO user_roles VALUES('admin', 'ADMIN');