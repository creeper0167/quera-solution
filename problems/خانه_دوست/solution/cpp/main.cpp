/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int calculateArea(double side){
    double result = pow(side,2.0);
    return result;
}

int main()
{
    int n = 0;
    cin >> n;
    std::cout << calculateArea(n) << setprecision(0) << std::endl;

    return 0;
}
