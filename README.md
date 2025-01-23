# Overview

Small app that helps manage ongoing lists when you think of them. 
 - Just need to text the number 'Store_Name' & 'item' and you'll be able to pull this list when it's convenient.
 - Example
   -  I need more electric tape when I go to hardware store
     - Text -> hardware electric tape
   - Next time you're at the store text xxx-xxx-xxxx - hardware pull your list
     - Can clean up same way using text or in the UI


Other examples
 - grocery -> honey
 - Costco -> brisket
 - Target -> kids supplies


Put Message -> Twilio Number -> API -> Parse Logic -> persist to database
GET Message -> Twilio Number -> API -> Lookup -> database

phase 0
1. Create project(springboot)
2. Create Twilio account
3. Link Twilio account to springboot app
4. Persist data using phone number


Domain Model

id
phone_number
category
data
owner
date_entry
remove



# Building/Running Locally

```
export POSTGRES_HOST=postgres
export POSTGRES_DATABASE=romedawg
export POSTGRES_USERNAME=roman
export POSTGRES_PASSWORD=password

For postgres connect -> psql -h localhost -p 5432 -U roman -d romedawg

./gradlew build; java -jar  -Dspring.profiles.active=dev ./build/libs/listomania-1.0.0.jar

java -jar  -Dspring.profiles.active=test ./build/libs/listomania-1.0.0.jar

// DOCKER Build
docker build --build-arg VERSION=1.0.0 --build-arg PROFILE=dev -t listomania .

```

# Building to AWS
```
Update buildspec.yml with the correct aws Account ID
 - You need to to congure codeCommit/codeBuild see [here]() for details

docker pull 131261850621.dkr.ecr.us-east-2.amazonaws.com/listomania:latest

```

# Running Docker Container
```
docker run --env-file .mycredentials.txt --name listomania -p 8080:8080 131261850621.dkr.ecr.us-east-2.amazonaws.com/listomania:latest
docker run --env-file .mycredentials.txt --name listomania -p 8080:8080 listomania:latest

```

# API Endpoint Operations & Testing
## Messages
```
GET Messages based on category
curl -v localhost:8080/list/groceries
curl -X GET localhost:8080/list/costco

POST messages by phone number
curl -X POST localhost:8080/list -H 'Content-type:application/json' -d '{"phoneNumber": "7081234567", "category": "groceries", "data": "milk"}'
curl -X POST localhost:8080/list -H 'Content-type:application/json' -d '{"phoneNumber": "7081234567", "category": "home depot", "data": "lights"}'

GET Messages based on phone number
curl -X GET localhost:8080/mylist/7082997663
```

## User
```
GET - User user by phone number
curl -X GET localhost:8080/user/7081234567

POST - Sign up user by phone number
curl -X POST localhost:8080/user -H 'Content-type:application/json' -d '{"phoneNumber": "7082997663", "email": "roman32@gmail.com"}'

```

# Testing
```
## GET
curl -v localhost:8080/list/groceries

## POST
curl -X POST localhost:8080/list -H 'Content-type:application/json' -d '{"phoneNumber": "7082997663", "category": "groceries", "data": "milk"}'

romedawg=# select p.phone_number, m.data from message as m, person as p where m.person_id = p.person_id AND m.active = true;
 phone_number | data
--------------+-------
 7082997663   | bread
(1 row)
```
