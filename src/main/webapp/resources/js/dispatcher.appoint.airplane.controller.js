(function () {

    var sendButton = document.getElementById('appointButton');
    sendButton.addEventListener('click',sendButtonClickHandler);

    var airplaneId = 0;
    var flightId = 0;

    function sendButtonClickHandler(event) {
        event.preventDefault();

        var airplaneRadioButton = document.getElementsByClassName('radioButtonAirplane');
        for (var i = 0; i <  airplaneRadioButton.length; i++) {
            if (airplaneRadioButton[i].type == "radio" && airplaneRadioButton[i].checked) {
                airplaneId = airplaneRadioButton[i].value;
            }
        }

        var flightRadioButton = document.getElementsByClassName('radioButtonFlight');
        for (var j = 0; j < flightRadioButton.length; j++) {
            if (flightRadioButton[j].type == "radio" && flightRadioButton[j].checked) {
                flightId = flightRadioButton[j].value;
            }
        }

        if(flightId !== 0 && airplaneId !== 0) {

            sendUpdateFlight();
        }
        else {
            alert("Please check team and flight and then click on button");
        }

    }

    function sendUpdateFlight() {
        var sendData = {
            idFlight:flightId
        };
        $.ajax({
            type: 'PUT',
            url: '/airplane/' + airplaneId,
            data:JSON.stringify(sendData),
            headers: {
                'Accept': 'application/text',
                'Content-Type': 'application/json'
            },
            dataType: 'text',
            success: function(receive) {
                $("#contentDiv").empty();
                $("#informationP").text(receive);
                $("#hiddenLi").removeAttr('style');
            },
            error: function (jqXhr, textStatus, errorThrown) {
                alert("Error appointed airplane");
            }
        });
    }

})();


