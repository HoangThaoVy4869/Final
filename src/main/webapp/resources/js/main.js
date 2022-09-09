/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function addToTeam(id, username, email, teamId) {
    event.preventDefault()
    
    fetch("/ExpenseManager/api/members", {
        method: 'post',
        body: JSON.stringify({
            "userId": id,
            "username": username,
            "email": email,
            "numbers": 1
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function(res){
        return res.json()
    })
}

function deleteMembers(userId){
    fetch(`/ExpenseManager/api/members/${userId}`, {
        method: "delete"
    }).then(function(res){
        return res.json()
    }).then(function(){
        location.reload()
    })
}
 
function changeButton(){
    let btnAdd = document.getElementsByClassName('btn-add')
    for (var i = 0 ; i < btnAdd.length; i++) {
        btnAdd[i].addEventListener('click', () => btnAdd[i].style.background="red")
    }
    
}


function addUserTeam(){
    if(confirm("Thêm những user này vào nhóm??") == true){
        fetch("/ExpenseManager/api/addUser", {
            method: "post"
        }).then(function(res){
            return res.json();
        }).then(function(code){
            console.info(code);
            location.reload();
        })
    }
}