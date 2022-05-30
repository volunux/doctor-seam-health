#Doctor Seam Health

## An API that manages Doctors details and their address

#### List of API Route and Definition
** NOTE: ** All Request should have an Accepts and Content-Type header with the value application/json

Api Url is ** (Seam Health Consult)[https://obscure-springs-41531.herokuapp.com/] **

** _ {id} _ is a placeholder or variable that should be replace with an Long value during request **

| Route                   | Http Method    | Description            | Sample Body                           | Options      |
| ----------------------- | -------------- | ---------------------- | ------------------------------------- | -----------  |
| api/doctor/entries      | GET            | Retrieve all records   |                                       | ?email=value |
| api/doctor/detail/{id}  | GET            | Retrieve single record |                                       |              |
| api/doctor/remove/{id}  | GET            | Remove record          |                                       |              |
| api/doctor/create       | POST           | Add new record         | { "firstName": "Moyegun", <br/> "lastName": "Adeola", "emailAddress": "adetokunbo@gmail.com", <br/> "address": "Ademola Adetokunbo Street, Abuja",<br/> "lga": "FCT", <br/> "phoneNumber": "+2349022035587", <br/> "state": "Federal Capital Territory" <br/> } <br/> |               |
| api/doctor/update/{id}  | POST           | Update a record        | { "firstName": "Mayegun", <br/> "lastName": "Ademulegun", <br/> "emailAddress": "adetokunbo@gmail.com", <br/> "address": "Ademola Adetokunbo Street, Abuja", <br/> "lga": "FCT", <br/> "phoneNumber": "+2349022035587", <br/> "state": "Ogun State" <br/> } <br/> | |
