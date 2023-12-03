window.addEventListener('load', function () {

    listarOdontologos();
});
function listarOdontologos() {
console.log("Script ejecutándose...");
   const url = '/odontologos/todos';
    fetch(url)
        .then(response => {
            if (!response.ok) {
                throw new Error('Error al obtener odontólogos. Por favor, inténtalo nuevamente.');
            }
            return response.json();
        })
        .then(odontologos => {
            console.log(odontologos); // Agrega esta línea para verificar los datos recibidos
            const odontologosList = document.getElementById('odontologos_list');
            odontologosList.innerHTML = '';
            odontologos.forEach(odontologo => {
             const row = document.createElement('tr');
             row.innerHTML = `
                <td>${odontologo.id}</td>
                <td>${odontologo.matricula}</td>
                <td>${odontologo.nombre}</td>
                <td>${odontologo.apellido}</td>
                <td>

           `;

             odontologosList.appendChild(row);
           });

        })
        .catch(error => {
            console.error('Error al obtener odontólogos:', error.message);
        });
}