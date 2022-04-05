# autor: Lizeth Rios Epalza
# language: es
  @login
  @regresion
  Característica: Inicio de sesión

    Antecedentes:
      Dado que usuario x quiere iniciar sesion en Automation Practice

    @rutaCritica
    Escenario: Iniciar sesión con credenciales validas
      Cuando ingresa sus credenciales epalza_14@hotmail.com y 987654321
      Entonces deberia ver el nombre de usuario Ana perez rodriguez

    @rutaCritica
    Escenario: Iniciar sesión con credenciales invalidas
      Cuando ingresa sus credenciales lizeth.rios@pragma.com.co y 123456789
      Entonces deberia ver la alerta con el mensaje Authentication failed.

    @rutaAlterna
    Escenario: Campo correo electrónico vacío
      Cuando ingresa su contrasena 123456789
      Entonces deberia ver la alerta con el mensaje An email address required.

    @rutaAlterna
    Escenario: Campo contraseña vacío
      Cuando ingresa su correo electronico lizeth.rios@pragma.com.co
      Entonces deberia ver la alerta con el mensaje Password is required.
