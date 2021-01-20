import { showMessage, validate } from './functions.js';
import { signin } from './API.js';

(function () {

    if (window.location.href.match("\\w\/signin.html")) {
        const form = document.querySelector('#signinForm');
        form.addEventListener('submit', signinUser);
    } else {
        const form2 = document.querySelector('#signupForm');
        form2.addEventListener('submit', signupUser);
    }


    function signinUser(e) {
        e.preventDefault();

        const username = document.querySelector('#signinUsername').value;
        const password = document.querySelector('#signinPassword').value;

        const user = {
            username,
            password
        };

        if (validate(user)) {
            showMessage('Todos los campos son obligatorios', e.target.id);
            return;
        }

        signin(user).then(data => {
            localStorage.setItem("accessToken", data.accessToken);
            window.location.href = 'index.html'
        }).catch(e => console.log(e));
    }

    function signupUser(e) {
        e.preventDefault();

        const username = document.querySelector('#signupUsername').value;
        const password = document.querySelector('#signupPassword').value;

        const user = {
            username,
            password,
        };

        if (validate(user)) {
            showMessage('Todos los campos son obligatorios', e.target.id);
            return;
        }

        signup(user).then(data => {
            localStorage.setItem("accessToken", data.accessToken);
            window.location.href = 'index.html'
        });
    }

})();