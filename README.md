# RESTapiTestingForNasa
* This is the RestAPI testing Documents. It will take (GET) method and
 * validate.Here, I am using Jayway libraries for RestAssured and For
 * RestResponse. For RestAssured library please read pom.xml
 *This Project contains Spring model, Maven Project and TestNG Annotation and primary language is JAVA for this
 
 
# Problem
*1.How would you certify this API for public consumption, with parameters q, limit & api_key? Create a README.md file to document your tests.GET https://api.nasa.gov/planetary/sounds
*2.Code a few key examples to demonstrate how you can automate your tests.  I encourage you to use the following technologies (i.e. Java/Spring/TestNg/MVN)
*3.You are a tester so please outline any unexpected issues IF noticed

# Answer
*Created own key from NASA/API page. As suggested in Test---> please use API key instead of DEMO_KEY
*API Key For Testing: - https://api.nasa.gov/planetary/sounds?q&limit=10&api_key=wkbqTSuajmKguQUbvlPgWmCZIwBl3wm0hIRLSQci
*Please check jsonpath file for response
 
# Step to Reproduce
 *How to Run Project---> Package(apiTestingForNasa) ----> Open GETApiForNasa.java and run this file
 

*Validate This Test Cases scenario:- 
 1) Status Code Validation 								(@Test 1)
 2) API Key Validation 									(@Test 2)
 3) Wrong Status code and Wrong API key validation 		(@Test 2)
 4) Test specific key Search validation 				(@Test 3)
 5) All array and all string validation 				(@Test 4..9)
 6) Service Validation 									(@Test 4..9)
 7) Default and parameter validation 					(@Test 4..9)
