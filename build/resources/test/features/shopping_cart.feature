# autor: Lizeth Rios Epalza
# language: es
  @carritoCompras
  @regresion
  Característica: Carrito de compras

    Antecedentes:
      Dado que usuario x quiere realizar una compra en Automation Practice

   @rutaCritica
   Escenario: Compra de productos desde el home
      Cuando agrega el producto Blouse al carrito de compras desde el home
      Entonces deberia ver la pantalla de agregado exitoso

   @rutaCritica
   @Ignore
   Escenario: Compra de productos desde vista rapida
      Cuando agrega el producto al carrito de compras desde la vista rapida
        | Producto              | Cantidad | Talla | Color  |
        | Printed Summer Dress  | 3        | L     | Black  |
      Entonces deberia ver la pantalla de agregado exitoso

   @rutaCritica
   @Ignore
   Escenario: Compra de productos desde los resultados
      Cuando agrega el producto al carrito de compras desde la interna
        | Producto              | Cantidad | Talla | Color  |
        | Printed Chiffon Dress | 2        | S     | Green  |
      Entonces deberia ver la pantalla de agregado exitoso

