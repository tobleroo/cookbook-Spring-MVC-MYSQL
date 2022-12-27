
// new list functions

function showAdditionalDetails(boxId){

    // get recipe id (frontend id)
    const id = boxId[6]

    //select the right recipe extra details
    const detailsBox = document.getElementById('extraDetails' + id)

    // show details box

    if( window.getComputedStyle( detailsBox ).display === "none" ) {
        detailsBox.style.display = "flex";
        document.getElementById('recipe'+id).innerHTML = '<i class="fa-solid fa-arrow-up-long fa-3x"></i>';
    } else {
        detailsBox.style.display = "";
        document.getElementById('recipe'+id).innerHTML = '<i class="fa-solid fa-arrow-down fa-3x">';
    }



    
}

