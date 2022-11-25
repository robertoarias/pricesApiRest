****************
* Environment: *
****************
- Java version: 1.8
- Maven version: 3.5.0
- Spring Boot version: 2.2.1.RELEASE


******************
* Funcionamiento *
******************
El WS REST debe exponer dos endpoints, a saber:

	- GET request - `/getTemperatura`:   PUEDE EJECUTARLO UN USUARIO CON ROL "ADMIN" O "USER"
		* http response = 200. La solicitud fue exitosa. Se devuelve un campo "responseCode" igual a cero. Un campo "responsestatusText" con la palabra "Success". Un campo "temperature" con el valor de la temperatura actual en grados Celsius (solo disponible para la ciduad de Cordoba)
		Ejemplo:
				{
				  "responseCode": 0,
				  "responsestatusText": "Success",
				  "temperature": 26.74002
				}


	- GET request - `/getCajasBirras`:  SOLO PUEDE EJECUTARLO UN USUARIO CON ROL "ADMIN"
		* http response = 200. La solicitud fue exitosa. Se devuelve un campo "responseCode" igual a cero. Un campo "responsestatusText" con la palabra "Success". Un campo "countBox" con el valor de la cantidad de cajas (en packs de 6), a comprar.
		Ejemplo:
				{
				  "responseCode": 0,
				  "responsestatusText": "Success",
				  "countBox": 20
				}

*********************
* Datos de Usuarios *
*********************
El WS trabaja con una base de datos H2 en memoria.
Al iniciar la aplicacion se crea la tabla:
	USER_TABLE
		user_id INT
		user_name VARCHAR(250)
		role VARCHAR(100)

con los siguientes datos iniciales:
	Registro 1:
		user_id = 1
		user_name = Pepe
		role = ADMIN
		
	Registro 2:
		user_id = 2
		user_name = Tito
		role = USER


********
* Mock *
********
Se puede configurar un Mock mediante la variable "usemock" en el archivo application.properties:
	usemock=false -> utilizara los datos almacenados en la base de datos para autenticar el rol del usuario logeado
	usemock=true  -> simulara los usuarios y sus roles (de la misma manera que en la BD), sin acceder a la misma.

Por defecto, esta configurado como usemock=false.


***************
* Compilacion *
***************
Para compilar el WS, ejecutar ls siguiente linea de comando:
	mvn clean install

		
*************
* Ejecucion *
*************
El WS Rest corre como StandaAlone.
Linea de comando a ejecutar:
	java -jar Santander_birras-1.0.jar
	
Se ejecuta sobre el puerto 8888 y en el contextPath "/santander"
	
********
* URLS *
********
- http://localhost:8888/santander/getTemperatura?user=nn   --> reemplazar localhost por el nombre del server correspondiente.
	Parametro:
		- user : nombre de usuario (Pepe / Tito) Obligatorio
	Ejemplo:
		http://localhost:8888/santander/getTemperatura?user=Tito

- http://localhost:8888/santander/getCajasBirras?user=nn&countPersons='cantidad'&extraPercent=x
	Parametro:
		- user : nombre de usuario (Pepe / Tito) Obligatorio
		- countPersons : cantidd de personas que asistiran. Obligatorio
		- extraPercent : porcentaje en valor entero que indica un % extra a sumar a la cantidad de cajas calculadas. Opcional.
		
- Swagger:
	http://localhost:8888/santander/swagger-ui.html
	


