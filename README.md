## Java project which can be deployed on Heroku

### Local project location

- [servlet1](http://localhost:5000/hello) (`HelloServlet.Get` message)
- [servlet2a](http://localhost:5000/student) (no params, all students from the Db)
- [servlet2b](http://localhost:5000/student?x=1) (param `x=1` given, userById run)

### Remote project location

- [servlet1](https://young-garden-08016.herokuapp.com/hello) (`HelloServlet.Get` message)
- [servlet2a](https://young-garden-08016.herokuapp.com/student) (no params, all students from the Db)
- [servlet2b](https://young-garden-08016.herokuapp.com/student?x=1) (param `x=1` given, userById run)

### Heroku step-by-step instruction

- install heroku cli [link](https://devcenter.heroku.com/articles/heroku-cli)
- create and upload ssh keys [link](https://devcenter.heroku.com/articles/keys)
- check whether everything is ok (locally): `mvn clean install && heroku local web`
- to login to heroku server, run in the command line `heroku login` (browser will be opened for further authorization)
- to create a new app on heroku server, run in the command line `heroku create`, output should look like this: 
```
Creating app... done, ⬢ young-garden-08016
https://young-garden-08016.herokuapp.com/ | https://git.heroku.com/young-garden-08016.git
```
- look for the git remotes: `git remote -v`, output should look like this:
```
heroku  https://git.heroku.com/young-garden-08016.git (fetch)
heroku  https://git.heroku.com/young-garden-08016.git (push)
origin  https://github.com/alexr007/java-heroku-from-zero-to-hero.git (fetch)
origin  https://github.com/alexr007/java-heroku-from-zero-to-hero.git (push)
```
- push your code to heroku `git push heroku master`

### Adding heroku database:

- go to heroku dashboard
- click `young-garden-08016` (your app name)
- click `Resources` 
- in the add-ons type: `Postgres`
- click `Heroku Postgres`
- click `Provision`
- click `Heroku Postgres` in the list below
- go to `Settings`, look for `Credentials` (you can use them in your DataGrip)

#### Useful heroku command:

- `heroku ps`
- `heroku open`
- `heroku ps:scale web=1`
- `heroku logs --tail`

#### Pay your attention to

- `Procfile` contents:
  - fully-qualified path to the `main class`
  - `classpath` declaration
- `pom.xml` sections:
  - `<packaging>jar`
  - `<pluginns>maven-dependency-plugin...`

#### Note: be aware of  Heroku env variables:

- `DATABASE_URL` looks like `postgres:...`  
- `JDBC_DATABASE_URL` looks like `jdbc:postgresql:...`
- `PORT` http port to listen

### Links

- Heroku official documentation in general: [here](https://devcenter.heroku.com/articles/getting-started-with-java)
- Heroku official documentation about JDBC connection: [here](https://devcenter.heroku.com/articles/connecting-to-relational-databases-on-heroku-with-java)
- Heroku official github code: [here](https://github.com/heroku/java-getting-started)
- Baeldung link how to create runnable `jar` file: [here](https://www.baeldung.com/executable-jar-with-maven)
