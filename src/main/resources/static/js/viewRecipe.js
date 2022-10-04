

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
}

function closeBigBox(){
    document.getElementById('bigScreenID').style.display = 'none';


}