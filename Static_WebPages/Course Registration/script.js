let subjects = document.querySelectorAll('input[name="course"]');
let totalBox = document.getElementById("total");
let messagebox = document.getElementById("resultmessage");
subjects.forEach(item => {
    item.addEventListener("change", () => {
        let total = 0;

        subjects.forEach(sub => {
            if (sub.checked) {
                total += parseInt(sub.value);
            }
        });

        totalBox.innerText = "$" + total;
    });
});
document.getElementById("regForm").addEventListener("submit", function (e) {
    e.preventDefault();

    let selectedCourses = [];
    let totalFee = 0;

    subjects.forEach(sub => {
        if (sub.checked) {
            let subjectName = sub.parentElement.innerText.trim();
            selectedCourses.push(subjectName);
            totalFee += parseInt(sub.value);
        }
    });
    
    if (selectedCourses.length === 0) {
        messagebox.style.display = "block";
        messagebox.style.background = "white";
        messagebox.style.borderLeft = "5px solid red";
        messagebox.innerText = "Please select at least one course to register.";
        return;
    }
    
    let studentName = document.getElementById("Name").value;
    let coursesList = selectedCourses.map((course, index) => {
        return `${index + 1}. ${course}`;
    }).join("\n");
    
    let message =
        "Student Name: " + studentName + "\n\n" +
        "Registered Courses:\n" + coursesList + "\n\n" +
        "Total Fee: $" + totalFee;
    
    messagebox.innerText = message;
    messagebox.style.whiteSpace = "pre-wrap";
    messagebox.style.display = "block";
});
