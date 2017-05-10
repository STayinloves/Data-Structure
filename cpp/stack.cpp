#include <iostream>
#include <string>
#include <vector>

using namespace std;
const int MAX_LENGTH = 1000;
template <class T> class Stack {
  public:
    Stack() {}
    void push(T item) {
        v.push_back(item);
    }
    bool pop() {
        if (!v.size()) return false;
        v.pop_back();
        return true;
    }
    bool empty() {
        return v.empty();
    }
    T top() {
        return *v.rbegin();
    }
    size_t size() {
        return v.size();
    }

  private:
    vector<T> v;
};
void PrintMatchedPair(string exp) {
    Stack<int> s;
    for (int i = 0; i < exp.size(); i++) {
        if (exp[i] == '(') {
            s.push(i);
        } else if (exp[i] == ')') {
            if (!s.empty()) {
                cout << "Match the " << s.top() << " and " << i << endl;
                s.pop();
            } else {
                cout << i << " miss match" << endl;
            }
        }
    }
    while (!s.empty()) {
        cout << s.top() << " remain" << endl;
        s.pop();
    }
    return;
}
int main() {
    PrintMatchedPair("((())");
    return 0;
}