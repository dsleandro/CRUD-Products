const url = 'http://localhost:8080/product';
const urlproducts= 'http://localhost:8080/products';

// create new product
export const newProduct = async client => {

    try {
        await fetch(url, {
            method: 'POST',
            body: JSON.stringify( client ),
            headers: {
                'Content-Type': 'application/json'
            }
        });
        window.location.href = 'index.html';
    } catch (error) {
        console.log(error);
    }
}

export const getAllProducts = async()=>{

    try {
        const response = await fetch(urlproducts);
        const products = await response.json();
        
        return products;
    } catch (error) {
        console.log(error)
    }
}

export const deleteProduct = async id => {
    
    try {
       
        await fetch(`${url}/${id}`, {
            method: 'DELETE'
        });
    } catch (error) {
        console.log(error);
    }
}



