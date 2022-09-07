<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp"></jsp:include>

<div class="container-fluid bg-light myBorder">
    <form action="/product/search" method="post">
        <div class="row align-items-center justify-content-center">
            <div class="col-md-2 pt-3">
                <div class="form-group ">
                    <input type="text" placeholder="By name" name="name" class="form-control">
                </div>
            </div>
            <div class="col-md-2 pt-3">
                <div class="form-group">
                    <input type="text" placeholder="By category" name="category" class="form-control">
                </div>
            </div>
            <div class="col-md-2 pt-3">
                <div class="form-group">
                    <input type="number" placeholder="By price" name="price" class="form-control">
                </div>
            </div>

            <div class="col-md-2">
                <button type="submit" class="btn btn-primary btn-block" target=" ">Search</button>
            </div>
        </div>
    </form>
</div>
<div><br></div>

<div class="container-fluid bg-light myBorder">
    <h4>Products:</h4>
    <table class="table table-bordered table-striped text-center">
        <thead>
        <tr class="text-center">
            <%--<th><b>Product Id</b></th>--%>
            <th class="text-center"><b>Name</b></th>
            <th class="text-center"><b>Description</b></th>
            <th class="text-center"><b>Price</b></th>
            <th class="text-center"><b>Image</b></th>
            <th class="text-center"><b>Category</b></th>
            <th class="text-center"><b>Entry date</b></th>
            <th class="text-center"><b>Status</b></th>
            <th class="text-center" colspan='2'><b> Operation</b></th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${list}" var="product">
            <tr>
                <%--<td><c:out value="${product.productId}"></c:out></td>--%>
                <td><c:out value="${product.name}"></c:out></td>
                <td><c:out value="${product.description}"></c:out></td>
                <td><c:out value="${product.price}"></c:out></td>
                <td><c:out value="${product.img}"></c:out></td>
                <td><c:out value="${product.category}"></c:out></td>
                <td><c:out value="${product.entryDate}"></c:out></td>
                <td><c:out value="${product.status}"></c:out></td>
                <td>
                    <a href="/product/edit?productId=${product.productId}">
                        <button type="submit" class="btn btn-primary">Edit Product</button>
                    </a>

                    <a href="/product/delete?productId=${product.productId}">
                        <button type="submit" class="btn btn-danger"
                                onclick="alert(' !! Warning !! Product will be deleted.')">Delete Product
                        </button>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</div>
<div><br></div>
<jsp:include page="footer.jsp"></jsp:include>