## Minimal Java project which can be deployed on Heroku

note:
be aware of Heroku env variables:
- `DATABASE_URL` looks like `postgres:...`  
- `JDBC_DATABASE_URL` looks like `jdbc:postgresql:...`

### Pay your attention to

- `Procfile` contents:
  - fully qualified path to the `main class`
  - `classpath` declaration
- `pom.xml` sections:
  - `<packaging>jar`
  - `<pluginns>maven-dependency-plugin...`
- Http Server must start on the port, provided by Heroku's system environment variable `PORT`
  - file `MinimalWebApplication.java`
  - method `main`

### Links

- Heroku official documentation in general: [here](https://devcenter.heroku.com/articles/getting-started-with-java)
- Heroku official documentation about JDBC connection: [here](https://devcenter.heroku.com/articles/connecting-to-relational-databases-on-heroku-with-java)
- Heroku official github code: [here](https://github.com/heroku/java-getting-started)
- Baeldung link how to create runnable `jar` file: [here](https://www.baeldung.com/executable-jar-with-maven)
