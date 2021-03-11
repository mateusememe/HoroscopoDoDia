
function geraHoroscopo(form){
    event.preventDefault();
    var datanasc = document.getElementById("dtnasc");
    console.log(datanasc.value);
    var httpRequest = new XMLHttpRequest();
    httpRequest.open("post","./recuperaHoroscopo");
    var formData = new FormData(form); //para recuperar os parâmetros do form
    const data = new URLSearchParams();

    for (const pair of formData)   //inserindo os parâmetros individualmente
        data.append(pair[0], pair[1]);
    
    httpRequest.send(data); // enviando os parâmetros junto com a chamada do servlet
    
    httpRequest.onreadystatechange = function () 
    {
        if (httpRequest.readyState === 4 && httpRequest.status === 200) {
            document.getElementById("previsao").innerHTML=httpRequest.responseText;
            //document.getElementById("corpo").style.cssText="background-image: linear-gradient(to bottom, #32b8d9 10%, black );"+
            //"background-repeat: no-repeat;"+
            //"background-size: 100% 100%;"+
            //"background-origin: content-box;";
            window.location.href='#focusIMG';
        }
           
    };
}
