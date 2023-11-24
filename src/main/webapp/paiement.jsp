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
        <h1 class="text-3xl">Borne paiement</h1>
    </div>
    <div class="w-screen flex justify-center">
        <div class="card">
            <div class="card-body">
                <h2 class="card-header justify-center">Ticket</h2>
                <p class="text-content2">Numéro de ticket : ${ticket.id}</p>
                <p class="text-content2">Date d'entrée : ${ticket.dateEntree.day}/${ticket.dateEntree.month} à ${ticket.dateEntree.hours}h${ticket.dateEntree.minutes}</p>
            </div>
        </div>
    </div>
    <div class="w-screen flex justify-center pt-20">
        <form method="post" action="paiement">
            <input type="submit" name="boutonSubmit" value="Paiement CB" class="rounded p-2 border-2 border-white">
            <input type="submit" name="boutonSubmit" value="Paiement Especes" class="rounded p-2 ml-2 border-2 rounded-mg border-white">
        </form>
    </div>

</div>
</body>
</html>

