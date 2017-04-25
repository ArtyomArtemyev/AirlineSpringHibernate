(function () {

    var sendButton = document.getElementById('createTeamButton');

    sendButton.addEventListener('click',sendButtonClickHandler);

    function sendButtonClickHandler(event) {
        event.preventDefault();

        var idMembers = [];
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

        //Проверка правильности комманды
        var pilot = [];
        var navigator;
        var radio_operator;
        var stewardess = [];
        for(var i = 0; i < appointmentMembers.length; i++) {
            switch (appointmentMembers[i]) {
                case "PILOT": {
                    pilot.push(1);
                    break;
                }
                case "NAVIGATOR": {
                    navigator = true;
                    break;
                }
                case "RADIO_OPERATOR": {
                    radio_operator = true;
                    break;
                }
                case "STEWARDESS": {
                    stewardess.push(1);
                    break;
                }
            }
        }

        if(pilot.length === 2 && navigator && radio_operator && stewardess.length === 2) {

            var result;
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

            var employeeTable = document.getElementById('employeeTable');

            var inputNew = document.createElement('input');
            inputNew.type = 'hidden';
            inputNew.id = 'result';
            inputNew.name = 'result';
            inputNew.value = result;
            employeeTable.parentNode.insertBefore(inputNew, employeeTable);
            var teamForm = document.getElementById('teamForm');
            teamForm.submit();
        }
        else {
            alert("Team consist of 1 navigator and 1 radio operator, 2 pliots and 2 stewardess" + "\n" + "Please make true team");
        }

    }

})();

