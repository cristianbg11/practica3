$(document).ready(function () {
    $("#viewopen").click(function () {
        $(".pop").fadeIn(300);
        positionPopup();
    });

    $(".pop > span").click(function () {
        $(".pop").fadeOut(300);
    });
});