# communication
Created an endpoint "/email" which takes values of necessary parameters and sends an email using SendGrid.
How to run :
Open the project with IntelliJ and run DemoApplication.java
go to browser and type localhost:8080/sendemail
A simple UI form will open. Enter the information and click the button. If information is correct, email will be sent or you will see the error.

Technology stack:
- Java Spring MVC - I opted to work with Java Spring as I am much more familiar with it.

I used PostMark in the application but you will get an error. PostMark is only accepting company email addresses to use in "from" parameter. I couldnt create any gmail or personal domain account in PostMark.
