
    function submitForm() {
        var accountNumber = document.getElementById("receiverAccountNo").value;

        if (accountNumber === "") {
            document.getElementById("verificationMessage").innerHTML = "Please enter an account number.";
            document.getElementById("verificationMessage").style.color = "red";
            return;
        }

        // Create an AJAX request
        var xhr = new XMLHttpRequest();
        xhr.open("POST", "GetReceiverName", true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

        xhr.onreadystatechange = function() {
            if (xhr.readyState === 4) {
                if (xhr.status === 200) {
                    // Get the response text
                    var responseText = xhr.responseText;

                    // Update the verification message with the response
                    var verificationMessage = document.getElementById("verificationMessage");
                    verificationMessage.innerHTML = responseText;

                    // Set the color based on the response content
                    if (responseText.includes("Account holder:")) {
                        verificationMessage.style.color = "green";
                    } else {
                        verificationMessage.style.color = "red";
                    }
                } else {
                    // Handle other HTTP status codes (e.g., 404, 500)
                    document.getElementById("verificationMessage").innerHTML = "Verification failed.";
                    document.getElementById("verificationMessage").style.color = "red";
                }
            }
        };


        // Send the account number to the server
        xhr.send("receiverAccountNo=" + encodeURIComponent(accountNumber));
    }

	
	
	