<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <jsp:include page="/WEB-INF/views/includes/head.jsp"/>
    <body>
        <jsp:include page="/WEB-INF/views/includes/header.jsp"/>
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1> ${greeting} </h1>
                    <p> ${tagline} </p>
                </div>
            </div>
        </section>
        <jsp:include page="/WEB-INF/views/includes/footer.jsp"/>
    </body>
</html>