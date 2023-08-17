

const formPessoa = document.getElementById("cadastroPessoa"); //id do formulario

const tabelaPessoa = document.getElementById("tabelaPessoas")
    .getElementsByTagName('tbody')[0];

const btnAll = document.getElementById("listarPessoas");

const btnDelete = document.getElementById("excluir");


formPessoa.addEventListener("submit", function (event){
    event.preventDefault(); // permite customizar o evento no submit
    let formDados= new FormData(formPessoa);
    let parametros= new URLSearchParams(formDados);

    fetch("/person?"+ parametros.toString(),{                       //chamar os dados like postman
        method: "POST"
    }).then(response => response.json())
        .then(data => {
            document.getElementById("id").value = data.id;
        })
});


btnDelete.addEventListener("click", function (){
    fetch("/person?name=" + document.getElementById("nome").value, {
        method: "DELETE"
    }).then(response => response.json())

});




btnAll.addEventListener("click", function (){
    fetch("/all")
        .then(response => response.json())
        .then(data => {

            tabelaPessoa.innerHTML="";
            data.forEach(pessoa => {
                let row = tabelaPessoa.insertRow();
                row.insertCell(0).textContent = pessoa.id;
                row.insertCell(1).textContent = pessoa.name;
                row.insertCell(2).textContent = pessoa.sexo;
            })
        })
});





