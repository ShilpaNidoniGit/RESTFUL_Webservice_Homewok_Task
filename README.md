# RESTFUL webservice project with Spring boot and MongoDB Atlas on cloud 

This is a Spring boot  application providing a REST
API to a Payment Card creator.

## create

    Springboot application with Spring Initializr

## Run the app using mvn command

    spring-boot:run

## Run the SpringBootTests

    SpringBootMongodbRestApiApplicationTests.java

# REST API

The REST API of the app is described below.

## Get list of Cards

### Request

`GET /all/`

    https://rest-service-homework-task.herokuapp.com/rest/card/all

### Response

    Status Code: 200
    content-type: application/json;charset=UTF-8
    date: Tue, 22 Oct 2019 11:00:24 GMT
    transfer-encoding: chunked
    
`[{"cardNumber":"0242798876537894","cardSchema":"VISA","validityDate":"10/2024","cardHolderName":"Alex","transactions":[{"date":"22/10/2019","amount":1}]},{"cardNumber":"0242798876537897","cardSchema":"MASTER","validityDate":"10/2019","cardHolderName":"Coptil","transactions":[{"date":"21/10/2019","amount":200000}]},{"cardNumber":"0850656369952367","cardSchema":"MASTER","validityDate":"10/2024","cardHolderName":"Libina","transactions":[{"date":"22/10/2019","amount":100000}]},{"cardNumber":"3129687184001016","cardSchema":"AMEX","validityDate":"10/2024","cardHolderName":"Shilpa","transactions":[{"date":"21/10/2019","amount":30000},{"date":"22/10/2019","amount":10000}]}]`

## Create a new card with only specific properties in the request (1st variant of create card)
    (cardHolderName is only mandatory property, cardSchema and amount are optionsl, the other card properties will be   	generated automatically.)

### Request

`POST /specificCardProperties/create`

        https://rest-service-homework-task.herokuapp.com/rest/card/specificCardProperties/create?cardSchema=AMEX&cardHolderName=Shilpa&amount=30000
	OR
	https://rest-service-homework-task.herokuapp.com/rest/card/specificCardProperties/create?cardHolderName=Matt     

### Response

    Status Code: 200
    content-length: 78
    content-type: text/plain;charset=UTF-8
    date: Tue, 22 Oct 2019 11:44:20 GMT

`The card with number {cardNumber} created successfully for the user {cardHolderName}`

## Create a new card with all properties in the request body (2nd variant of create card)

### Request

`POST /allCardProperties/create`

    https://rest-service-homework-task.herokuapp.com/rest/card/allCardProperties/create
	
    Request body:
	
    {
		"cardNumber": "3129687184001017",
		"cardSchema": "AMEX",
		"validityDate": "10/2024",
		"cardHolderName": "Monica",
		"transactions": [{
				"date": "22/10/2019",
				"amount": 31000
			},
			{
				"date": "22/10/2019",
				"amount": 11000
			}
		  ]
	}


### Response

    Status Code: 200
    content-length: 58
    content-type: text/plain;charset=UTF-8
    date: Tue, 22 Oct 2019 11:49:35 GMT

`The card with number {cardNumber} created successfully`


## Get a card by card number

### Request

`GET /getCardByNumber/{cardNumber}`

    https://rest-service-homework-task.herokuapp.com/rest/card/getCardByNumber/3129687184001017

### Response

    Status Code: 200
    content-type: application/json;charset=UTF-8
    date: Tue, 22 Oct 2019 11:56:48 GMT
    transfer-encoding: chunked

	{
		"cardNumber": "3129687184001017",
		"cardSchema": "AMEX",
		"validityDate": "10/2024",
		"cardHolderName": "Monica",
		"transactions": [{
			"date": "22/10/2019",
			"amount": 31000
		}, {
			"date": "22/10/2019",
			"amount": 11000
		}]
	}



