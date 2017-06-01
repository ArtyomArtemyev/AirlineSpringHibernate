(function () {

    var sendButton = document.getElementById('createTeamButton');
    sendButton.addEventListener('click',sendButtonClickHandler);

    var flightId = 0;

    function sendButtonClickHandler(event) {
        event.preventDefault();

        var flightRadioButton = document.getElementsByClassName('radioButtonFlight');
        for (var j = 0; j < flightRadioButton.length; j++) {
            if (flightRadioButton[j].type == "radio" && flightRadioButton[j].checked) {
                flightId = flightRadioButton[j].value;
            }
        }

        if(flightId !== 0 ) {

            var sendForm = document.getElementById('changeForm');
            sendForm.action ="flight/update/"+flightId;
            sendForm.submit();
        }
        else {
            alert("Please check team and flight and then click on button");
        }

    }

})();


