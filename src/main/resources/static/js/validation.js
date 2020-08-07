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

function validateAddBook(){
    var formComplete = true;

    var bookTitle = document.getElementById("bookTitle").value;
    var bookAuthor = document.getElementById("bookAuthor").value;
    var bookYear = document.getElementById("bookYear").value;
    var bookISBN = document.getElementById("bookISBN").value;
    var bookQuantity = document.getElementById("bookQuantity").value;

    var bookTitleError = document.getElementById("bookTitle-error-message");
    var bookAuthorError = document.getElementById("bookAuthor-error-message");
    var bookYearError = document.getElementById("bookYear-error-message");
    var bookISBNError = document.getElementById("bookISBN-error-message");
    var bookQuantityError = document.getElementById("bookQuantity-error-message");

    var errorMessages = document.getElementsByTagName("span");
    for (let i = 0; i < errorMessages.length; i++){
        errorMessages[i].innerHTML = "";
    }

    //title
    if (!bookTitle){
        bookTitleError.innerHTML = "Please enter a book title";
        formComplete = false
    } else if (!bookTitle.replace(/\s/g, '').length){
        bookTitleError.innerHTML = "Only whitespace detected";
        formComplete = false
    }
    //Author
    if (!bookAuthor){
        bookAuthorError.innerHTML = "Please enter the book's author";
        formComplete = false
    } else if (!bookAuthor.replace(/\s/g, '').length){
        bookTitleError.innerHTML = "Only whitespace detected";
        formComplete = false
    }
    //Year
    if (!bookYear || bookYear.match(/[a-zA-Z]/)){
        bookYearError.innerHTML = "Please enter the publish year (numbers only)";
        formComplete = false
    } else if (!bookYear.replace(/\s/g, '').length){
        bookYear.innerHTML = "Only whitespace detected";
        formComplete = false
    }
    //ISBN
    if (!bookISBN || bookISBN.match(/[a-zA-Z]/)){
        bookISBNError.innerHTML = "Please enter the ISBN (numbers only)";
        formComplete = false
    } else if (!bookISBN.replace(/\s/g, '').length){
        bookYear.innerHTML = "Only whitespace detected";
        formComplete = false
    }

    //Quantity
    if (!bookQuantity || bookQuantity.match(/[a-zA-Z]/)){
        bookQuantityError.innerHTML = "Please enter the quantity (numbers only)";
        formComplete = false
    } else if (!bookQuantity.replace(/\s/g, '').length){
        bookYear.innerHTML = "Only whitespace detected";
        formComplete = false
    }

    return formComplete;
}