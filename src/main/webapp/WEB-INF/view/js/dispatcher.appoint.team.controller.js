(function () {

    var sendButton = document.getElementById('appointButton');
    sendButton.addEventListener('click',sendButtonClickHandler);

    function sendButtonClickHandler(event) {
        event.preventDefault();

        var teamList = document.getElementById('teamTable').getElementsByTagName('tr');
        var checkTeam = false;
        for (var i = 1; i < teamList.length; i++) {
            var td = teamList[i].querySelectorAll("td")[1];
            var checkbox = td.querySelector("input[type='checkbox']");
            if (checkbox.checked) {
                checkTeam = true;
            }
        }
        var checkFlight = false;
        var flightList = document.getElementById('flightTable').getElementsByTagName('tr');
        for (var i = 1; i < flightList.length; i++) {
            var td = flightList[i].querySelectorAll("td")[3];
            var checkbox = td.querySelector("input[type='checkbox']");
            if (checkbox.checked) {
                checkFlight = true;
            }
        }

        if(checkTeam && checkFlight) {
            var idTeam;
            for (var i = 1; i < teamList.length; i++) {
                var td = teamList[i].querySelectorAll("td")[1];
                var checkbox = td.querySelector("input[type='checkbox']");
                if (checkbox.checked) {
                    idTeam = teamList[i].querySelectorAll("td")[0].innerHTML;
                }
            }

            var idFlight;
            var flightList = document.getElementById('flightTable').getElementsByTagName('tr');
            for (var i = 1; i < flightList.length; i++) {
                var td = flightList[i].querySelectorAll("td")[3];
                var checkbox = td.querySelector("input[type='checkbox']");
                if (checkbox.checked) {
                    idFlight = flightList[i].querySelectorAll("td")[0].innerHTML;
                }
            }

            var flightTable = document.getElementById('flightTable');
            var inputTeam = document.createElement('input');
            inputTeam.type = 'hidden';
            inputTeam.id = 'idTeam';
            inputTeam.name = 'idTeam';
            inputTeam.value = idTeam;
            flightTable.parentNode.insertBefore(inputTeam,  flightTable);
            var inputFlight = document.createElement('input');
            inputFlight.type = 'hidden';
            inputFlight.id = 'idFlight';
            inputFlight.name = 'idFlight';
            inputFlight.value = idFlight;
            inputTeam.parentNode.insertBefore(inputFlight, inputTeam);

            var appointForm = document.getElementById('appointForm');
            appointForm.submit();
        }
        else {
            alert("Please check team and flight and after click on button");
        }


    }

})();


