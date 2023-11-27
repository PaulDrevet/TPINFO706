<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="canExit" scope="request" class="java.lang.Boolean" />

<html>
<head>
    <title>Parking PA</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/rippleui@1.12.1/dist/css/styles.css"
    />
    <style>
        .tailwind-button.button-disabled {
            cursor: not-allowed;
        }
        .tailwind-button.button-enabled{
            cursor: pointer;
        }
    </style>
    <script>
        function checkCanExit() {
            var canExitValue = <%= canExit %>;
            var sortirButton = document.getElementById("sortirButton");

            if (!canExitValue) {
                sortirButton.classList.add("button-disabled", "tailwind-button");
                sortirButton.setAttribute("disabled", "true");
                document.getElementById("message").innerText = "Vous devez avoir payé depuis moins de 15 secondes.";
            }
            else{
                sortirButton.classList.add("button-enabled", "tailwind-button");
                document.getElementById("message").innerText = "";
            }
        }

        window.onload = function() {
            checkCanExit();
        };
    </script>
</head>
<body class="flex flex-col min-h-screen">

<div class="w-screen">
    <div class="w-screen flex justify-center p-10 mb-10 bg-red-800">
        <h1 class="text-3xl">Borne sortie</h1>
    </div>
    <div class="w-screen flex justify-center pt-8">
        <form method="post" action="sortie">
            <input type="submit" id="sortirButton" name="boutonSubmit" value="Sortir du parking" class="tailwind-button rounded p-2 ml-2 border-2 rounded-mg border-white transition-all hover:bg-slate-700" onclick="checkCanExit()">
        </form>
    </div>
</div>

<!-- Message affiché au-dessus du bouton -->
<div class="text-red-500 text-center" id="message"></div>

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
