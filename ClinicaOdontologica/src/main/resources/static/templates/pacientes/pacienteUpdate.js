window.addEventListener('load', function () {
    const formulario = document.querySelector('#update_paciente');

    formulario.addEventListener('submit', function (event) {
        event.preventDefault();
    //payload
        const formData = {
                 id: document.querySelector('#paciente_id').value,
                 nombre: document.querySelector('#nombre').value,
                 apellido: document.querySelector('#apellido').value,
                 cedula: document.querySelector('#cedula').value,
                 fechaIngreso: document.querySelector('#fechaIngreso').value,
                 domicilio: {
                 calle: document.querySelector('#calle').value,
                 numero: document.querySelector('#numero').value,
                 localidad: document.querySelector('#localidad').value,
                 provincia: document.querySelector('#provincia').value,
                 },
                 email: document.querySelector('#email').value
             };

        const url = '/pacientes';  //
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
                    throw new Error('Error al actualizar el paciente. Por favor, inténtalo nuevamente.');
                }

                formulario.reset();

                const responseDiv = document.querySelector('#response');
                responseDiv.innerHTML = '<div class="alert alert-success alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong>Paciente actualizado con éxito.</strong> </div>';
                responseDiv.style.display = "block";
            })
            .catch(error => {
                console.error('Error al actualizar paciente:', error.message);
                // Mostrar un mensaje de error
                const responseDiv = document.querySelector('#response');
                responseDiv.innerHTML = '<div class="alert alert-danger alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong>' + error.message + '</strong> </div>';
                responseDiv.style.display = "block";
            });
    });
});