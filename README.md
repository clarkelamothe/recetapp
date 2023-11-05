# RecetApp

RecetApp es una app que permite ver una lista de recetas con foto y nombre, detalle de recetas con
foto nombre y lista de ingredientes y se puede ver la localizacion de origen de la receta.

### Arquitectura

Este proyecto implementa CLEAN arquitectura, separado por funcionalidades y capas. Aplica los
principios SOLID.
Y con una arquitectura MVI + VM + Repository.

#### Funcionalidades

- **Core** _(nucleo del proyecto, contiene los modelos que necesita la app y las dependencias)_
    - data
        - model
    - di
        - modules
    - ui


- **Detail** _(funcionalidad del detalle de una receta)_
    - presentation
        - model
        - view
        - viewmodel
        - adapter

- **Location** _(funcionalidad del lugar de origen de una receta)_
    - presentation


- **Recipe** _(funcionalidad de la lista receta)_
    - data
        - dto
        - remote
    - domain
        - model
        - usecase
    - presentation
        - model
        - view
        - viewmodel
        - utils

Algunas funcionalidades no incluyen algunas capas ya que solo en la pantalla de entrada (recipe) se
hace la peticion a la api y pasa la data correspondiente a la siguiente pantalla. Se puede agregar
las otras capas a medida que surgen otros requerimientos.

## Librerias

- [Kotlin](https://kotlinlang.org/) - lenguaje recomendado por Google para el desarrollo de app en
  android.
- [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) - para el manejo de tareas asincronas.
- [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/) -
  para mandar flujos de datos
- [Koin DSL](https://insert-koin.io/docs/reference/koin-core/dsl/) - for dependency injection.
- [Retrofit2](https://github.com/square/retrofit) - para comunicacion con api.
- [OkHttp](http://square.github.io/okhttp/) - cliente http
- [Gson](https://github.com/square/retrofit/tree/master/retrofit-converters/gson) - convierte los
  json a objetos de java
- [Glide](https://bumptech.github.io/glide/) - libreria de cache de imagenes.

- Test
    - [Mockk](https://github.com/mockk/mockk) - facilita la creacion de mocks para test.
    - [jUnit5](https://junit.org/junit5/docs/current/user-guide/) - para los test unitarios.
    - [turbine](https://github.com/cashapp/turbine) - facilita los test de flows.
    - [assertK](https://github.com/willowtreeapps/assertk) - libreria de aserciones fluida para
      Kotlin.

## Variables

Agregar en la carpeta _local.properties_ una key para google maps

**MAPS_API_KEY=**

