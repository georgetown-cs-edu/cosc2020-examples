#include <iostream>

using namespace std;

// pick the median entry from the array
int median( int a[], int n ) {
    int m = n / 2;
    if (a[0] < a[n-1]) {
        if (a[m] < a[0]) {
            return a[0];
        } else if (a[m] > a[n-1]) {
            return a[n-1];
        } else {
            return a[m];
        }
    } else {
        if (a[m] < a[n-1]) {
            return a[n-1];
        } else if (a[m] > a[0]) {
            return a[0];
        } else {
            return a[m];
        }
    }
}

int main() {
    int a[] = { 1, 2, 3, 4, 5, 6, 7 };
    int b[] = { 7, 2, 4, 5, 6, 1, 3 };
    cout << "median of array a is " << median( a, 7 ) << "\n";
    cout << "median of array b is " << median( b, 7 ) << "\n";
    return 0;
}
 