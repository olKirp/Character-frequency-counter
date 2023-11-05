# FrequencyCounter 
Тестовое задание для компании "Т1 Консалтинг".<br><br>
[![codecov](https://codecov.io/gh/olKirp/Character-frequency-counter/graph/badge.svg?token=60P5O7WKMH)](https://codecov.io/gh/olKirp/Character-frequency-counter)

### О приложении
Приложение подсчитывает, сколько раз в заданной строке встречается каждый символ. Результат отсортировывает по
убыванию количества вхождений символа и в алфавитном порядке. 

### Использованные технологии
-	Spring Boot 3
-	Log4j 2 и Spring Aspects для логирования
-	JUnit5 Mockito для тестирования
-	OpenAPI/Swagger для документирования API

### Сборка и запуск

1. Если установлена Java:
```
.\mvnw clean install
java -jar .\target\frequencyCounter-0.0.1-SNAPSHOT.jar
```

2. Если установлен Docker:
```
docker build --tag 'frequency_counter' .
docker run -p 8081:8081 -t --name frequency_counter 'frequency_counter'
```

Приложение будет доступно по ссылке: 
http://localhost:8081/swagger-ui/index.html#/

### API приложения
```
POST /frequencyCounter/count
```
Подсчитывает частоту встречаемости символов в строке, переданной в теле запроса.
Строка должна содержать как минимум один символ.<br>

Результат возвращает в виде отсортированных пар 'символ'-'количество вхождений'. 

Пример ввода: 
```
aaabbcd
```

Пример результата: 
```
{
  "a": 3,
  "b": 2,
  "c": 1,
  "d": 1
}
```
Более подробное описание API будет доступно после запуска приложения по ссылке: http://localhost:8081/swagger-ui/index.html#/

