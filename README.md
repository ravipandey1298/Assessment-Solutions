# Assessment-Solutions
Mahindra Fin. Assessment Solution

1. API to create Lead in Postgress DB.
   a. API URL : localhost:8080/mahindrafinance/addCustomer
   b. Http Method : POST
   c. Request Body :
        {
        "leadId" : 4479,
        "firstName" : "Ravi",
        "middleName" : "Kant",
        "lastName" : "Pandey",
        "mobileNumber" : 6989898978,
        "gender" : "Male",
        "dob" : "2023-12-01",
        "email" : "ravi@gmail.com"
        }
   d. Response :
      Success :
         {
            "status": "success",
            "data": "Lead added successfully."
         }

    e. Failure :
         {
          "status": "erorr",
          "errorResponse": {
              "code": "409 CONFLICT",
              "message": "Lead Already Present in Database."
              }
          }
