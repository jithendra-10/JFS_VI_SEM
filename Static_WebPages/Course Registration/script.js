// Select all checkboxes
let subjects = document.querySelectorAll('input[name="course"]');
let totalBox = document.getElementById("total");

// Update total when selecting/deselecting a course
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
        alert("Please select at least one course to register.");
        return;
    }
    let studentName = document.getElementById("Name").value;
    let message =
        "Student Name: " + studentName + "\n\n" +
        "Registered Courses:\n- " + selectedCourses.join("\n- ") + "\n\n" +
        "Total Fee: $" + totalFee;
    alert(message);
});
