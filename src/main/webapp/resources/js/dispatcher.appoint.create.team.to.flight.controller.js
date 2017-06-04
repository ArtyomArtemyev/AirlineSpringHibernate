var team;
var flightId;

window.onload=function(){
    var inputIdAirplane = document.getElementById('idAirplane');
    $.ajax({
        type: 'GET',
        url: CONTEXTPATH + '/airplane/'+ inputIdAirplane.value +'/team',
        headers: {
            'Accept': 'application/text'
        },
        dataType: 'text',
        success: function(receive) {
          team = JSON.parse(receive);
          $("#amountPilots").text(team.pilots);
          $("#amountNavigators").text(team.navigators);
          $("#amountRoperators").text(team.radio_operators);
          $("#amountStewardess").text(team.stewardess);
        },
        error: function (jqXhr, textStatus, errorThrown) {
            alert("Error");
        }
    });
};

    var sendButton = document.getElementById('createTeamButton');
    sendButton.addEventListener('click',sendButtonClickHandler);

    var result;
    var idMembers = [];

    function sendButtonClickHandler(event) {
        event.preventDefault();

        var appointmentMembers = [];
        var employeeList = document.getElementById('employeeTable').getElementsByTagName('tr');
        for (var i = 1; i < employeeList.length - 1; i++) {
            var td = employeeList[i].querySelectorAll("td")[5];
            var checkbox = td.querySelector("input[type='checkbox']");
            if (checkbox.checked) {
                idMembers.push(employeeList[i].querySelectorAll("td")[0].innerHTML);
                appointmentMembers.push(employeeList[i].querySelectorAll("td")[4].innerHTML);
            }
        }

        var pilot = [];
        var navigator = [];
        var radio_operator = [];
        var stewardess = [];
        for(var i = 0; i < appointmentMembers.length; i++) {
            switch (appointmentMembers[i]) {
                case "PILOT": {
                    pilot.push(1);
                    break;
                }
                case "NAVIGATOR": {
                    navigator.push(1);
                    break;
                }
                case "RADIO_OPERATOR": {
                    radio_operator.push(1);
                    break;
                }
                case "STEWARDESS": {
                    stewardess.push(1);
                    break;
                }
            }
        }

        if(pilot.length === Number(team.pilots) && navigator.length === Number(team.navigators) && radio_operator.length === Number(team.radio_operators) && stewardess.length === Number(team.stewardess)) {

            for(var i = 0; i < idMembers.length; i++) {
                if(i === 0) {
                    result = result+"[" + idMembers[i] + ",";
                }
                else {
                    if(i === idMembers.length - 1 ) {
                        result = result + idMembers[i] + "]";
                    }
                    else {
                        result = result + idMembers[i] + ",";
                    }
                }
            }
            var idFlight = document.getElementById('idFlight');
            flightId = Number(idFlight.innerHTML);

            sendTeamData();
        }
        else {
            alert('Team consist of ' + team.navigators + ' navigators and ' + team.radio_operators + ' radio operators,' + team.pilots + ' pliots and '+ team.stewardess +' stewardess ' + "\n" + "Please make true team");

            idMembers = [];
            for (var i = 1; i < employeeList.length - 1; i++) {
                var td = employeeList[i].querySelectorAll("td")[5];
                var checkbox = td.querySelector("input[type='checkbox']");
                if (checkbox.checked) {
                    checkbox.checked='';
                }
            }
        }

    }

    function sendTeamData() {
        $.ajax({
            type: 'POST',
            url: CONTEXTPATH + '/' + flightId + '/teams',
            data: result,
            headers: {
                'Accept': 'application/text',
                'Content-Type': 'application/json'
            },
            dataType: 'text',
            success: function(receive) {
                $("#contentDiv").empty();
                $("#informationP").text(receive);
                $("#hiddenLi").removeAttr('style');
                $("#hiddenLi2").removeAttr('style');
            },
            error: function() {
                alert('Error appointed new team');
            }
        });
    }



