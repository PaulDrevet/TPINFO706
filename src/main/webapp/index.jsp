<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/rippleui@1.12.1/dist/css/styles.css"
    />
</head>
<body>
<div class="flex flex-col">
    <div>
        <h1 class="bold w-20">Parking</h1>
    </div>
    <div class="flex justify-evenly content-end">
        <div>
            <p>Borne entrée</p>
            <a href="ticket">
                <img src="assets/656140.png" alt="aveugle" width="40%">
            </a>
        </div>
        <div >
            <p>Borne paiement</p>
            <a href="ticket">
                <img src="assets/paiement.png" alt="aveugle" width="40%">
            </a>
        </div>
        <div>
            <p>Borne sortie</p>
            <a href="ticket">
                <img src="assets/656140.png" alt="aveugle" width="40%">
            </a>
        </div>
    </div>
</div>

</body>
</html>