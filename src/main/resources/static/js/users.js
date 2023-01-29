// Call the dataTables jQuery plugin
$(document).ready(function(){
  loadUsers().then(r =>  "");
  $('#users').DataTable();


});

async function loadUsers(){
  const request = await fetch('api/usuarios', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });
  const users = await request.json();
  let listaUserHtml = " ";
  for (let user of users) {
    let botonEliminar = '<a href=\"#\" onclick= "eliminarUsuario('+user.id+')" class=\"btn btn-danger btn-circle\"><i class=\"fas fa-trash\"></i></a>';
    let usuarioHtml = "<tr>" +
        "<td>"+ user.id + "</td>"+
        "<td>"+ user.nombre +" "+ user.apellido + "</td>"+
        "<td>"+ user.email +"</td>" +
        "<td>" + user.telefono + "</td>" +
        "<td>" + user.password + "</td>" +
        "<td>" +botonEliminar+ "</td></tr>";
    listaUserHtml += usuarioHtml;
  }

  console.log(users);
  document.querySelector('#users tbody').outerHTML = listaUserHtml;
}

async function  eliminarUsuario(id){
  if(!confirm("¿Desea eliminar el usuario?")){
    return;
  }
  const request = await fetch('api/usuarios/' + id, {
    method: 'DELETE',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });
  location.reload();
}
