window.addEventListener('load', function () {
    listarTurnos();
});
function listarTurnos() {
console.log("Script ejecutándose...");
   const url = '/turnos/todos';
    fetch(url)
        .then(response => {
            if (!response.ok) {
                throw new Error('Error al obtener los turnos. Por favor, inténtalo nuevamente.');
            }
            return response.json();
        })
        .then(turnos => {
            const turnosList = document.getElementById('turnos_list');
            turnosList.innerHTML = '';
       turnos.forEach(turnoObject => {
            const id = turnoObject.id;
            const paciente = turnoObject.paciente;
            const odontologo = turnoObject.odontologo;
            const fechaTurno = turnoObject.fechaTurno;

         const row = document.createElement('tr');
         row.innerHTML = `
           <td>${id}</td>
           <td>${paciente.id}</td>
           <td>${odontologo.id}</td>
           <td>${fechaTurno}</td>
         `;

         turnosList.appendChild(row);
       });
        })
        .catch(error => {
            console.error('Error al obtener turnos:', error.message);
        });
}