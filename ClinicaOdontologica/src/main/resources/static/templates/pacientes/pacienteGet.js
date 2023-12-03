window.addEventListener('load', function () {

    listarPacientes();
});
function listarPacientes() {
console.log("Script ejecutándose...");
   const url = '/pacientes/todos';
    fetch(url)
        .then(response => {
            if (!response.ok) {
                throw new Error('Error al obtener pacientes. Por favor, inténtalo nuevamente.');
            }
            return response.json();
        })
        .then(pacientes => {
             // Agrega esta línea para verificar los datos recibidos
            const pacientesList = document.getElementById('pacientes_list');
            pacientesList.innerHTML = '';
            pacientes.forEach(paciente => {
            const row = document.createElement('tr');
            row.innerHTML = `
               <td>${paciente.id}</td>
                <td>${paciente.nombre}</td>
                <td>${paciente.apellido}</td>
                <td>${paciente.cedula}</td>
                <td>${paciente.fechaIngreso}</td>
                <td>${paciente.domicilio.calle}</td>
                <td>${paciente.domicilio.numero}</td>
                <td>${paciente.domicilio.localidad}</td>
                <td>${paciente.domicilio.provincia}</td>
                <td>${paciente.email}</td>

             `;
             pacientesList.appendChild(row);
           });
        })
        .catch(error => {
            console.error('Error al obtener pacientes:', error.message);
        });
}