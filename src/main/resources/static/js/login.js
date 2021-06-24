document.getElementById("formConn").addEventListener("submit",function (e){
    //alert("ok");
    const inputs = document.getElementsByTagName("input");
    console.log(inputs);
    let error = false;

    let input;
    for (input of inputs) {
            if (input.hasAttribute("error")){
                const idDivError = input.getAttribute("error");
                if (!input.value) {
                    document.getElementById(idDivError).innerText = "Ce champ est obligatoire";
                    error = true;
                }
                else {
                    document.getElementById(idDivError).innerText = "";
                }
            }
            //error = true;

        //error = false;
    }
    if (error){
        e.preventDefault();
        return false;
    }
});




function keyInput(e){
    if (e.target.hasAttribute("error")){
        const idDivError = e.target.getAttribute("error");
        document.getElementById(idDivError).innerText = "";
    }
}