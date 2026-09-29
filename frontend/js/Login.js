const botaoLogin = document.getElementById("loginButton");

botaoLogin.addEventListener("click", async () => {

    const email = document.getElementById("username").value.trim();
    const senha = document.getElementById("password").value;

    console.log("E-mail:", email);
    console.log("Senha:", senha);

    try {

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

        const dados = await resposta.json();

        console.log("Resposta do backend:", dados);

        if (!resposta.ok) {
            alert("E-mail ou senha incorretos.");
            return;
        }

        sessionStorage.setItem("token", dados.token);

        window.location.href = "dashboard.html";

    } catch (erro) {

        console.error("Erro:", erro);

        alert("Não foi possível conectar ao servidor.");
    }
});