import { mostrarAlerta, validar } from './funciones.js';
import { nuevoProducto } from './API.js';


(function () {
    const formulario = document.querySelector('#formulario');
    formulario.addEventListener('submit', validarProducto);

    function validarProducto(e) {
        e.preventDefault();

        const nombre = document.querySelector('#nombre').value;
        const descripcion = document.querySelector('#descripcion').value;
        const marca = document.querySelector('#marca').value;
        const precio = document.querySelector('#precio').value;
        const cantidad = document.querySelector('#cantidad').value;
        const rubro = document.querySelector('#rubro').value;





        const producto = {
            nombre, 
            descripcion, 
            marca, 
            precio, 
            cantidad, 
            rubro 
        } ;

        if (validar(producto)) {
            // Mostrar mensaje
            mostrarAlerta('Todos los campos son obligatorios');
            return;
        }

        nuevoProducto(producto);
    }
    
})();