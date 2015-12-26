$(document).ready(function () {

    $("#addPersonForm").submit(function (e) {
        e.preventDefault();
        postForm("/rest/person", this, function (result) {
            addPerson(result);
        });
    });

    $.ajax({
        url: "rest/person"
    }).then(function (data) {
        $.each(data, function (idx, value) {
            addPerson(value);
        })
    });
});

function postForm(url, form, callback) {
    return jQuery.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'type': 'POST',
        'url': url,
        'data': JSON.stringify($(form).serializeFormJSON()),
        'dataType': 'json',
        'success': callback
    });
}

function addAddress(container, address) {
    container.prepend($("<p>" + address.houseNumber + ", " + address.streetName + ", " + address.city + "</p>"));
}

function onAddressFormSubmit(e) {
    e.preventDefault();
    var container = $(this).closest(".addressList");
    var url = "/rest/person/" + container.attr("personId") + "/addresses";
    postForm(url, this, function (result) {
        addAddress(container, result);
    });
}

function addPerson(person) {
    var newElem = $(".personTemplate").clone();
    newElem.removeClass("personTemplate");
    newElem.find(".personInfo").text(person.name + ", " + person.age);
    var addressContainer = newElem.find(".addressList");
    addressContainer.attr("personId", person.id);
    addressContainer.find("form").on("submit", onAddressFormSubmit);
    $.each(person.addresses, function () {
        addAddress(addressContainer, this);
    });
    newElem.appendTo(".personContainer");
}

(function ($) {
    $.fn.serializeFormJSON = function () {

        var o = {};
        var a = this.serializeArray();
        $.each(a, function () {
            if (o[this.name]) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
        });
        return o;
    };
})(jQuery);