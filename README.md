# Задача «Слой DAO (Data Access Object)»
## Описание
Попрактиковался в работе со Spring JDBC, параллельно закрепляя уже пройденные темы.

Написано приложение для работы с БД, используя скрипты, которые я написал при выполнении второго задания.

1. Создан Spring Boot приложение с зависимостями на два стартера — `spring-boot-starter-jdbc` и `spring-boot-starter-web`.

2. Перенесен скрипт создания таблицы в файл `schema.sql`, чтобы `Spring Boot` автоматически создавал таблицу.

3. Перенес скрипт запроса из второго задания в папку `resources`. Перепишите скрипт так, чтобы он возвращал `product_name` для именованного параметра `name`(а не только для `alexey`), который вы будете передавать в методы выполнения скрипта `NamedParameterJdbcTemplate` вместе со скриптом запроса.

4. Написан репозиторий для работы с БД.

- Создан класс и пометьте его аннотацией `Repository`, либо создайте бин репозитория в `Java Config` классе.
- Добавлен в поле класса `String`, которое содержит ваше содержание вашего скрипта. Само содержание вы можете считать с помощью кода ниже. Вам надо будет передать в метод read название вашего скрипта, который лежит в папке resources. Например так: `read(myScript.sql)`.
- Создан метод `getProductName(String name)`, который будет принимать имя и возвращать название продукта из базы данных.

```
private static String read(String scriptFileName) {
try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
return bufferedReader.lines().collect(Collectors.joining("\n"));
} catch (IOException e) {
throw new RuntimeException(e);
}
}
```
5. Написан контроллер с методом-обработчиком GET-метода запроса с маппингом на endpoint /products/fetch-product. В query params запроса будет приходить строковый параметр name, который вам надо будет передавать дальше в репозиторий. То есть, ваш метод должен уметь обрабатывать запрос вида `localhost:8080/products/fetch-product?name=Ivan`. Контроллер должен будет возвращать название продукта, которое он получит от репозитория.
