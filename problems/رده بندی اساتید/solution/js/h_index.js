const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
    terminal: false
});

let loop = 0;
rl.on('line', input => {

    if (loop === 1) {
        const arr = input.split(' ').sort((a, b) => b - a);
        console.log(calculateHIndex(arr));
    }

    loop++;

    if (loop > 1) {
        rl.close();
        return
    }
});

const calculateHIndex = (sortedArray = []) => {
    let hIndex = 0;
    for (let index = 0; sortedArray.length; index++) {
        if (sortedArray[index] >= index + 1) {
            hIndex++;
        } else
            break
    }

    return hIndex;
}
