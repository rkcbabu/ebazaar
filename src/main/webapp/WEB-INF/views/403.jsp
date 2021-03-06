<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
        <c:import url="/layout/head"/>

    <body>
        <div class="container text-center">
            <div class="logo-404">
                <a href="<c:url value="/" />"><span>E</span>-bazaar</a>
            </div>
            <div class="content-404">
                <img width="400px" src="<c:url value="/web-resources/images/404/404.png" />" class="img-responsive" alt="" />
                <h1><b>OPPS!</b> <br>${msg}</h1>
                <h2><a href="<c:url value="/"/>">Bring me back Home</a></h2>
            </div>
        </div>


        <script src="<c:url value="/web-resources/js/jquery.js"/>"></script>
<script src="<c:url value="/web-resources/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/web-resources/js/jquery.scrollUp.min.js"/>"></script>
<script src="<c:url value="/web-resources/js/price-range.js"/>"></script>
<script src="<c:url value="/web-resources/js/jquery.prettyPhoto.js"/>"></script>
<script src="<c:url value="/web-resources/js/main.js"/>"></script>
    </body>
</html>