<p align="center">
  <img src="https://cdn-icons-png.flaticon.com/512/6295/6295417.png" width="100" />
</p>
<p align="center">
    <h1 align="center">FILTRO FINAL CAMPUSLANDS</h1>
</p>
<p align="center">
    <em>Filtro final a cargo de Cristian Camilo Pardo Hernandez</em>
</p>
<p align="center">
    <em>Welcome to Filtro final Campuslands, A proyect developted in CampusLands</em>
</p>
<p align="center">
		<em>Herramientas usadas en este repositorio mas abajo.</em>
</p>
<p align="center">
	<img src="https://img.shields.io/badge/Spring-000000.svg?style=flat&logo=Spring&logoColor=white" alt="Spring">
	<img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=flat&logo=openjdk&logoColor=white" alt="java">

</p>
<hr>


## 🔗 Indice

> - [📍 Acerca de](#-Acerca-de)
> - [📦 Features](#-features)
> - [📂 Estructura del Repositorio](#-estructuraDelRepositorio)
> - [🖊️ Diseño Base De Datos](#-DiseñoDeBD)
> - [🔏 Autentication y Seguridad](#-AutenticacionYSeguridad)
> - [🚀 Instalacion del Proyecto](#-Autenticacion-Proyecto)
>   - [⚙️ Instalacion](#️-installation)
>   - [🤖 Ejecucion Filtro Final](#-EjecucionFiltroFinal)
>   - [🧪 Tests](#-tests)
> - [🤝 Contribucion](#-contributing)
> - [📄 Licencia](#-license)


---

##  📍 Acerca de 

Este proyecto fue desarrollado por `Christian Camilo Pardo Hernandez`, a partir del enunciado propuesto en el documento de Drive donde se debia crear una aplicacion en `SpringBoot` con `Java` para la gestion de listas de contenidos audiovisuales de un usuario

---

##  📦 Features

## Configuracion a conexion MySQL
- **Database URL:** jdbc:mysql://localhost:3306/filtro
- **Database Username:** campus2023
- **Database Password:** campus2023
- **Database Driver:** com.mysql.cj.jdbc.Driver

## Configuración especifica de Hibernate
- **Hibernate Auto DDL:** update
- **Show Hibernate SQL:** true
- **Hibernate Dialect:** org.hibernate.dialect.MySQL8Dialect
- **Hibernate SQL Logging Level:** debug

## Configuración de Springdoc y Swagger
- **Enable API Documentation Generation:** true
- **Enable Swagger UI:** true
- **Path to access Swagger UI:** /doc/swagger-ui.html
- **Packages to Scan for SpringDoc Classes:** com.example.FiltroFinal.web.controller

---


##  📂 Estructura del Repositorio

```sh
└── FiltroFinalCampuslands/
    ├── HELP.md
    ├── mvnw
    ├── mvnw.cmd
    ├── pom.xml
    ├── src
    │   ├── main
    │   │   ├── java
    │   │   │   └── com
    │   │   │       └── example
    │   │   └── resources
    │   │       ├── DbImage.png
    │   │       ├── application.properties
    │   │       ├── banner.txt
    │   │       └── chimba.sql
    │   └── test
    │       └── java
    │           └── com
    │               └── example
    └── target
        ├── classes
        │   ├── DbImage.png
        │   ├── application.properties
        │   ├── banner.txt
        │   ├── chimba.sql
        │   └── com
        │       └── example
        │           └── FiltroFinal
        └── test-classes
            └── com
                └── example
                    └── FiltroFinal
```

---
## 🖊️ Diseño Base De Datos

El diseño creado para esta base de datos fue el siguiente:

![DiseñoBaseDeDatos](/src/main/resources/DbImage.png)

---

## 🔏 Autentication y Seguridad

Para la autenticacion y seguridad de esta aplicación fue usado Json Web Token (JWT).

- Para obtener el token de manera segura seguiremos los siguientes pasos:

    1. Usaremos un cliente de consumo de API (ThunderClient, PostMan, Insomnia).
        
        ![INSOMNIA](/src/main/resources/INSOMNIA.png)


    2. Escribiremos nuestro usuario y contraseña para registrarnos (Si la respuesta es 200, fue correcto el registro).

        ![INSOMNIA](/src/main/resources/registro.png)



---

##  Getting Started

***Requirements***

Ensure you have the following dependencies installed on your system:

* **Java**: `version 17`

###  Installation

1. Clone the FiltroFinalCampuslands repository:

```sh
git clone https://github.com/KazeVentum/FiltroFinalCampuslands.git
```

2. Change to the project directory:

```sh
cd FiltroFinalCampuslands
```

3. Install the dependencies:

```sh
mvn clean install
```

###  Running FiltroFinalCampuslands

Use the following command to run FiltroFinalCampuslands:

```sh
java -jar target/myapp.jar
```

###  Tests

To execute tests, run:

```sh
mvn test
```

---

##  Project Roadmap

- [X] `► INSERT-TASK-1`
- [ ] `► INSERT-TASK-2`
- [ ] `► ...`

---

##  Contributing

Contributions are welcome! Here are several ways you can contribute:

- **[Submit Pull Requests](https://github.com/KazeVentum/FiltroFinalCampuslands.git/blob/main/CONTRIBUTING.md)**: Review open PRs, and submit your own PRs.
- **[Join the Discussions](https://github.com/KazeVentum/FiltroFinalCampuslands.git/discussions)**: Share your insights, provide feedback, or ask questions.
- **[Report Issues](https://github.com/KazeVentum/FiltroFinalCampuslands.git/issues)**: Submit bugs found or log feature requests for Filtrofinalcampuslands.

<details closed>
    <summary>Contributing Guidelines</summary>

1. **Fork the Repository**: Start by forking the project repository to your GitHub account.
2. **Clone Locally**: Clone the forked repository to your local machine using a Git client.
   ```sh
   git clone https://github.com/KazeVentum/FiltroFinalCampuslands.git
   ```
3. **Create a New Branch**: Always work on a new branch, giving it a descriptive name.
   ```sh
   git checkout -b new-feature-x
   ```
4. **Make Your Changes**: Develop and test your changes locally.
5. **Commit Your Changes**: Commit with a clear message describing your updates.
   ```sh
   git commit -m 'Implemented new feature x.'
   ```
6. **Push to GitHub**: Push the changes to your forked repository.
   ```sh
   git push origin new-feature-x
   ```
7. **Submit a Pull Request**: Create a PR against the original project repository. Clearly describe the changes and their motivations.

Once your PR is reviewed and approved, it will be merged into the main branch.

</details>

---

##  License

This project is protected under the [SELECT-A-LICENSE](https://choosealicense.com/licenses) License. For more details, refer to the [LICENSE](https://choosealicense.com/licenses/) file.

---

##  Acknowledgments

- List any resources, contributors, inspiration, etc. here.

[**Return**](#-quick-links)

---
