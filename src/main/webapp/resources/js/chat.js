/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// Import the functions you need from the SDKs you need
import { initializeApp } from "https://www.gstatic.com/firebasejs/9.9.4/firebase-app.js";
import { getAnalytics } from "https://www.gstatic.com/firebasejs/9.9.4/firebase-analytics.js";
import {
getDatabase,
        set,
        ref,
        push,
        child,
        onValue,
        onChildAdded
} from "https://www.gstatic.com/firebasejs/9.9.4/firebase-database.js";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
    apiKey: "AIzaSyD3cJIGjEukO1kclp4KJKi8rEgg0D44pIw",
    authDomain: "expense-5c1f0.firebaseapp.com",
    databaseURL: "https://expense-5c1f0-default-rtdb.asia-southeast1.firebasedatabase.app",
    projectId: "expense-5c1f0",
    storageBucket: "expense-5c1f0.appspot.com",
    messagingSenderId: "44773979899",
    appId: "1:44773979899:web:fe7fc4c14d4ff11c9c625e",
    measurementId: "G-86M0LLTN53"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);
const database = getDatabase(app);

var myName = prompt("Enter your name");

submit.addEventListener('click', (e) => {
    var message = document.getElementById('message').value;
    var name = myName;

    const id = push(child(ref(database), 'messages')).key;

    set(ref(database, 'messages/' + id), {
        name: name,
        message: message
    });
    document.getElementById('message').value = "";
//    alert('message has sent');

});

const newMsg = ref(database, 'messages/');
onChildAdded(newMsg, (data) => {
    if (data.val().name != myName) {
        var divData = '<div class="d-flex justify-content-start mb-4" id="fromDiv">\n' +
                '                        <div class="img_cont_msg">\n' +
                '                            <img src="https://res.cloudinary.com/ou/image/upload/v1638695919/sample.jpg"\n' +
                '                                 class="rounded-circle user_img_msg">\n' +
                '                        </div>\n' +
                '                        <div class="msg_cotainer" >\n' +
                '                            ' + data.val().message + '' +
                '                            <span class="msg_time"></span>\n' +
                '                        </div>\n' +
                '                    </div>';
        var d1 = document.getElementById('bodyContent');
        d1.insertAdjacentHTML('beforebegin', divData);
    } else {
        var divData = '<div class="d-flex justify-content-end mb-4">\n' +
                '                        <div class="msg_cotainer_send" id="sendDiv">\n' +
                '                            ' + data.val().message + ''
                '                        </div>\n' +
                '                        <div class="img_cont_msg">\n' +
                '                            <img src="https://res.cloudinary.com/ou/image/upload/v1638695922/samples/animals/cat.jpg"\n\class="rounded-circle user_img_msg">\n' +
                '                        </div>\n' +
                '                    </div>';
        var d1 = document.getElementById('bodyContent');
        d1.insertAdjacentHTML('beforebegin', divData);
    }
});
