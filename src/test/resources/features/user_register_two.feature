# autor: Lizeth Rios Epalza
# language: es
  @registro2
  @regresion
  Característica: Registro de usuario

    Antecedentes:
      Dado que usuario y quiere registrarse en Automation Practice

    @rutaCritica
    Escenario: Registro valido de usuarios
      Cuando diligencia el formulario de registro con una hoja de calculo
      Entonces deberia ver el nombre de usuario Juan Pablo Rodriguez Garcia