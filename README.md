# Taller Final Ecosistemas de aplicaciones - Julián David Correa Gutiérrez - Luis vivas otalvaro


# Aplicaciones de eclipse (PYC profesores - PYC estudiantes)
# Aplicaciones en Eclipse
## Clase Main
### Esta clase presenta los métodos principales para la ejecución del programa

Metodos:
**settings()**
Controla el tamaño de la pantalla
**setup()**
Presenta las acciones que solo se ejecutan una vez
**draw()**
Se ejecuta varias veces para pintar las figuras en la interfaz
**mousePressed()**
Presenta las acciones cuando el un boton del mouse está siendo presionado
**mouseDragged()**
Presenta las acciones cuando el un boton del mouse está siendo presionado 
y el cursor se está moviendo
**mouseClicked()**
Presenta las acciones cuando se ha hecho click
**keyPressed()**
Presenta las acciones cuando se usa el teclado

## Clase Logica
### Esta clase presenta métodos que hacen referencia a la lógica principal del proyecto, aquí es donde se hacen los procesos de pintar.

Metodos:
**pintar()**
Pinta los elementos principales en la aplicacion(El inicio de sesión y el menú principal)
**pintarOpciones()**
Pinta los elementos que surgen de un menú de botones en especifico
**mouse()**
Se ejecuta las veces que se interactúe con el mouse
**clickMan()**
Se ejecuta cuando se hace click es sostenido

## Clase Comunicacion
### Esta clase presenta métodos que permiten el envió y recepción de información de otras aplicaciones de eclipse o android

Metodos:
**recibir()**
permite recibir un paquete de datos y transformarlo a String
**enviar()**
Permite transformar un String a un paquete de datos y enviarlo por el socket

# Aplicacion en Android
## MainActivity
### Esta clase representa el login y la primer pantalla de la aplicación vista por el usuario.

Metodos:
**onCreate()**
Inicializa las variables y layouts de la aplicación.
**logearUsuario()**
Este metodo se encarga de recibir los Strings de e-mail y contraseña de los usuario, hace una validación con la base de datos en firebase y permite o rechaza el inicio de sesión.
**onClick()**
Se encarga de enviar la información obtenida en **logearUsuario()** a la base de datos en Firebase.
