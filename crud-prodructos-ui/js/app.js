import {  getAllProducts, deleteProduct } from './API.js';

(function () {
    const listado = document.querySelector('#product-list');

    document.addEventListener('DOMContentLoaded', showProducts);

    listado.addEventListener('click', confirmDelete);

    async function showProducts() {
        const products = await getAllProducts();

        products.forEach(product => {
            const { name, description, brand, price, id } = product;
           
            const row = document.createElement('tr');

            row.innerHTML += `
                <td class="px-6 py-4 whitespace-no-wrap border-b border-gray-200">
                    <p class="text-sm leading-5 font-medium text-gray-700 text-lg  font-bold"> ${name} </p>
                    <p class="text-sm leading-10 text-gray-700"> ${description} </p>
                </td>
                <td class="px-6 py-4 whitespace-no-wrap border-b border-gray-200 ">
                    <p class="text-gray-700">${brand}</p>
                </td>
                <td class="px-6 py-4 whitespace-no-wrap border-b border-gray-200  leading-5 text-gray-700">    
                    <p class="text-gray-600">${price}</p>
                </td>
                <td class="px-6 py-4 whitespace-no-wrap border-b border-gray-200 text-sm leading-5">
                    <a class="text-teal-600 hover:text-teal-900 mr-5">Editar</a>
                    <a href="#" data-product="${id}" class="text-red-600 hover:text-red-900 eliminar">Eliminar</a>
                </td>
            `;

            listado.appendChild(row);
        });
    }

    function confirmDelete(e) {
        if (e.target.classList.contains('eliminar')) {
            const ProductId = e.target.dataset.product;

            const confirmation = confirm('¿Deseas eliminar este producto?');

            if (confirmation) {
                deleteProduct(ProductId);
            }
        }
    }
})();