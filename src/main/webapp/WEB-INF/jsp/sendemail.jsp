<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Communication Platform</title>
</head>
<body>
<div class="container">

    <form:form method="post" modelAttribute="communication">
        <fieldset class="form-group">
            <form:label path="receiverEmail">To :</form:label>
            <form:input path="receiverEmail" type="email" required="required"></form:input><br>
            <form:label path="receiverName">To Name :</form:label>
            <form:input path="receiverName" type="text" required="required"></form:input><br>
            <form:label path="senderEmail">From :</form:label>
            <form:input path="senderEmail" type="email" required="required"></form:input><br>
            <form:label path="senderName">From Name :</form:label>
            <form:input path="senderName" type="text" required="required"></form:input><br>
            <form:label path="subject">Subject :</form:label>
            <form:input path="subject" type="text" required="required"></form:input><br>
            <form:label path="body">Body :</form:label>
            <form:input path="body" type="text" required="required"></form:input><br>
            <button type="submit" name="sendEmail">Send Email </button>

            <form:errors path="*" cssClass="error-message"></form:errors>
        </fieldset>

    </form:form>
</div>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>