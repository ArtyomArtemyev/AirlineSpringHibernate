(function () {

    var submitButton = document.getElementById('submitButton');
    submitButton.addEventListener('click', submitButtonClickHandler);

    function submitButtonClickHandler (event) {
        event.preventDefault();

        var formElements = document.getElementById('registrationForm').elements;
        if (formElements.login.value === '' || formElements.password.value === '' || formElements.mail.value === '') {
            alert('Fill all fields');

            highlightFileds();
        } else {


            var userMail = formElements.mail.value;
            var isCorrectMail = userMail.match(/^[0-9a-z-\.]+\@[0-9a-z-]{2,}\.[a-z]{2,}$/i);
            if (!isCorrectMail){
                alert('Input correct email address')
            }
            else {
                resetHighlightning();

                var registrationForm = document.getElementById('registrationForm');
                registrationForm.submit();
            }
        }
    }

    function highlightFileds () {
        var loginField = document.getElementById('login');
        var passwordField = document.getElementById('password');
        var mailField = document.getElementById('mail');

        if (loginField.value === '') {
            document.getElementById('login').style.borderColor = 'red';
            document.getElementById('login').style.borderWidth = '1px';
        }

        if (passwordField.value === '') {
            document.getElementById('password').style.borderColor = 'red';
            document.getElementById('password').style.borderWidth = '1px';
        }

        if (mailField.value === '') {
            document.getElementById('mail').style.borderColor = 'red';
            document.getElementById('mail').style.borderWidth = '1px';
        }
    }

    function resetHighlightning () {
        document.getElementById('login').style.borderColor = 'initial';
        document.getElementById('login').style.borderWidth = '2px';
        document.getElementById('password').style.borderColor = 'initial';
        document.getElementById('password').style.borderWidth = '2px';
        document.getElementById('mail').style.borderColor = 'initial';
        document.getElementById('mail').style.borderWidth = '2px';
    }

})();
