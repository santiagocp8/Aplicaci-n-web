/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
// Seleccionar elementos
        const formulario = document.getElementById("formulario");
        const tablaCuerpo = document.getElementById("cuerpotabla");

        // Manejar el envío del formulario
        formulario.addEventListener("submit", function (event) {
            event.preventDefault(); // Evitar recarga de la página

            // Capturar valores del formulario
            const nombre = document.getElementById("nombre").value;
            const genero = document.getElementById("genero").value;
            const calificacion = document.getElementById("calificacion").value;
            const precio = document.getElementById("precio").value;
            const anio = document.getElementById("anio").value;

            // Crear nueva fila
            const nuevaFila = document.createElement("tr");
            nuevaFila.innerHTML = `
                <td>${nombre}</td>
                <td>${genero}</td>
                <td>${calificacion}</td>
                <td>$${precio}</td>
                <td>${anio}</td>
                <td>
                    <button class="btn btn-update" onclick="actualizarFila(this)">Actualizar</button>
                    <button class="btn btn-delete" onclick="borrarFila(this)">Borrar</button>
                </td>
            `;

            // Agregar la fila a la tabla
            tablaCuerpo.appendChild(nuevaFila);

            // Resetear el formulario
            formulario.reset();
        });

        // Función para actualizar una fila
        function actualizarFila(button) {
            const fila = button.parentElement.parentElement; // Obtiene la fila
            alert(`Actualizar fila: ${fila.cells[0].innerText}`);
            // Aquí puedes agregar lógica para abrir un formulario de edición o similar
        }

        // Función para borrar una fila
        function borrarFila(button) {
            const fila = button.parentElement.parentElement; // Obtiene la fila
            if (confirm(`¿Seguro que quieres borrar el videojuego: ${fila.cells[0].innerText}?`)) {
                fila.remove(); // Borra la fila
            }
        }

