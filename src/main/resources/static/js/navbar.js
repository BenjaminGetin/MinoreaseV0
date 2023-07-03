function test() {
    var tabsNewAnim = $('#navbarSupportedContent');
    var selectorNewAnim = $('#navbarSupportedContent').find('li').length;
    var activeItemNewAnim = tabsNewAnim.find('.active');
    var activeWidthNewAnimHeight = activeItemNewAnim.innerHeight();
    var activeWidthNewAnimWidth = activeItemNewAnim.innerWidth();
    var itemPosNewAnimTop = activeItemNewAnim.position();
    var itemPosNewAnimLeft = activeItemNewAnim.position();
    $(".hori-selector").css({
        "top": itemPosNewAnimTop.top + "px",
        "left": itemPosNewAnimLeft.left + "px",
        "height": activeWidthNewAnimHeight + "px",
        "width": activeWidthNewAnimWidth + "px"
    });

    var navbarHeight = $(".navbar").height();
    var selectorBottom = itemPosNewAnimTop.top + activeWidthNewAnimHeight;
    var distanceFromBottom = navbarHeight - selectorBottom;
    $(".hori-selector").css("bottom", distanceFromBottom + "px");
}

$(document).ready(function() {
    setTimeout(function() {
        test();
    });
});

$(window).on('resize', function() {
    setTimeout(function() {
        test();
    }, 500);
});

$(".navbar-toggler").click(function() {
    $(".navbar-collapse").slideToggle(300);
    setTimeout(function() {
        test();
    });
});

$(document).ready(function() {
    var currentPage = $('body').data('page');
    var target = $('#navbarSupportedContent ul li a[href="' + currentPage + '"]');
    target.addClass('active').parent().addClass('active').siblings().removeClass('active');
});
