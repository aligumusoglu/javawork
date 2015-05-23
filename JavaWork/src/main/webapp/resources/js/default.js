var offset;
setTimezone();

function setTimezone() {
    var date = new Date();
    offset = (date.getTimezoneOffset() * -1) / 60;
    document.cookie = "timezone-offset=" + offset + "; expires=Thu, 01 Dec 2071 12:00:00 GMT; path=/";
}

function showDialog(widgetName) {
    PF(widgetName).show();
}

function hideDialog(widgetName) {
    PF(widgetName).hide();
}

