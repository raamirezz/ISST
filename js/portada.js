document.addEventListener("DOMContentLoaded", function() {
    var registroLink = document.querySelector('.option[href="registro.html"]');
    var loginLink = document.querySelector('.option[href="login.html"]');

    registroLink.addEventListener("click", function(event) {
        event.preventDefault();
        window.location.href = "registro.html";
    });

    loginLink.addEventListener("click", function(event) {
        event.preventDefault();
        window.location.href = "login.html";
    });
});
