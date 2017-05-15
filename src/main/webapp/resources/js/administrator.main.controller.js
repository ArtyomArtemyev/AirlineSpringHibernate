
    var addButton = document.getElementById('addButton');
    addButton.addEventListener('click', createButtonClickHandler);

    var idFlight = 0;

    function deleteButtonClickHandler(event) {
        event.preventDefault();
        idFlight = event.target.id;
        sendData();
    }
    
    function createButtonClickHandler(event) {
        event.preventDefault();

        var navigation = document.getElementById('navigation');
        if (navigation.value === '') {
            alert('Please enter navigation and then click on add button');
        }
        else {
            var addForm = document.getElementById('addForm');
            addForm.submit();
        }
    }

    function sendData(event)
    {
        $.ajax({
            type: 'DELETE',
            url:  '/flight/delete/' + idFlight,
            success: function(receive) {
                $("#adminTable").empty();
                $("#informationP").replaceWith(receive);
                $("#hiddenLi").removeAttr('style');
            },
            error: function() {
                alert('Error deleted flight');
            }
        });
    }




