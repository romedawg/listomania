# LaundryList

Small app that helps manage tracking store items when you think of them. Just need to text the number 'Store_Name' & 'item' 
and you'll be able pull this list when you're at said store.

For example, when you think of it, you can text Grocery Butter -> This will Create or Amend a list grouped under "Grocery".
So that when you're at the grocery store, you can pull this list when necessary.

Other examples
 - Home Depot -> Air Filters
 - Costco -> Brisket
 - Target -> Deodorant


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



# Building/Running

```
export POSTGRES_HOST=postgres
export POSTGRES_DATABASE=romedawg
export POSTGRES_USERNAME=roman
export POSTGRES_PASSWORD=password

For postgres connect -> psql -h localhost -p 5432 -U roman -d romedawg

./gradlew build; java -jar  -Dspring.profiles.active=dev ./build/libs/listomania-0.0.1-SNAPSHOT.jar

```

# Testing
```
## GET
curl -v localhost:8080/message/groceries

## POST
curl -X POST localhost:8080/list -H 'Content-type:application/json' -d '{"phoneNumber": "7082997663", "category": "groceries", "data": "milk"}'
```