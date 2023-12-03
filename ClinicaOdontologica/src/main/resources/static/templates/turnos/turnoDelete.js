window.addEventListener('load', function () {
    function deleteBy() {
        const formulario = document.querySelector('#delete_turno');
        let id = document.querySelector('#turnoID').value;

        const url = '/turnos/' + id;
        const settings = {
            method: 'DELETE'
        };

        fetch(url, settings)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Error al eliminar turno. Por favor, inténtalo nuevamente.');
                }
                formulario.reset();

                const responseDiv = document.querySelector('#response');
                responseDiv.innerHTML = '<div class="alert alert-success alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong>Turno eliminado con éxito.</strong> </div>';
                responseDiv.style.display = "block";
            })
            .catch(error => {
                console.error('Error al eliminar turno:', error.message);

                const responseDiv = document.querySelector('#response');
                responseDiv.innerHTML = '<div class="alert alert-danger alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong>' + error.message + '</strong> </div>';
                responseDiv.style.display = "block";
            });
    }

    const formdel = document.querySelector('#delete_turno');
    formdel.addEventListener('submit', function (event) {
        event.preventDefault();
        deleteBy();
    });
});