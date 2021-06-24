document.getElementById("formConn").addEventListener("submit",async  function (e){
    //alert("ok");
    const inputs = document.getElementsByTagName("input");
    //console.log(inputs);
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
    }
    if (error){
        e.preventDefault();
        return false;
    }

    e.preventDefault();
    const r = await Swal.fire(
        'Good job!',
        'You clicked the button!',
        'success'
    );

    if (r.isConfirmed = true){
        document.getElementById("formConn").submit();
    }
    //e.preventDefault();
    return true
});
const inputs = document.getElementsByTagName("input");
let input;
for (input of inputs) {
    input.addEventListener("keyup", function (e){
        if (e.target.hasAttribute("error")){
            const idDivError = e.target.getAttribute("error");
            document.getElementById(idDivError).innerText = "";
        }
    });
}