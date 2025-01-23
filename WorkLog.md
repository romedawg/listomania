## Things to do

## TOP DAWG
 - Create users Dynamicaly or through UI/Cognito/CLI
   - Verification

# Message Controller
- DONE - >In Progress - Get list of objects
  - Active
- DONE - List of items
  -> need to call a function that parses list

## Message Model
- Share list with someone on phone number
  - allow them to pull/push to list

## Clean up
- Reset list
- Remove items from list

put new list
- DONE -> lookup or create category
    - by phone number

# Domain Objects
 - create user object
   - name, email, phone_number, verification

# Testing
 - DONE -> h2 for dev profile
 - input tests
 - parse a list of object(non json)

Cognito Design

SNS/Lambda interaction

1. Messages comes to twilio/SNS/Other
   2. Message is sent to Lambda
   3. Lambda takes itemsk
