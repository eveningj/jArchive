function addMember(){
    let namePrompt = prompt("이름을 입력하세요");
    let agePrompt = prompt("나이를 입력하세요");
    let addrPrompt = prompt("주소를 입력하세요");

    const member = [
        {name : namePrompt, age : agePrompt, addr : addrPrompt}
    ]

    const tableTr = document.createElement("tr");

        const tableTd1 = document.createElement("td");
        const tableTd2 = document.createElement("td");
        const tableTd3 = document.createElement("td");
        const tableName = document.createTextNode(member[0].name);
        const tableAge = document.createTextNode(member[0].age);
        const tableAddr = document.createTextNode(member[0].addr);
        tableTr.appendChild(tableTd1);
        tableTd1.appendChild(tableName);
        tableTr.appendChild(tableTd2);
        tableTd2.appendChild(tableAge);
        tableTr.appendChild(tableTd3);
        tableTd3.appendChild(tableAddr);

        const table = document.querySelector("#exam1");
        table.appendChild(tableTr);
}


function addMember2(){
    let namePrompt = prompt("이름을 입력하세요");
    let agePrompt = prompt("나이를 입력하세요");
    let addrPrompt = prompt("주소를 입력하세요");
    const member = [
        {name : namePrompt, age : agePrompt, addr : addrPrompt}
    ]

    const tableTr = document.createElement("tr");



        const tableTd1 = document.createElement("td");
        const tableTd2 = document.createElement("td");
        const tableTd3 = document.createElement("td");
        const tableTd4 = document.createElement("td");
        const tableName = document.createTextNode(member[0].name);
        const tableAge = document.createTextNode(member[0].age);
        const tableAddr = document.createTextNode(member[0].addr);
        
        const delButton = document.createElement("button");
        

        
        delButton.onclick = function(){
            const delTr = tableTr;
            delTr.remove();
            }
        const delButtonText = document.createTextNode("삭제")
        
        tableTr.appendChild(tableTd1);
        tableTd1.appendChild(tableName);
        tableTr.appendChild(tableTd2);
        tableTd2.appendChild(tableAge);
        tableTr.appendChild(tableTd3);
        tableTd3.appendChild(tableAddr);
        tableTr.appendChild(tableTd4);
        tableTd4.appendChild(delButton);
        delButton.appendChild(delButtonText);
        const table = document.querySelector("#exam2");
        table.appendChild(tableTr);

}
