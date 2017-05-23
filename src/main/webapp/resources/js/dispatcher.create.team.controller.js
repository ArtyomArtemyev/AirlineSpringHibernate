(function () {

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

        if(pilot.length === 2 && navigator.length === 1 && radio_operator.length === 1 && stewardess.length === 2) {

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
            sendTeamData();
        }
        else {
            alert("Team consist of 1 navigator and 1 radio operator, 2 pliots and 2 stewardess" + "\n" + "Please make true team");

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
        var prefix = '/airline/';
        console.log(result);
        $.ajax({
            type: 'POST',
            url: prefix +'team',
            data: result,
            headers: {
                'Accept': 'application/text',
                'Content-Type': 'application/json'
            },
            dataType: 'text',
            success: function(receive) {
                $("#employeeTable").empty();
                $("#informationP").replaceWith(receive);
                $("#hiddenLi").removeAttr('style');
            },
            error: function() {
                alert('Error created new team');
            }
        });
    }

})();

