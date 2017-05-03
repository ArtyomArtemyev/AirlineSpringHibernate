(function () {
    var deleteButton = document.getElementById('deleteButton');
    var createButton = document.getElementById('createButton');
    deleteButton.addEventListener('click', deleteButtonClickHandler);
    createButton.addEventListener('click', createButtonClickHandler);

    function deleteButtonClickHandler(event) {
        event.preventDefault();

        var adminTable = document.getElementById('adminTable').getElementsByTagName('tr');
        var check;
        for (var i = 2; i < adminTable.length; i++) {
            var td = adminTable[i].querySelectorAll("td")[3];
            var checkbox = td.querySelector("input[type='checkbox']");
            if (checkbox.checked) {
               check = true;
               break;
            }
        }

        if(check) {
            var deleteForm = document.getElementById('deleteForm');
            deleteForm.submit();
        }
        else {
            alert("Please check flight and then click on button")
        }

    }
    
    function createButtonClickHandler(event) {
        event.preventDefault();

        var navigation = document.getElementById('navigation');
        if (navigation.value === '') {
            alert('Please enter navigation and then click on button');
        }
        else {
            var createForm = document.getElementById('createForm');
            createForm.submit();
        }
    }


})();



