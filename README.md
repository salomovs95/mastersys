# MASTER.SYS
### Um gerenciador de academia

<div align="center">
  <br />
  <a href="#" target="_blank">
    <img width="1248" height="720" src="" alt="Project Banner">
  </a>
  <br />
  <br />
  <div>
    <img src="https://img.shields.io/badge/Spring%20Boot-6DB33F.svg?style=for-the-badge&logo=Spring-Boot&logoColor=white" alt="SpringBoot" />
    <img src="https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white" alt="Apache Maven" />
  </div>
  <br/>
  <br/>
 
  <h1 align="center">MasterSYS</h1>

  <div align="center">
    The most powerfull GYM management system that's ever lived
  </div>
</div>

## 📋 <a name="table">Sumary</a>

1. 🚀 [Introduction](#introduction)
2. ⚙️ [Tech Stack](#tech-stack)
3. 🔋 [Features](#features)
4. 💻 [Quick Start](#quick-start)
5. 💾 [Environment Variables](#envs)
6. 📅 [Versions](#versions)
7. 🤝 [Contributing](#contributing)
8. 👥 [Authors](#authors)

## <a name="introduction">🚀 Introduction</a>

Strugling managing a Gym? Handling memberships feels harder than  necessary?
Fear no more, MasterSYS to the rescue!

## <a name="tech-stack">🚀 Tech Stack</a>

- [x] Spring Boot
- [x] H2 database (in memmory db, PostgreSQL soon)
- [x] JPA Hibernate
- [ ] Docker support

## <a name="features">🚀 Features</a>

_**Currently available:**_
- [x] Students registry
- [x] Modaltiy/Plans/Revistrations system
- [x] Operational Reports generation
- [x] Api Documentation (Swagger/OpenAPI/Springdoc)

_**Future relases**_
- [ ] Easy to get up and running
- [ ] Astouning web pannel
- [ ] NF/Invoices emmiting

## <a name="quick-start">🚀 Quick Start</a>

> [!WARNING]
> Ensure at least Java 25 or newer is inatalled.

> [!NOTE]
> One can use Maven installed globally, but it's not mandatory.

> [!NOTE]
> API Dcoumentation is running at `http://localhost:8080/swagger-ui.html` while under `dev` profile.

- [ ] Clone this repo.
- [ ] To rhn this application locally, on a terminal, open the `mastersys` folder and run `./mvnw spring-boot:run` or simply `mvn spring-boot:run`.
- [ ] Alternaltivelly, one can run the tests using `./mvnw test` or simply `mvn test` on a terminal.


## <a name="envs">🚀 Environment Variables</a>

- PROFILE     - Tells in which environment is running: development(dev) or production(prod). Defaults to `dev` if none value is provided.
- DB_URL*      - Database's connection URL.
- DB_USERNAME* - User that has rights to the database.
- DB_URL*      - User credential to access the database.

> [!WARNING]
> * = Variable necessary only if in `production` environment

## <a name="contributing">🚀 Contributing</a>

Contributions, issues, and feature requests are welcome!

1. Fork it (<https://github.com/salomovs95/mastersys>)
2. Create your feature branch (`git switch -c feature/fooBar`)
3. Add your changes to the stage (`git add CHANGEDFILES`)
4. Commit your changes (`git commit -m 'Add some fooBar'`)
5. Push to the branch (`git push origin feature/fooBar`)
6. Create a new PR (Pull Request)

> [!WARNING]
> PR that isn't tested shall not be accepted!

## <a name="authors">🚀 Authors</a>

<table style="border-collapse: collapse; table-layout: auto text-align: left;">

  <tbody>
    <tr>
      <td style="padding: 10px; border: 1px solid #ddd;">
        <img src="https://avatars.githubusercontent.com/u/170432574?v=4" width="60" style="border-radius: 50%; display: block; margin: 0 auto;">
      </td>
      <td style="padding: 10px; border: 1px solid #ddd;">Salomao Souza</td>
      <td style="padding: 10px; border: 1px solid #ddd;">
        <a href="https://linkedin.com/in/salomovs95" target="_blank">LinkedIn</a> |
        <a href="https://github.com/salomovs95" target="_blank">GitHub</a>
      </td>
    </tr>
  </tbody>
</table>
