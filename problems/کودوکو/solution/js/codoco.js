const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
    terminal: false
});

let count = 0;
let table;
let tableSideSize = 0;
let height = 0, width = 0;
const player1 = 'player 1';
const player2 = 'player 2';
let player = player1;
let opCount = 0;
rl.on('line', input => {

    if (count === 0) {
        const newInput = input.split(' ');
        height = parseInt(newInput[0]);
        width = parseInt(newInput[1]);
        tableSideSize = height * width;
        table = generateEmptyArray(tableSideSize, tableSideSize);
    } else if (count === 1) {
        opCount = parseInt(input);
    } else {
        const operation = input.split(' ');
        const row = operation[0] - 1;
        const column = operation[1] - 1;
        const number = operation[2];

        if (isCellValidForInsert(row, column, number)) {
            table[row][column] = number;
            console.log(`${player}:`);
            printTable();
            player = player === player1 ? player2 : player1;
        } else {
            console.log(`${player}:`);
            console.log('invalid move');
        }
    }

    if (opCount === (count - 1)) {
        rl.close();
        return
    }
    count++;
});


// algorithm methods
const isCellValidForInsert = (row, column, number) => {
    if (!isCellEmpty(row, column) || isNumberInRow(row, number) || isNumberColumn(column, number) || sameNumberInAree(row, column, number)) {
        return false
    }

    return true;
}

const isCellEmpty = (row, column) => {
    return (!table[row][column])
}

const isNumberInRow = (row, number) => {
    return searchInRow(row, number, 0, tableSideSize);
}

const isNumberColumn = (column, number) => {
    return searchInColumn(column, number, 0, tableSideSize);
}

const searchInRow = (row, number, start, end) => {
    if (start > tableSideSize || end > tableSideSize || start >= end)
        throw new Error('invalid parameters');
    for (let index = start; index < end; index++) {
        const element = table[row][index];
        if (number === element) {
            return true;
        }
    }
    return false
}

const searchInColumn = (column, number, start, end) => {
    if (start > tableSideSize || end > tableSideSize || start >= end)
        throw new Error('invalid parameters');
    for (let index = start; index < end; index++) {
        const element = table[index][column];
        if (number === element) {
            return true;
        }
    }
    return false
}

function searchAreaInArray( startRow, endRow, startColumn, endColumn, number) {
    for (let i = startRow; i < endRow; i++) {
      for (let j = startColumn; j < endColumn; j++) {
        // Perform your search logic here
        if (table[i][j] === number) {
          // Found the desired value
          return true; // Return the coordinates of the element
        }
      }
    }
  
    // The desired value was not found
    return false;
  }
  

const sameNumberInAree = (row, column, number) => {
    const startRow = findStartRow(row, height);
    const startColumn = findStartColumn(column, width);
    const endRow = startRow + height;
    const endColumn = startColumn + width;

    return searchAreaInArray(startRow, endRow, startColumn, endColumn, number);
}

function findStartRow(rowValue, height) {
    const startRow = rowValue - rowValue % height;;
    return startRow;
  }

  function findStartColumn(columnValue, width) {
    const startColumn = columnValue - columnValue % width;
    return startColumn;
  }
  
  

const printTable = () => {
    for (let rIndex = 0; rIndex < tableSideSize; rIndex++) {
        let row = '';
        for (let cIndex = 0; cIndex < tableSideSize; cIndex++) {
            const value = table[rIndex][cIndex];
            row += value ? value : '.';
        }
        console.log(row);
    }
}

// utils
function generateEmptyArray(n, m) {
    let myArray = [];
    for (let i = 0; i < n; i++) {
        myArray[i] = [];
        for (let j = 0; j < m; j++) {
            myArray[i][j] = undefined;
        }
    }
    return myArray;
}

