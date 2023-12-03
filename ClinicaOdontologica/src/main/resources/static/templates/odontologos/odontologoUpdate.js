window.addEventListener('load', function () {
    const formulario = document.querySelector('#update_odontologo');

    formulario.addEventListener('submit', function (event) {
        event.preventDefault();

        const formData = {
            id: document.querySelector('#odontologo_id').value,
            matricula: document.querySelector('#matricula').value,
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
        };

        const url = '/odontologos';  // Reemplaza esta URL con la lógica correcta en tu backend
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData),
        };

        fetch(url, settings)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Error al actualizar odontólogo. Por favor, inténtalo nuevamente.');
                }
                // No necesitas analizar la respuesta si la solicitud PUT fue exitosa
                formulario.reset();
                // Mostrar un mensaje de éxito
                const responseDiv = document.querySelector('#response');
                responseDiv.innerHTML = '<div class="alert alert-success alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong>Odontólogo actualizado con éxito.</strong> </div>';
                responseDiv.style.display = "block";
            })
            .catch(error => {
                console.error('Error al actualizar odontólogo:', error.message);
                // Mostrar un mensaje de error
                const responseDiv = document.querySelector('#response');
                responseDiv.innerHTML = '<div class="alert alert-danger alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong>' + error.message + '</strong> </div>';
                responseDiv.style.display = "block";
            });
    });
});