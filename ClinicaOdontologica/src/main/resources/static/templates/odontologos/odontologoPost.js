window.addEventListener('load', function () {

    const formulario = document.querySelector('#save_odontologo');

    formulario.addEventListener('submit', function (event) {

        event.preventDefault();

        const formData = {
            matricula: document.querySelector('#matricula').value,
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
        };

        const url = '/odontologos';
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData),
        };

        fetch(url, settings)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Error al guardar odontólogo. Por favor, inténtalo nuevamente.');
                }
                // No necesitas analizar la respuesta si la solicitud POST fue exitosa
                return response.json();
            })
            .then(data => {
                // Si no hay ningún error se muestra un mensaje diciendo que la película
                // se agregó bien
                let successAlert = '<div class="alert alert-success alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong>Odontólogo agregado exitosamente</strong> </div>';

                document.querySelector('#response').innerHTML = successAlert;
                document.querySelector('#response').style.display = 'block';
            })
            .catch(error => {
                console.error('Error al guardar odontólogo:', error.message);
                // Mostrar un mensaje de error
                let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong>' + error.message + '</strong> </div>';

                document.querySelector('#response').innerHTML = errorAlert;
                document.querySelector('#response').style.display = 'block';

                resetUploadForm(); // Reset the form if there was an error
            });
    });
});

function resetUploadForm() {
    document.querySelector('#matricula').value = "";
    document.querySelector('#nombre').value = "";
    document.querySelector('#apellido').value = "";
}
