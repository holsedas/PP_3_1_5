fetch('/rest/user').then(
    res => {
        res.json().then(
            data => {
                console.log(data)
                let temp = "";
                temp += "<td>" + data.id + "</td>";
                temp += "<td>" + data.firstName + "</td>";
                temp += "<td>" + data.lastName + "</td>";
                temp += "<td>" + data.age + "</td>";
                temp += "<td>" + data.email + "</td>";
                let rolesStr = "";
                data.roles.forEach(r => {
                    rolesStr += r.name.replaceAll("ROLE_", "") + " ";
                })
                temp += "<td>" + rolesStr + "</td>";
                document.getElementById("userTable").innerHTML = temp;
            }
        )
    }
)