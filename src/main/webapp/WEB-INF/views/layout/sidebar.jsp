<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib  prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="col-sm-3" >
    <div class="left-sidebar">
        <h2>Category</h2>
        <div class="panel-group category-products" id="accordian"><!--category-productsr-->
            <c:forEach items="${categoryList}" var="category">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title"><a href="#">${category.name}</a></h4>
                    </div>
                </div>
            </c:forEach>      
        </div><!--/category-products-->
        <div class="brands_products"><!--brands_products-->
            <h2>Brands</h2>
            <div class="brands-name">
                <ul class="nav nav-pills nav-stacked">
                    <c:forEach items="${vendorList}" var="vendor">
                        <li><a href="#"> <!--<span class="pull-right">(50)</span>-->${vendor.firstName}</a></li>
                    </c:forEach>
                </ul>
            </div>
        </div><!--/brands_products-->
    </div>
</div>
