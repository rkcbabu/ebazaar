<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <c:import url="/layout/head"/>
    <body>
        <c:import url="/layout/header"/>
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1> ${greeting} </h1>
                    <p> ${tagline} </p>
                </div>
            </div>
        </section>
        <c:import url="/layout/footer"/>
    </body>
</html>