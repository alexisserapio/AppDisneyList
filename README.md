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
- Observamos el icono de la app.
- Al iniciar la aplicación, observamos el siguiente menú donde podremos seleccionar cualquiera de las dos opciones disponibles entre leer un código QR o crear una vCard.
<img src="https://github.com/alexisserapio/AppQR/blob/master/images/1.png" alt="Captura de Pantalla sobre la app en el móvil y su interfaz principal" width="450" height="330">
