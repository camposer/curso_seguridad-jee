Para ejecutar este proyecto debe agregar al fichero tomcat-users.xml local o global -al menos- los siguientes roles y usuarios:
	<role rolename="ADMIN"/>
	<role rolename="ORD"/>
	<user password="admin" roles="ADMIN" username="admin"/>

Utiliza el realm por defecto de tomcat: UserDatabase