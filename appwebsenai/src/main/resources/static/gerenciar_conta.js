document.addEventListener("DOMContentLoaded", function () {
    let comboPessoa = document.getElementById("pessoa");
    let comboPessoa1 = document.getElementById("pessoa1");
    let comboPessoa2 = document.getElementById("pessoa2");
    let comboPessoa3 = document.getElementById("pessoa3");

    let btnSacar = document.getElementById("btnSacar");
    let btnDepositar = document.getElementById("btnDepositar");
    let btnTransferir = document.getElementById("btnTransfererir");

    function preencherPessoa() {
        fetch("/all")
            .then(response => response.json())
            .then(data => {
                let option = document.createElement("option")
                option.value = null;
                option.textContent = "";
                comboPessoa.appendChild(option);
                data.forEach(pessoa => {
                    let option = document.createElement("option")
                    option.value = pessoa.id;
                    option.textContent = pessoa.name;
                    comboPessoa.appendChild(option);
                })

            })
    }
    preencherPessoa();

    function preencherPessoa1() {
        fetch("/all")
            .then(response => response.json())
            .then(data => {
                let option = document.createElement("option")
                option.value = null;
                option.textContent = "";
                comboPessoa1.appendChild(option);
                data.forEach(pessoa1 => {
                    let option = document.createElement("option")
                    option.value = pessoa1.id;
                    option.textContent = pessoa1.name;
                    comboPessoa1.appendChild(option);
                })

            })
    }
    preencherPessoa1();

    function preencherPessoa2() {
        fetch("/all")
            .then(response => response.json())
            .then(data => {
                let option = document.createElement("option")
                option.value = null;
                option.textContent = "";
                comboPessoa2.appendChild(option);
                data.forEach(pessoa2 => {
                    let option = document.createElement("option")
                    option.value = pessoa2.id;
                    option.textContent = pessoa2.name;
                    comboPessoa2.appendChild(option);
                })

            })
    }
    preencherPessoa2();

    function preencherPessoa3() {
        fetch("/all")
            .then(response => response.json())
            .then(data => {
                let option = document.createElement("option")
                option.value = null;
                option.textContent = "";
                comboPessoa3.appendChild(option);
                data.forEach(pessoa3 => {
                    let option = document.createElement("option")
                    option.value = pessoa3.id;
                    option.textContent = pessoa3.name;
                    comboPessoa3.appendChild(option);
                })

            })
    }
    preencherPessoa3();

    function Sacar(id, sacar) {
        fetch("/sacar", {
            method: "Put"
        })

    }

    function Depositar(id, depositar) {
        fetch("/depositar", {
            method: "Put"
        })

    }

    function Transferir(idOrigem, idDestino, quantidade) {
        fetch("/transferir", {
            method: "Put"
        })

    }

    btnSacar.addEventListener("click", function () {
        let selectedId = comboPessoa.value;
        let valor = parseFloat(document.getElementById("valor").value);
        Sacar(selectedId, sacar);
    });

    btnDepositar.addEventListener("click", function () {
        let selectedId = comboPessoa.value;
        let valor = parseFloat(document.getElementById("valor").value);
        Depositar(selectedId, depositar);
    });

    btnTransferir.addEventListener("click", function () {
        let selectedIdOrigem = comboPessoa2.value;
        let selectedIdDestino = comboPessoa3.value;
        let valor = parseFloat(document.getElementById("valor").value);
        Transferir(selectedIdOrigem, selectedIdDestino, quantidade);
    });
});