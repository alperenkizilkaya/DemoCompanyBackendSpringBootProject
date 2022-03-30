Company Demo Backend Project with Spring Boot

there is no front-end for now.
you can use postman to check these http requests;

POST -> http://localhost:8090/company/api/v1/employees
(request body raw(json))
{
    "firstName": "testName",
    "surname": "testSurname",
    "mail": "test@example.com",
    "password": "test",
    "department": "HR",
    "salary": 3000.0
}

GET -> http://localhost:8090/company/api/v1/employees/1
(get the employee that has id=1)

DELETE -> http://localhost:8090/company/api/v1/employees/1
(delete the employee that has id=1)

GET -> http://localhost:8090/company/api/v1/employees/all
(get all employees)

PUT -> http://localhost:8090/company/api/v1/employees/1
(for updating the employee that has id=1) -> in request body, you should type fields that you want to change;
                                             others don't change.
{
    "firstName": "testUpdateName0000",
    "surname": "testUpdateSurname0000",
    "mail": "testUpdate@example.com"
}

##############################################################################################
##############################################################################################

# you have to create db that name is companydb,
    # in application.properties file -> you have to configure mysql username and password
                                     -> you can configure the port number

##############################################################################################
##############################################################################################