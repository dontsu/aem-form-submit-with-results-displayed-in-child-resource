use(function () {
    var model = request.getAttribute("model");
    var results = JSON.parse(request.getAttribute("results"));

    return {
        "model" : model,
        "jsonResults" : results
    }

});