#include <iostream>

using namespace std;

int main( int argc, char* argv[]) {
    unsigned int n = 5;

    while( n != 1 ) {
        cout << n << " ";
        if (n % 2 == 0) {
            n = n / 2;
        } else {
            n = 3 * n + 1;
        }
    }
    cout << "\n";

    return 0;   // all's well that ends well
}
