<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="ticket_id" scope="request" class="java.lang.Long"/>
<jsp:useBean id="total" scope="request" class="java.lang.Double"/>
<jsp:useBean id="date_entree" scope="request" class="java.util.Date"/>
<jsp:useBean id="datePaiement" scope="request" class="java.util.Date"/>
<jsp:useBean id="aPaye" scope="request" class="java.lang.Boolean"/>

<html>
<head>
    <title>Parking PA</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/rippleui@1.12.1/dist/css/styles.css"/>
    <script>
        function checkPaiement() {

            if (!${aPaye}){
                document.getElementById('messageMontant').innerText = "Vous n'avez pas encore payé.";
            }
            else {
                document.getElementById('messageMontant').innerText = "Total des paiements: ${total}$"
                document.getElementById('messageDate').innerText = "Dernier paiement  le : ${datePaiement.day}/${datePaiement.month} à ${datePaiement.hours}h${datePaiement.minutes}"
            }
        }

        window.onload = function() {
            checkPaiement();
        };
    </script>
</head>
<body class="flex flex-col min-h-screen">

<div class="w-screen">
    <div class="w-screen flex justify-center p-10 mb-10 bg-red-800">
        <h1 class="text-3xl">Recapitulatif</h1>
    </div>
    <div class="w-screen flex justify-center">
        <div class="card">
            <div class="card-body">
                <h2 class="card-header justify-center pb-4">Recapitulatif de vos paiements</h2>
                <p class="text-content2">Numéro de ticket : ${ticket_id}</p>
                <p class="text-content2">Date d'entrée : ${date_entree.day}/${date_entree.month}
                <p class="text-content2" id="messageMontant"></p>
                <p class="text-content2" id="messageDate"></p>
            </div>

        </div>
    </div>
</div>

<div class="fixed bottom-0 left-0 p-4">
    <a class="" href="entree.jsp">
        <div>
            <button class="rounded p-2 border-2 border-red-500 hover:cursor-pointer transition-all hover:bg-red-500 hover:text-white">
                Retour
            </button>
        </div>
    </a>
</div>

</body>
</html>
