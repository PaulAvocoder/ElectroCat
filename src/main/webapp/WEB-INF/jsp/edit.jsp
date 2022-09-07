<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp"></jsp:include>

<div class="container myBorder">
    <form action='/product/edit/${product.productId}' method='post' modelAttribute="editProduct">
        <h4> Edit product:</h4>
        <table class='table table-hover table-responsive table-bordered rounded-lg'>
            <tr>
                <td><b>Name</b></td>
                <td><input type='text' name='name' class='form-control' required
                           value="${product.name}"/></td>
            </tr>
            <tr>
          <td><b>Decript</b></td>
          <td><input type='text' name='description' class='form-control' required value="${product.description}"/></td>
            </tr>
            <tr>
            <td><b>Price</b></td>
                  <td><input type='number' name='price' class='form-control' required value="${product.price}"/></td>
                        </tr>
                  <tr>
                     <td><b>Image</b></td>
                     <td><input type='text' name='img' class='form-control' required value="${product.img}"/></td>
                  </tr>
            <tr>
               <td><b>Category</b></td>
               <td><input type='text' name='category' class='form-control' required value="${product.category}"/></td>
                        </tr>
            <tr>
                <td><b>EntryDate</b></td>
                <td><input type='date' name='entryDate' class='form-control' required size="20"
                           value="${product.entryDate}"/>
                </td>
            </tr>
            <tr>
                <td><b>Status (true OR false)</b></td>
                <td>
                    <input type='text' name='status' class='form-control' required min="1" max="20" size="20"
                           value="${product.status}"/>
                </td>
            </tr>

            <tr>
                <td colspan="2">
                    <button type="submit" class="btn btn-primary">Update</button>
                </td>
            </tr>
        </table>
    </form>
</div>

<jsp:include page="footer.jsp"></jsp:include>