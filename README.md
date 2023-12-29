# Assessment-Solutions
Mahindra Fin. Assessment Solution

1. API to create Lead in Postgress DB.
   -> API URL : localhost:8080/mahindrafinance/addCustomer
   -> Http Method : POST
   -> Request Body :
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
   -> Response :
      Success :
         {
            "status": "success",
            "data": "Lead added successfully."
         }

       Failure :
         {
          "status": "erorr",
          "errorResponse": {
              "code": "409 CONFLICT",
              "message": "Lead Already Present in Database."
              }
          }
