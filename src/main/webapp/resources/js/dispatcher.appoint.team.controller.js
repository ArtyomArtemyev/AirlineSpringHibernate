(function () {

    var sendButton = document.getElementById('appointButton');
    sendButton.addEventListener('click',sendButtonClickHandler);

    var teamId = 0;
    var flightId = 0;

    function sendButtonClickHandler(event) {
        event.preventDefault();

        var teamRadioButton = document.getElementsByClassName('radioButtonTeam');
        for (var i = 0; i < teamRadioButton.length; i++) {
            if (teamRadioButton[i].type == "radio" && teamRadioButton[i].checked) {
                teamId = teamRadioButton[i].value;
            }
        }

        var flightRadioButton = document.getElementsByClassName('radioButtonFlight');
        for (var j = 0; j < teamRadioButton.length; j++) {
            if (flightRadioButton[j].type == "radio" && flightRadioButton[j].checked) {
                flightId = flightRadioButton[j].value;
            }
        }

        if(flightId !== 0 && teamId !== 0) {

            sendUpdateFlight();
        }
        else {
            alert("Please check team and flight and then click on button");
        }


    }

    function sendUpdateFlight() {
        var prefix = '/airline/';
        $.ajax({
            type: 'PUT',
            url: prefix +'team/' + teamId,
            data: flightId,
            headers: {
                'Accept': 'application/text',
                'Content-Type': 'application/json'
            },
            dataType: 'text',
            success: function(receive) {
                $("#contentDiv").empty();
                $("#informationP").replaceWith(receive);
                $("#hiddenLi").removeAttr('style');
            },
            error: function (jqXhr, textStatus, errorThrown) {
                alert("Ошибка '" + jqXhr.status + "' (textStatus: '" + textStatus + "', errorThrown: '" + errorThrown + "')");
            }
        });
    }

})();


