// Call the dataTables jQuery plugin
$(document).ready(function(){
    //on ready
});

async function registrarUsuarios(){
    let datos = {};
    datos.nombre = document.getElementById('txtNombre').value;
    datos.apellido = document.getElementById('txtApellido').value;
    datos.email = document.getElementById('txtCorreo').value;
    datos.password = document.getElementById('txtPassword').value;
    let repetirPassword = document.getElementById('txtRepetirPassword').value;
    if(validarEmail(datos.email)!== true){
        alert("El campo correo debe ser valido.");
        return;
    } else if (repetirPassword !== datos.password){
        alert("La contraseña ingresa no coincide...");
        return;
    } else {
        alert("Se ha registrado el nuevo usuario...");
    }
    const request = await fetch('api/usuarios', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });
    const content = await request.json();
    console.log(content);
}
function validarEmail(email){
    // Obtenemos una referencia del input.
    let emailField = email;
    // Definimos nuestra expresión regular.
    let validEmail =  /^\w+([.-_+]?\w+)*@\w+([.-]?\w+)*(\.\w{2,10})+$/;
    // Pruebas para validar el email
    return validEmail.test(emailField);
}
function validaCampoVacio(){

}

