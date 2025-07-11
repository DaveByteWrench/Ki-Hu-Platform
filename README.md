# Ki-Hu Platform

<p align="center">
    <img src="./img/Ki-Hu_logo.png" alt="Ki-Hu Logo" width="240" height="240">
</p>

This is the main service of the Hub Kit Platform and exposes the API to interact with the rest of the devices.

## Getting started

To run the application you need to specify the following environment variables:
* `SERVER_PORT`: this is *optional* parameter and specifies a different port from the default one where to expose the APIs
* `DATABASE_USERNAME`: *required* parameter where to specify the database's username
* `DATABASE_PASSWORD`:  *required* parameter where to specify the database's password
* `DATABASE_HOSTNAME`:  *required* parameter where to specify the database's hostname
* `DATABASE_PORT`:  *required* parameter where to specify the database's port
* `DATABASE_NAME`:  *required* parameter where to specify the database's name where create all schemas
* `KAFKA_BOOTSTRAP_SERVERS`:  *required* parameter where to specify the kafka hosts to exchange data between other microservices
* `HUB_NAME`: *required* the hub to initialize in the first run
* `WEBSOCKET_BROKER_URL`: *required* the full url to the MQTT broker used to dispatch realtime data to the mobile app
* `PRINCIPAL_USERNAME`: *required*, specify the platform's principal username
* `PRINCIPAL_PASSWORD`: *required*, specify the platform's principal password

You can specify the environment varibales using a `.env` file or injecting them in the container directly.

## Infrastructure clarification

ToDo

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/hub-kit-platform-red-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

## Related Guides

- REST ([guide](https://quarkus.io/guides/rest)): A Jakarta REST implementation utilizing build time processing and Vert.x. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it.
- Flyway ([guide](https://quarkus.io/guides/flyway)): Handle your database schema migrations
- Hibernate Validator ([guide](https://quarkus.io/guides/validation)): Validate object properties (field, getter) and method parameters for your beans (REST, CDI, Jakarta Persistence)
- SmallRye OpenAPI ([guide](https://quarkus.io/guides/openapi-swaggerui)): Document your REST APIs with OpenAPI - comes with Swagger UI
- Hibernate ORM with Panache ([guide](https://quarkus.io/guides/hibernate-orm-panache)): Simplify your persistence code for Hibernate ORM via the active record or the repository pattern
- JDBC Driver - PostgreSQL ([guide](https://quarkus.io/guides/datasource)): Connect to the PostgreSQL database via JDBC
