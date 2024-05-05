document.addEventListener("DOMContentLoaded", function() {
    var registroLink = document.querySelector('.option[href="/registro"]');
    var loginLink = document.querySelector('.option[href="/login"]');

    registroLink.addEventListener("click", function(event) {
        event.preventDefault();
        window.location.href = "/registro";
    });

    loginLink.addEventListener("click", function(event) {
        event.preventDefault();
        window.location.href = "/login";
    });
});
