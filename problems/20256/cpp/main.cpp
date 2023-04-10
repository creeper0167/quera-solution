/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
#include <iostream>

using namespace std;

bool validateFood(string food);

int main()
{
    string food;
    
    cin >> food;
    
    if (validateFood(food))
        cout << "rahat baash";
    else
        cout << "nakhor lite";

    return 0;
}


bool validateFood(string foodString){
    int greenCounter, yellowCounter, redCounter;
    
    greenCounter = yellowCounter = redCounter = 0;
    for(int position=0; position < foodString.length(); position++){
        switch(foodString.at(position)){
            case 'G':
                greenCounter++;
                break;
            case 'R':
                redCounter++;
                break;
            case 'Y':
                yellowCounter++;
                break;
            default:
                break;
        }
    }
    if(redCounter > 2)
        return false;
    if( redCounter > 1 && yellowCounter > 1)
        return false;
    if( greenCounter == 0)
        return false;
    return true;
}
