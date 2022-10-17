
//get btn
const addIngredientBtn = document.getElementById('addIngrBtn');

//id for different inputs
var idForInputs = 1;
// function to add more ingredients inputs fields
function addMoreIngredientInputs(){
    

    // get box of input divs to add inputs to
    var inputBox = document.getElementById('inputsBox');
    //clone current inputbox
    var inputClone = document.getElementById('input-box').cloneNode(true);
    inputClone.id = 'input-box' + idForInputs;
    //change id of each input elements
    inputClone.getElementsByTagName('input')[0].id = 'ingrName' + idForInputs;
    inputClone.getElementsByTagName('input')[1].id = 'ingrAmount' + idForInputs;
    inputClone.getElementsByTagName('input')[2].id = 'ingrWeight' + idForInputs;

    //clear text in inputs
    inputClone.getElementsByTagName('input')[0].value = "";
    inputClone.getElementsByTagName('input')[1].value = "";
    inputClone.getElementsByTagName('input')[2].value = "";

    // add remove btn
    var removeBtn = document.createElement('button');
    removeBtn.id = 'RemoveIngredientBtn' + idForInputs;
    removeBtn.className = 'removeBtn';
    // removeBtn.onclick = removeIngredientFunc(this.id);
    removeBtn.setAttribute("onclick", "removeIngredientFunc(this.id);");
    removeBtn.textContent = 'remove';

    //add remove btn to the ingredient div
    inputClone.appendChild(removeBtn);

    
    // add ignredient div to parent with all ingredients
    inputBox.appendChild(inputClone);

    idForInputs++;
}

addIngredientBtn.addEventListener('click', addMoreIngredientInputs);

function removeIngredientFunc(id){

    var idNum = id[19];
    
    document.getElementById('input-box' + idNum).remove();
}