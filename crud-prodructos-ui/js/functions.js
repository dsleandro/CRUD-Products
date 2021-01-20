export function showMessage(message, targetId) {
    const alertMessage = document.querySelector('.bg-red-100');

    if (!alertMessage) {
        const alertMessage = document.createElement('p');

        alertMessage.classList.add('bg-red-100', 'border-red-400', 'text-red-700', 'px-4', 'py-3', 'rounded', 'max-w-lg', 'mx-auto', 'mt-6', 'text-center');

        alertMessage.innerHTML = `
            <strong class="font-bold">Error!</strong>
            <span class="block sm:inline">${message}</span>
        `;

        const form = document.querySelector("#" + targetId);
        form.appendChild(alertMessage);

        setTimeout(() => {
            alertMessage.remove();
        }, 3000);
    }
}

// No empty inputs
export function validate(obj) {
    return Object.values(obj).map(input => {
        input.replace(" ", "");
        return input === "";
    }).includes(true);
}