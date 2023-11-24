<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <h1 class="text-3xl">Vous êtes dans le parking</h1>
    </div>
    <div class="flex justify-evenly w-full pt-10">
        <div class="bg-slate-500 hover:bg-slate-800 ease-in-out shadow-xl duration-300 hover:cursor-pointer p-10 rounded-3xl w-1/4">
            <p>Borne paiement</p>
            <a href="paiement">
                <img src="assets/paiement.png" alt="aveugle" width="40%">
            </a>
        </div>
        <div class="bg-slate-500 hover:bg-slate-800 ease-in-out shadow-xl duration-300 hover:cursor-pointer p-10 rounded-3xl w-1/4">
            <p>Borne sortie</p>
            <a href="sortie">
                <img src="assets/656140.png" alt="aveugle" width="40%">
            </a>
        </div>
    </div>
</div>


</body>
</html>
