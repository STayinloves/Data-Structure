#include <bits/stdc++.h>
using namespace std;
class Calculator {
  public:
    Calculator(string str) {
        this->exp = str;
    }
    void clear() {
        this->exp = "";
    }
    void assign(string str) {
        this->exp = str;
    }
    long long run() {
        long long ans = 0, d[5];
        string temp;
        char op;
        stack<long long> v;
        istringstream in(exp);
        while (in >> temp) {
            if (temp.size() == 1 && !isdigit(temp[0])) switch (temp[0]) {
                    case '+': {
                        if (v.size() > 1) {
                            d[1] = v.top();
                            v.pop();
                            d[0] = v.top();
                            v.pop();
                            v.push(d[1] + d[0]);
                        } else {
                            cout << "add error" << endl;
                            return -1;
                        }
                        break;
                    }
                    case '-': {
                        if (v.size() > 1) {
                            d[1] = v.top();
                            v.pop();
                            d[0] = v.top();
                            v.pop();
                            v.push(d[0] - d[1]);
                        } else {
                            cout << "minus error" << endl;
                            return -1;
                        }
                        break;
                    }
                    case '*': {
                        if (v.size() > 1) {
                            d[1] = v.top();
                            v.pop();
                            d[0] = v.top();
                            v.pop();
                            v.push(d[1] * d[0]);
                        } else {
                            cout << "multiply error" << endl;
                            return -1;
                        }
                        break;
                    }
                    case '/': {
                        if (v.size() > 1) {
                            d[1] = v.top();
                            v.pop();
                            d[0] = v.top();
                            v.pop();
                            v.push(d[0] / d[1]);
                        } else {
                            cout << "divide error" << endl;
                            return -1;
                        }
                        break;
                    }
                }
            else {
                istringstream o(temp);
                o >> d[0];
                v.push(d[0]);
            }
        }
        ans = v.top();
        return ans;
    }

  private:
    string exp;
};
int main() {
    Calculator c("5 1 2 + 4 * + 3 -");
    cout << c.run() << endl;
}