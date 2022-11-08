
var idForMeals = 1;

function addMealOption(){

    const optionsBox = document.getElementById('options-box');

    var addMealOptionHTML = `<section id="optionNum${idForMeals}">
    <!-- type of meal -->
    <select name="mealType" id="meal${idForMeals}">
        <option value="breakfast">Breakfast</option>
        <option value="lunch">Lunch</option>
        <option value="dinner">Dinner</option>
        <option value="snack">Snack</option>
    </select>
    <!-- portions -->
    <input type="number" name="portions" id="mealPortions${idForMeals}" placeholder="portions">
    <!-- max cooking time -->
    <input type="number" name="maxTime" id="maxTimeMeal${idForMeals}" placeholder="max cook time">
    </section>`;

    optionsBox.innerHTML += addMealOptionHTML;

    idForMeals++;

}