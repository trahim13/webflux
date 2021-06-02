why?
https://habr.com/ru/post/500446/
https://technology.amis.nl/software-development/performance-and-tuning/spring-blocking-vs-non-blocking-r2dbc-vs-jdbc-and-webflux-vs-web-mvc/


mvc
curl http://localhost:8081/math/square/10
curl http://localhost:8081/math/table/10

reactive
curl http://localhost:8081/reactive-math/square/10
curl http://localhost:8081/reactive-math/table/10
curl http://localhost:8081/reactive-math/table/10/stream
curl http://localhost:8081/reactive-math/square/9/throw
curl http://localhost:8081/reactive-math/square/9/mono-error

curl --location --request POST 'http://localhost:8081/reactive-math/multiply' \
--header 'Content-Type: application/json' \
--data-raw '{
    "first": 1,
    "second" : 3
}'


router
curl http://localhost:8081/router/square/10
curl http://localhost:8081/router/square/2

product
-- mongodb
http://localhost:8091/product/all
http://localhost:8091/product/price-range?min=100&max=800
http://localhost:8091/product/60b75351f2d6fc5589c50e36

curl --location --request POST 'http://localhost:8091/product' \
--header 'Content-Type: application/json' \
--data-raw '{
   
   "description": "idea",
    "price": 500
}'


