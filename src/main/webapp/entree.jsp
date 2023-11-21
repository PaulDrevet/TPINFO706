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
    <div class="w-screen flex justify-center p-10 mb-10 bg-red-800">
        <h1 class="text-3xl">Parking</h1>
    </div>
    <div class="flex w-full justify-center">
        <div class="card">
            <div class="card-body">
                <h2 class="card-header justify-center">${ticket.id}</h2>
                <p class="text-content2">Date entrée : ${ticket.dateEntree.date}/${ticket.dateEntree.month} à ${ticket.dateEntree.hours}h${ticket.dateEntree.minutes}</p>

            </div>
        </div>
    </div>

    <div class="flex justify-evenly w-full pt-10">
        <div class="bg-slate-500 p-10 rounded-3xl w-1/4">
            <p>Borne paiement</p>
            <a href="ticket">
                <img src="assets/paiement.png" alt="aveugle" width="40%">
            </a>
        </div>
        <div class="bg-slate-500 p-10 rounded-3xl w-1/4">
            <p>Borne sortie</p>
            <a href="ticket">
                <img src="assets/656140.png" alt="aveugle" width="40%">
            </a>
        </div>
    </div>
</div>


</body>
</html>
