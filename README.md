# 🏰 App DisneyList

#### App que despliega un listado de personajes de la franquicia de Disney realizando consumo de APIs.
## Introducción
Esta app desarrollada en lenguaje Kotlin cuenta con las siguientes caracteristicas: 
- Despliega un catálogo de todos los personajes de la franquicia Disney.
- Al dar click en cualquier elemento, se nos mostrará información más detallada del personaje, como un listado de peliculas en las que ha aparecido.
- Se obtiene la información realizando peticiones a un API REST público llamado "Disney API", puedes consultar su documentación aquí:  [Disney API Documentation](https://disneyapi.dev/docs/)
- La app tiene soporte de errores como pérdida de conexión de internet ya sea intencional o no, de igual manera se realiza el manejo de permisos de la aplicación para poder acceder a la red.

## 💻 Tech Stack
- Para desarrollar el proyecto se utilizó **Android Studio** para programar la aplicación como nativa para android.
- Se implementó **Gson** y **Retrofit** para manejar el texto obtenido a través de la API.
- Se hizo uso de **Glide** para realizar la carga de las imagenes a través de una unica URL.
- Se aplicó el patrón de diseño MVVM a lo largo del desarrollo del proyecto.
- Uso de **Fragments** para la UI y **RecyclerView** para poder desplazarse a través de los elementos.
- En el proceso de desarrollo se implemento control de versionamiento utilizando **Git** y manejo de repositorios en **Github**.

## 📲 In-app
- Observamos el icono en el laucher de la app.
- Al iniciar la aplicación, observamos un widget de carga mientras se realiza la conexión a internet y se procesa la petición del API.
<img src="https://github.com/alexisserapio/AppDisneyList/blob/master/src/1.png" alt="Captura de Pantalla sobre el icono del móvil" width="175" height="350">
<img src="https://github.com/alexisserapio/AppDisneyList/blob/master/src/2.png" alt="Captura de Pantalla sobre el widget de carga" width="175" height="350">

---
- Una vez se obtiene una respuesta positiva para ambas peticiones, observamos el despliegue de personajes.
- Al dar clic en cualquier elemento de la lista, se puede observar que contienen la información de las peliculas en las que ha aparecido dicho personaje.
<img src="https://github.com/alexisserapio/AppDisneyList/blob/master/src/3.png" alt="Pantalla principal de la aplicación" width="175" height="350">
<img src="https://github.com/alexisserapio/AppDisneyList/blob/master/src/4.png" alt="Despliegue del detalle de los elementos" width="175" height="350">

---
- Si se pierde la conexión o el usuario interrumpe los permisos para conectarse a internet, se lanza un Toast para dar aviso. Se tiene el manejo de errores y se puede volver a intentar.
<img src="https://github.com/alexisserapio/AppDisneyList/blob/master/src/5.png" alt="Pantalla de error para reintentar" width="175" height="350">

## 📣 To-do
- Se podrían realizar pruebas de conexión a API con respuestas GET, POST, PUT y DELETE.
- Se podría implementar un sistema de filtros para mejorar la interactividad de la apliación.
- Realizar el mismo trabajo con Jetpack Compose.
