
//get btn
const addIngredientBtn = document.getElementById('addIngrBtn');

//id for different inputs
var idForInputs = 1;
// function to add more ingredients inputs fields
function addMoreIngredientInputs(){

    // get box of input divs to add inputs to
    var inputBox = document.getElementById('inputsBox');

    //use innerhtml create new instead
    var oneIngredientBox = document.createElement('div');
    oneIngredientBox.id = 'input-box' + idForInputs;
    oneIngredientBox.classList.add('one-ingredient-box');

    let inputHtml = `<input type="text" placeholder="ingredient name" name="ingrName" id="ingrName${idForInputs}" class="ingr-name">
    <input type="number" placeholder="weight" name="ingrAmount" id="ingrAmount${idForInputs}" class="ingr-amount" step=".01">
    <input type="text" placeholder="weight type" name="ingrWeight" id="ingrWeight${idForInputs}" class="ingr-weight">
    <button type="button" id="RemoveIngredientBtn${idForInputs}" class="removeBtn" onclick="removeNewIngredientFunc(this.id)">Remove</button>`;
    oneIngredientBox.innerHTML = inputHtml;

    inputBox.appendChild(oneIngredientBox);

    idForInputs++;
}

addIngredientBtn.addEventListener('click', addMoreIngredientInputs);

function removeNewIngredientFunc(id){

    var idNum = id[19];
    
    document.getElementById('input-box' + idNum).remove();
}

function removeExistingIngredient(idName){
    var id = idName[10]

    document.getElementById('existingID' + id).remove();
}