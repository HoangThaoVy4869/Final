/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function generateColor() {
    let r = parseInt(Math.random()*255);
    let g = parseInt(Math.random()*255);
    let b = parseInt(Math.random()*255);
    return `rgb(${r}, ${g}, ${b})`
}

function expenseChart(id, expenseLabels=[], expenseInfo=[]) {
    let colors = []
    for (let i = 0; i < expenseInfo.length; i++)
        colors.push(generateColor())
    const data = {
        labels: expenseLabels,
        datasets: [{
                label: 'Thống kê khoản chi theo thời gian',
                data: expenseInfo,
                backgroundColor: colors,
                borderColor: colors,
                borderWidth: 1
            }]
    };
    const config = {
        type: 'bar',
        data: data,
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        },
    };
    
    let ctx = document.getElementById(id).getContext('2d');
    new Chart(ctx, config)
}
function expenseChartMonth(id, expenseLabels=[], expenseInfo=[]) {
    let colors = []
    for (let i = 0; i < expenseInfo.length; i++)
        colors.push(generateColor())
    const data = {
        labels: expenseLabels,
        datasets: [{
                label: 'Thống kê khoản chi theo tháng',
                data: expenseInfo,
                backgroundColor: colors,
                borderColor: colors,
                borderWidth: 1
            }]
    };
    const config = {
        type: 'bar',
        data: data,
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        },
    };
    
    let ctx = document.getElementById(id).getContext('2d');
    new Chart(ctx, config)
}