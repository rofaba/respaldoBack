window.addEventListener('load', function () {
    const formulario = document.querySelector('#update_turno');

    formulario.addEventListener('submit', function (event) {
        event.preventDefault();
    //payload
       const formData = {
                   id: document.querySelector('#turno_id').value,
                   paciente:{
                   id: document.querySelector('#paciente_id').value,
                   },
                   odontologo:{
                   id: document.querySelector('#odontologo_id').value,
                   },
                   fechaTurno: document.querySelector('#fecha').value,
                   };

        const url = '/turnos';  //
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
                    throw new Error('Error al actualizar el turno. Por favor, inténtalo nuevamente.');
                }

                formulario.reset();

                const responseDiv = document.querySelector('#response');
                responseDiv.innerHTML = '<div class="alert alert-success alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong>Turno actualizado con éxito.</strong> </div>';
                responseDiv.style.display = "block";
            })
            .catch(error => {
                console.error('Error al actualizar turno:', error.message);
                // Mostrar un mensaje de error
                const responseDiv = document.querySelector('#response');
                responseDiv.innerHTML = '<div class="alert alert-danger alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong>' + error.message + '</strong> </div>';
                responseDiv.style.display = "block";
            });
    });
});