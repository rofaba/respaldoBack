window.addEventListener('load', function () {

    const formulario = document.querySelector('#save_paciente');

    formulario.addEventListener('submit', function (event) {

        event.preventDefault();

        const formData = {
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            cedula: document.querySelector('#cedula').value,
            fechaIngreso: document.querySelector('#fechaIngreso').value,
            domicilio:{
            calle: document.querySelector('#calle').value,
            numero: document.querySelector('#numero').value,
            localidad: document.querySelector('#localidad').value,
            provincia: document.querySelector('#provincia').value,
            },
            email: document.querySelector('#email').value
        };

        const url = '/pacientes';
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
                                    throw new Error('Error al guardar paciente. Por favor, inténtalo nuevamente.');
                                }

                                // No necesitas analizar la respuesta si la solicitud POST fue exitosa
                                //return response.json(); // Remove this line

                                // Display success message
                                let successAlert = '<div class="alert alert-success alert-dismissible">' +
                                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                    '<strong>Paciente agregado exitosamente</strong> </div>';

                                document.querySelector('#response').innerHTML = successAlert;
                                document.querySelector('#response').style.display = 'block';
                            })
                            .catch(error => {
                                console.error('Error al guardar paciente:', error.message);
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
    document.querySelector('#nombre').value = "";
    document.querySelector('#apellido').value = "";
    document.querySelector('#cedula').value = "";
    document.querySelector('#fechaIngreso').value = "";
    document.querySelector('#calle').value = "";
    document.querySelector('#numero').value = "";
    document.querySelector('#localidad').value = "";
    document.querySelector('#provincia').value = "";
    document.querySelector('#email').value = "";

    }
