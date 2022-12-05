

// func to select a recipe to "big screen"
function showData(optionsNum){

    // get id num 
    const id = optionsNum[7];

    // get all data from specific recipe
    const recipeName = document.getElementById('recipeNameID' + id).innerText;
    const recipeDifficulty = document.getElementById('difficultyID' + id).innerText;
    const cookTime = document.getElementById('cookTimeID' + id).innerText;
    const mealType = document.getElementById('mealTypeID' + id).innerText;
    const mealDescription = document.getElementById('descriptionID' + id).innerText;
    
    // display "big screen" and transfer data

    //check if big screen is hidden or not
    const bigScreen = document.getElementById('bigScreenID');

    if(bigScreen.style.display = 'none'){
        document.getElementById('putTitleRecipe').innerText = recipeName;
        document.getElementById('putDifficulty').innerText = recipeDifficulty;
        document.getElementById('putCookTime').innerText = cookTime;
        document.getElementById('putMealType').innerText = mealType;
        document.getElementById('putDescription').innerText = mealDescription;
        bigScreen.style.display = 'flex';
    }

    //ingredient data
    const list = turnIngredientsToLists(id);

    // ingredient div in big screen
    const ingredientBigBox = document.getElementById('ingredientsBigBox');

    let ingredientHTML = '';

    list.forEach(element =>{
        ingredientHTML += `<div class="one-ingredient">
        <p>${element[0]}</p>
        <p id="ingredient-amount">${element[1]}</p>
        <p id="ingredient-weight">${element[2]}</p>
    </div>`
    })

    ingredientBigBox.innerHTML = ingredientHTML;
    console.log(ingredientHTML);

    
    list.forEach(element => {
        console.log(element);
    })
}

function closeBigBox(){
    document.getElementById('bigScreenID').style.display = 'none';
}

//get the ingredient data from specific recipe and add to a complete list
// that will be returns to add to big screen of recipe details
function turnIngredientsToLists(idToDiv){

    const ingredientNames = [];
    document.getElementById('ingredientNameID' + idToDiv).querySelectorAll('span').forEach(data => {
        ingredientNames.push(data.innerText);
    })

    const ingredientAmounts = [];
    document.getElementById('ingredientAmountID' + idToDiv).querySelectorAll('span').forEach(data => {
        ingredientAmounts.push(data.innerText);
    })

    const ingredientWeights = [];
    document.getElementById('ingredientWeightID' + idToDiv).querySelectorAll('span').forEach(data => {
        ingredientWeights.push(data.innerText);
    })

    const listOfAllData = [];
    for(let i = 0; i < ingredientNames.length; i++){
        const oneIngredient = [ingredientNames[i],ingredientAmounts[i],ingredientWeights[i]]
        listOfAllData.push(oneIngredient);
    }

    return listOfAllData;
}