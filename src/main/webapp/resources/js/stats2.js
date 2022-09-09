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

function incomeChart(id, incomeLabels=[], incomeInfo=[]) {
    let colors = []
    for (let i = 0; i < incomeInfo.length; i++)
        colors.push(generateColor())
    const data = {
        labels: incomeLabels,
        datasets: [{
                label: 'Thống kê khoản thu nhập theo thời gian',
                data: incomeInfo,
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