window.addEventListener('load', function () {
    function deleteBy() {
        const formulario = document.querySelector('#delete_paciente');
        let id = document.querySelector('#pacienteID').value;

        const url = '/pacientes/eliminar/' + id;
        const settings = {
            method: 'DELETE'
        };

        fetch(url, settings)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Error al eliminar paciente. Por favor, inténtalo nuevamente.');
                }
                formulario.reset();

                const responseDiv = document.querySelector('#response');
                responseDiv.innerHTML = '<div class="alert alert-success alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong>Paciente eliminado con éxito.</strong> </div>';
                responseDiv.style.display = "block";
            })
            .catch(error => {
                console.error('Error al eliminar paciente:', error.message);

                const responseDiv = document.querySelector('#response');
                responseDiv.innerHTML = '<div class="alert alert-danger alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong>' + error.message + '</strong> </div>';
                responseDiv.style.display = "block";
            });
    }

    const form = document.querySelector('#delete_paciente');
    form.addEventListener('submit', function (event) {
        event.preventDefault();
        deleteBy();
    });
});