# autor: Lizeth Rios Epalza
# language: es
  @registro
  @regresion
  Característica: Registro de usuario

    Antecedentes:
      Dado que usuario y quiere registrarse en Automation Practice

    @rutaCritica
    Escenario: Registro valido de usuarios
      Cuando diligencia el formulario de registro
      | Titulo  | Nombres    | Apellidos        | Correo Electronico | Contrasena |  Fecha Cumpleanio | Compania | Direccion      | Segunda Direccion | Ciudad   | Estado   | Codigo Postal | Pais          | Informacion Adicional | Telefono Fijo | Telefono Celular | Nombre Direccion |
      | Mr     | Juan Pablo | Rodriguez Garcia | jp3@pragma.com      | jp123456   | 20/01/1996        | Pragma   | Cra 6 # 1 - 12 | Cra 6A # 2 - 12   | Medellín | Virginia | 00000         | United States | a                     | 0341234567    | 3000000000       | Casa             |
      Entonces deberia ver el nombre de usuario Juan Pablo Rodriguez Garcia