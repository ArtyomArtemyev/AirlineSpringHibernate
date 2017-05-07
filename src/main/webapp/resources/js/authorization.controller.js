(function () {

    var submitButton = document.getElementById('submitButton');
    submitButton.addEventListener('click', submitButtonClickHandler);

    function submitButtonClickHandler (event) {
        event.preventDefault();

        var formElements = document.getElementById('loginForm').elements;
        if (formElements.inputLogin.value === '' || formElements.inputPassword.value === '') {
            alert('Fill all fields');

            highlightFileds();
        } else {
            resetHighlightning();

            var loginForm = document.getElementById('loginForm');
            loginForm.submit();
        }
    }

    function highlightFileds () {
        var inputLogin = document.getElementById('inputLogin');
        var inputPassword = document.getElementById('inputPassword');

        if (inputLogin.value === '') {
            document.getElementById('inputLogin').style.borderColor = 'red';
            document.getElementById('inputLogin').style.borderWidth = '2px';
        }

        if (inputPassword.value === '') {
            document.getElementById('inputPassword').style.borderColor = 'red';
            document.getElementById('inputPassword').style.borderWidth = '2px';
        }

    }

    function resetHighlightning () {
        document.getElementById('inputLogin').style.borderColor = 'initial';
        document.getElementById('inputLogin').style.borderWidth = '2px';
        document.getElementById('inputPassword').style.borderColor = 'initial';
        document.getElementById('inputPassword').style.borderWidth = '2px';
    }

})();
