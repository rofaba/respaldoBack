window.addEventListener('load', function () {

    const formulario = document.querySelector('#save_turno');

    formulario.addEventListener('submit', function (event) {

        event.preventDefault();

        const formData = {
            paciente:{
            id: document.querySelector('#paciente_id').value,
            },
            odontologo:{
            id: document.querySelector('#odontologo_id').value,
            },
            fechaTurno: document.querySelector('#fecha').value,
            };

        const url = '/turnos';
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
                                    throw new Error('Error al guardar turno. Por favor, inténtalo nuevamente.');
                                }

                                let successAlert = '<div class="alert alert-success alert-dismissible">' +
                                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                    '<strong>Turno agregado exitosamente</strong> </div>';

                                document.querySelector('#response').innerHTML = successAlert;
                                document.querySelector('#response').style.display = 'block';
                            })
                            .catch(error => {
                                console.error('Error al guardar turno:', error.message);
                                // Mostrar un mensaje de error
                                let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                    '<strong>' + error.message + '</strong> </div>';

                                document.querySelector('#response').innerHTML = errorAlert;
                                document.querySelector('#response').style.display = 'block';

                                resetUploadForm();
                            });
                });
});

function resetUploadForm() {
    document.querySelector('#paciente_id').value = "";
    document.querySelector('#odontologo_id').value = "";
    document.querySelector('#fecha').value = "";
    }
