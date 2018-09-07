# MyMovies - Kotlin

 
 
Para el desarrollo de esta aplicacion Android, se aplico el patron MVP con lenguaje Kotlin. 
Basicamente consiste en 3 listados de peliculas (TOP, POPULAR, UNCOMING) que se obtienen de los servicios directamente, estos trabajan con 
una cache lo cual nos permite que podamos seguir trabajando tranto de manera online como offline. 
La otra seccion destacada de la aplicacion es un buscador offline de peliculas. Las consultas son realizadas directamente sobre 
la BD, que se va cargando ni bien arranca la aplicacion. En la seccion `Improvement`, se comentan algunas mejoras asociadas a estas 
secciones que no se logro a agregar por cuestiones de tiempo pero serian muy validas aplicarlas. 

## Capa de Persistencia:
   Capa encargada manejar el almacenamiento y consulta de la Base de Datos. Se utilizo la libreria Realm.
   
    Clases Involucradas:
      1. `MovieEntity`: Representa la tabla pelicula.
      2. `MovieRepository`: Interface que define comportamiento de la capa de presistencia.
      3. `MovieRepositoryImpl`: Implementacion de la interface ``MovieRepository``.
      
      
## Capa de Servicios o Red:
   Capa encargada manejar la comunicacion con el API solicitada. Se utilizo la libreria Retrofit, con manejo de cache.
    
    Clases Involucradas:
      1. `GenreResponse`, `GetDetailMovieResponse`, `GetMoviesResponse`, `MovieResponse`, `ProductionCompaniesResponse`, `VideoResponse`,
       `VideosResponse` : Objetos POJO usados para el mapeo de las respuestas de los servicios del API 
      2. `MovieService`: Interface que define las llamadas a los servicios del API
      3. `MovieServiceImpl`: Implementacion de la interface ``MovieService``
      4. `MoveApi`: Define los endpoints de los servicios a llamar
      4. `ServiceUtils`: Clase utilitaria para realizar las llamadas a los servicios y configurar la cache
      
## Capa de Vista:
   Capa encargada de todo el manejo UI de la aplicacion
   
    Clases Involucradas:
      1. `DetailMovieActivity`: Esta Activity representa la pantalla de detalle de una pelicula. 
      2. `HomeActivity`: Representa la pantalla principal de la applicacion.
      3. `SearchFragment`: Representa la pantalla de busqueda Offline.  
      4. `MoviesFragment`: Representa la pantalla de listado de peliculas segun el tipo. Es re-utilizado para los tres tipos de peliculas 
      (TOP, POPULAR, UNCOMING)
      5. `ActivityView`: Clase base utilizada para las vistas del patron MVP asociado a una Activity
      6. `FragmentView`: Clase base utilizada para las vistas del patron MVP asociado a una Fragment
      7. `HomeView`, `MoviesView`, `SearchView`: Representan las vistas del patron MVP. Manejan todo lo asociado a la UI de una pantalla


## Capa de Logica:
   Capa encargada de todo el manejo de logica de la aplicacion
   
    Clases Involucradas:
      1. `DetailMoviePresenter`, `HomePresenter`, `MoviesPresenter`, `SearchPresenter`: Representan los presentadores del patron MVP. 
      Manejan todo lo asociado a la logica de una pantalla, son los encargados de coordinar las tareas de la vista y el modelo.
      1. `DetailMovieModel`, `HomeModel`, `MoviesModel`, `SearchModel`: Representan los modelos del patron MVP. 
      Manejan todo lo asociado a la informacion y comunicacion con servicios y repositorios
   

## Extras:
   
    Clases Involucradas:
    1. `RxBus`: Clase utilitaria para subscribirse y enviar eventos asyncronicos
    2. `DownloadMoviesManager`: Maneja la descarga de las peliculas, que luego seran usadas por el buscador offline.
    3. `MovieMapper`: Clase utilitaria para el mappeo entre objetos (entidades, response, domain)
    4. `MoviesApp`: Representa la clase aplicacion custom
    5. `TypeOfMovieEnum`: Enumeracion que representa los tipos de peliculas disponibles (TOP, POPULAR, UNCOMING)


## Improvements:
   Esta seccion es de mejoras que no se llegaron a aplicar por temas de tiempo, pero considero que serian utiles a la aplicacion. 
   
   1. `Listas de peliculas (sin buscador)`: Deberian usar un LoaderManager que este escuchando la DB, para ir actualizandola. 
     Actualmente solo se usa la coneccion de  servicios, con una cache para poder usar las listas en caso de no tener internet.
   2. `Listas de peliculas (sin buscador)`: Uso de un PullToRefresh, para refrescar las pantallas.
   3. `Iconos`: Agregar en el navigatorView y definir uno para el logo de la aplicacion.
      


1. En qué consiste el principio de responsabilidad única? Cuál es su propósito? 
 El principio de `responsabilidad unica` asociado a la POO, es la idea de que una clase se encargue de una unica tarea, y que no este 
 espacida en varios lugares. Con esto logramos que la clase tenga cohesion alta, lo que nos da mantenibilidad, y nos permite la 
 reutilizacion.
 
2. Qué características tiene, según su opinión, un “buen” código o código limpio?
 El codigo limpio esta asociado, desde mi punto de vista, a la estructuracion de como se planteo la logica y la legibilidad de la misma. 
 El uso de buenas practicas de programacion, y la coordinacion del code style aplicado que nos asegure la eliminacion de por ejemplo 
 malos tipeos, espacios excecivos y bloques de codigo desordenados.