function validate(){
    var formMeetsRequirements = true;

    var categoryName = document.getElementById("categoryName").value;
    var categoryError = document.getElementById("category-error-message");

    if (!categoryName ||  categoryName.match(/[^a-zA-Z]/)) {
        categoryError.innerHTML = "Please enter a category (no special characters)";
        formMeetsRequirements = false;
    } else if (!categoryName.replace(/\s/g, '').length) {
        categoryError.innerHTML = "Only whitespace detected";
        formMeetsRequirements = false;
    }
    return formMeetsRequirements;

}