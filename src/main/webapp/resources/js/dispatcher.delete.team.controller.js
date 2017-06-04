(function () {

    var deleteButton = document.getElementById('deleteTeamButton');
    deleteButton.addEventListener('click', deleteButtonClickHandler);
    var idTeam = 0;

    function deleteButtonClickHandler(event) {
        event.preventDefault();

        var teamRadioButton = document.getElementsByClassName('radioButtonTeam');
        for (var i = 0; i < teamRadioButton.length; i++) {
            if (teamRadioButton[i].type == "radio" && teamRadioButton[i].checked) {
                idTeam = teamRadioButton[i].value;
            }
        }

        if(idTeam === 0) {
            alert("Please check team and then click on button");
        }
        else {
            sendTeamData();
        }

    }
    
    function sendTeamData() {
        $.ajax({
            type: 'DELETE',
            url: CONTEXTPATH +'/teams/' + idTeam,
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
                alert('Error deleted team');
            }
        });
    }

})();

