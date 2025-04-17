function showToast() {
           const toast = document.querySelector('.toast');
           toast.classList.add('show'); // Show the toast
         
		   
		//     setTimeout(() => {
          //     closeToast(); // Automatically close the toast after a certain time
        //   }, 7000); // Adjust time as needed (3 seconds in this case)
       }

       function closeToast() {
           const toast = document.querySelector('.toast');
           toast.classList.remove('show'); // Hide the toast
       }

       // Call showToast to display the toast on page load or event
       window.onload = showToast; // Automatically show on page load