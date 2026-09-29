const form = document.getElementById("formLogin");

form.addEventListener("submit", async (event) => {

    event.preventDefault();

    const email = document.getElementById("email").value.trim();
    const senha = document.getElementById("senha").value;

    const resposta = await fetch("http://localhost:8080/auth/login", {
        method: "POST",

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify({
            email: email,
            senha: senha
        })
    });

    if (!resposta.ok) {
        alert("E-mail ou senha incorretos.");
        return;
    }

    const dados = await resposta.json();

    console.log(dados);

    sessionStorage.setItem("token", dados.token);

    alert("Login realizado com sucesso!");
});