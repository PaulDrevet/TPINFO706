<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="ticket" scope="request" class="com.example.parking.Ticket" />
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/rippleui@1.12.1/dist/css/styles.css"
    />
</head>
<body>

<div class="w-screen">
    <div class="card">
        <div class="card-body">
            <h2 class="card-header justify-center">${ticket.id}</h2>
            <p class="text-content2">${ticket.dateEntree}</p>
            <div class="card-footer">
                <button class="btn-secondary btn">Learn More</button>
            </div>
        </div>
    </div>

</div>
</body>
</html>

