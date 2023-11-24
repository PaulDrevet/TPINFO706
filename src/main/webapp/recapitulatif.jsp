<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="ticket_id" scope="request" class="java.lang.Long" />
<jsp:useBean id="total" scope="request" class="java.lang.Double" />
<jsp:useBean id="date_entree" scope="request" class="java.util.Date" />
<jsp:useBean id="date_paiement" scope="request" class="java.util.Date" />
=

<html>
<head>
  <title>Parking PA</title>
  <script src="https://cdn.tailwindcss.com"></script>
  <link
          rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/rippleui@1.12.1/dist/css/styles.css"
  />
</head>
<body class="flex flex-col min-h-screen">

<div class="w-screen">
  <div class="w-screen flex justify-center p-10 mb-10 bg-red-800">
    <h1 class="text-3xl">Recapitulatif</h1>
  </div>
  <div class="w-screen flex justify-center">
    <div class="card">
      <div class="card-body">
        <h2 class="card-header justify-center">Recapitulatif de vos paiements</h2>
        <p class="text-content2">Numéro de ticket : ${ticket_id}</p>
        <p class="text-content2">Date d'entrée : ${date_entree.day}/${date_entree.month} à ${date_entree.hours}h${date_entree.minutes}</p>
        <p class="text-content2">Date du dernier paiement : ${date_paiement.day}/${date_paiement.month} à ${date_paiement.hours}h${date_paiement.minutes}</p>
        <p class="text-content2">Vous avez payé ${total}$.</p>
      </div>
    </div>
  </div>
</div>


<!-- Bouton "Retour" centré en bas de la page -->
<div class="fixed bottom-0 left-0 p-4">
  <a class="" href="entree.jsp">
    <div>
      <button class="rounded p-2 border-2 border-red-500 hover:cursor-pointer transition-all hover:bg-red-500 hover:text-white">Retour</button>
    </div>
  </a>
</div>

</body>
</html>
