
var idForMeals = 1;

function addMealOption(){

    const optionsBox = document.getElementById('options-box');

    var addMealOptionHTML = `<section id="optionNum${idForMeals}" class="optionMeal">
    <!-- type of meal -->
    <select name="mealType" id="meal${idForMeals}">
        <option value="breakfast">Breakfast</option>
        <option value="lunch">Lunch</option>
        <option value="dinner">Dinner</option>
        <option value="snack">Snack</option>
    </select>
    <!-- portions -->
    <input type="number" name="portions" id="mealPortions${idForMeals}" placeholder="portions" min="1" value="1">
    <!-- max cooking time -->
    <input type="number" name="maxTime" id="maxTimeMeal${idForMeals}" placeholder="max cook time">
    <button type="button" onclick="removeMeal(this.id)" id="${idForMeals}" class="optionBtn">X</button>
    </section>`;

    optionsBox.innerHTML += addMealOptionHTML;

    idForMeals++;

}

function removeMeal(id){
    document.getElementById('optionNum' + id).remove();
}