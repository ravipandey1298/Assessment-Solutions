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
   d. Success Response :
         {
            "status": "success",
            "data": "Lead added successfully."
         }

    e. Failure Response :
         {
          "status": "erorr",
          "errorResponse": {
              "code": "409 CONFLICT",
              "message": "Lead Already Present in Database."
              }
          }
   
3. Getting All leads from DB based on Mobile Number.
      a. API URL : localhost:8080/mahindrafinance/getLeads?mobileNumber=6989898978
      b. Http Method : 
      c. Success Response :
            {
                "status": "success",
                "datas": [
                             {
                                 "leadId": 4479,
                                 "firstName": "Ravi",
                                 "middleName": "Kant",
                                 "lastName": "Pandey",
                                 "mobileNumber": "6989898978",
                                 "gender": "Male",
                                 "dob": "2023-12-01",
                                 "email": "ravi@gmail.com"
                             }
                         ]
                     }

      d. Failure Response :
            {
                "status": "erorr",
                "errorResponse": {
                    "code": "404 NOT_FOUND",
                    "message": "No Leads Found with the Mobile Number."
                 }
             }
