const url = 'http://localhost:8080';
const urlproduct = 'http://localhost:8080/product';


const authToken = localStorage.getItem("accessToken");

export const request = options => {

    if (options.url !== url + "/login" || options.url !== url + "/signup") {
        options.headers = {
            'Content-Type': 'application/json',
            'Authorization': authToken
        }
    } else {
        options.headers = {
            'Content-Type': 'application/json',
        }
    }

    return fetch(options.url, options)
        .then((data) => {
            return data.json();
        }).catch(e => console.log(e));

}

export const signin = user => {

    return request({
        url: url + "/login",
        method: 'POST',
        body: JSON.stringify(user),
    });

}

export const signup = async user => {

    return request({
        url: url + "/signup",
        method: 'POST',
        body: JSON.stringify(user),
    });
}

export const newProduct = async client => {

    return request({
        url: urlproduct,
        method: 'POST',
        body: JSON.stringify(client),
    }).then(() => window.location.href = 'index.html');
}

export const getAllProducts = () => {

    const products = request({
        url: urlproduct + "/all",
        method: 'GET'
    });

    return products;
}

export const deleteProduct = async id => {

    request({
        url: `${urlproduct}/${id}`,
        method: 'DELETE'
    }).then(() => window.location.href = 'index.html');

}
