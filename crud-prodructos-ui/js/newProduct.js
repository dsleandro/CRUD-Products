import { showMessage, validate } from './functions.js';
import { newProduct } from './API.js';


(function () {
    const form = document.querySelector('#form');
    form.addEventListener('submit', validateProduct);

    function validateProduct(e) {
        e.preventDefault();

        const name = document.querySelector('#name').value;
        const description = document.querySelector('#description').value;
        const brand = document.querySelector('#brand').value;
        const price = document.querySelector('#price').value;
        const amount = document.querySelector('#amount').value;
        const area = document.querySelector('#area').value;





        const product = {
            name, 
            description, 
            brand, 
            price, 
            amount, 
            area 
        } ;

        if (validate(product)) {
            showMessage('Todos los campos son obligatorios');
            return;
        }

        newProduct(product);
    }
    
})();