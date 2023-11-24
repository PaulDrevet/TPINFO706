<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="canExit" scope="request" class="java.lang.Boolean" />

<html>
<head>
    <title>Title</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/rippleui@1.12.1/dist/css/styles.css"
    />
    <script>
        function checkCanExit() {
            var canExitValue = <%= canExit %>;

            if (canExitValue) {
                // Si canExit vaut true, le bouton est clickable
                document.getElementById("sortirButton").removeAttribute("disabled");
            } else {
                // Sinon, afficher le message et griser le bouton
                alert("Vous devez avoir payé depuis moins de 30 secondes.");
                document.getElementById("sortirButton").setAttribute("disabled", "true");
            }
        }
    </script>
</head>
<body>

<div class="w-screen">
    <div class="w-screen flex justify-center p-10 mb-10 bg-red-800">
        <h1 class="text-3xl">Borne paiement</h1>
    </div>
    <div class="w-screen flex justify-center pt-8">
        <form method="post" action="sortie">
            <input type="submit" id="sortirButton" name="boutonSubmit" value="Sortir du parking" class="rounded p-2 ml-2 border-2 rounded-mg border-white transition-all hover:cursor-pointer hover:bg-slate-700" onclick="checkCanExit()">
        </form>
    </div>
</div>

</body>
</html>