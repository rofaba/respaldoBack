window.addEventListener('load', function () {
    function deleteBy() {
        const formulario = document.querySelector('#delete_odontologo');
        let id = document.querySelector('#odontologoID').value;

        const url = '/odontologos/eliminar/' + id;
        const settings = {
            method: 'DELETE'
        };

        fetch(url, settings)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Error al eliminar odontólogo. Por favor, inténtalo nuevamente.');
                }
                formulario.reset();

                const responseDiv = document.querySelector('#response');
                responseDiv.innerHTML = '<div class="alert alert-success alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong>Odontólogo eliminado con éxito.</strong> </div>';
                responseDiv.style.display = "block";
            })
            .catch(error => {
                console.error('Error al eliminar odontólogo:', error.message);

                const responseDiv = document.querySelector('#response');
                responseDiv.innerHTML = '<div class="alert alert-danger alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong>' + error.message + '</strong> </div>';
                responseDiv.style.display = "block";
            });
    }
    //escucah formulario lanza la funcion deleteBy
    const form = document.querySelector('#delete_odontologo');
    form.addEventListener('submit', function (event) {
        event.preventDefault();
        deleteBy();
    });
});