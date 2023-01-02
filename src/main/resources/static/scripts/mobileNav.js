

function openCloseMobileNav(){

    const mobileBox = document.getElementById('mobile-options-box');

    if( window.getComputedStyle( mobileBox ).display === "none"){
        mobileBox.style.display = 'block'
        document.getElementById('open-navbox').innerHTML = '<i class="fa-regular fa-rectangle-xmark fa-3x"></i>'
    }else{
        mobileBox.style.display = 'none';
        document.getElementById('open-navbox').innerHTML = '<i class="fa-solid fa-bars fa-3x"></i>'
    }



}