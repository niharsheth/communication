# communication
Created an endpoint "/email" which takes values of necessary parameters and sends an email using SendGrid.
How to run :
Open the project with IntelliJ and run DemoApplication.java
go to browser and type localhost:8080/sendemail
A simple UI form will open. Enter the information and click the button. If information is correct, email will be sent or you will see the error.

Technology stack:
- Java Spring MVC - I opted to work with Java Spring as I am much more familiar with it.

I used PostMark in the application but you will get an error. PostMark is only accepting company email addresses to use in "from" parameter. I couldnt create any gmail or personal domain account in PostMark.

I was planning to implement automatic switch between SendGrid and postMark but PostMark is not working, so couldn't implement.
How to implement automatic switch:
 - Add a counter and calculate the number of tries application is making to get the successful response. 
 - Once application makes 5 attempts and returns with unsuccess message, call the PostMark method to send an email.
 
 Something like this,
 
  boolean doLoop = true;
        int countTry = 0;
        while (doLoop) {
            response = senEmailService.sendEmail(communication);
            if (response.getStatusCode() == 202) {
                doLoop = false;
                continue;
            }
            if (response.getStatusCode() != HttpStatus.ACCEPTED) {
                Assert.fail("Unable to send the email: " + response.getStatusCode());
            }
            if (++countTry == 5) {
                doLoop = false;
                MessageResponse response = sendEmailService.sendEmailPostMark(communication);
            }
        }
 
