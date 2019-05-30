# Taller Final Ecosistemas de aplicaciones - Juli�n David Correa Guti�rrez - Luis vivas otalvaro


# Aplicaciones de eclipse (PYC profesores - PYC estudiantes)
# Aplicaciones en Eclipse
## Clase Main
### Esta clase presenta los m�todos principales para la ejecuci�n del programa

Metodos:
**settings()**
Controla el tama�o de la pantalla
**setup()**
Presenta las acciones que solo se ejecutan una vez
**draw()**
Se ejecuta varias veces para pintar las figuras en la interfaz
**mousePressed()**
Presenta las acciones cuando el un boton del mouse est� siendo presionado
**mouseDragged()**
Presenta las acciones cuando el un boton del mouse est� siendo presionado 
y el cursor se est� moviendo
**mouseClicked()**
Presenta las acciones cuando se ha hecho click
**keyPressed()**
Presenta las acciones cuando se usa el teclado

## Clase Logica
### Esta clase presenta m�todos que hacen referencia a la l�gica principal del proyecto, aqu� es donde se hacen los procesos de pintar.

Metodos:
**pintar()**
Pinta los elementos principales en la aplicacion(El inicio de sesi�n y el men� principal)
**pintarOpciones()**
Pinta los elementos que surgen de un men� de botones en especifico
**mouse()**
Se ejecuta las veces que se interact�e con el mouse
**clickMan()**
Se ejecuta cuando se hace click es sostenido

## Clase Comunicacion
### Esta clase presenta m�todos que permiten el envi� y recepci�n de informaci�n de otras aplicaciones de eclipse o android

Metodos:
**recibir()**
permite recibir un paquete de datos y transformarlo a String
**enviar()**
Permite transformar un String a un paquete de datos y enviarlo por el socket

# Aplicacion en Android
## MainActivity
### Esta clase representa el login y la primer pantalla de la aplicaci�n vista por el usuario.

Metodos:
**onCreate()**
Inicializa las variables y layouts de la aplicaci�n.
**logearUsuario()**
Este metodo se encarga de recibir los Strings de e-mail y contrase�a de los usuario, hace una validaci�n con la base de datos en firebase y permite o rechaza el inicio de sesi�n.
**onClick()**
Se encarga de enviar la informaci�n obtenida en **logearUsuario()** a la base de datos en Firebase.
