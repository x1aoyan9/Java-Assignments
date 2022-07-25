<!--<c:out value="someVariable"/> -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Fruity Loops</title>
</head>

<body>
    <h1>Fruit Store</h1>

    <div class="container">
        <table class="table">
            <tr>
                <th>Name</th>
                <th>Price</th>
            </tr>

            <c:forEach var="fruit" items="${fruits}">
                <tr>
                    <td>${fruit.name}</td>
                    <td>${fruit.price}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>