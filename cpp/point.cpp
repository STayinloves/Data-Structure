#include <bits/stdc++.h>
using namespace std;
template <class T> class Point {
  public:
    Point() {}
    Point(T x, T y) {
        this->x = x;
        this->y = y;
    }
    Point operator-(Point &p1) {
        Point _p(this->x - p1.x, this->y - p1.y);
        return _p;
    }
    Point operator/(Point &p1) {
        Point _p(this->x / p1.x, this->y / p1.y);
        return _p;
    }
    friend Point operator*(Point &p1, Point &p2) {
        Point _p(p1.x * p2.x, p1.y * p2.y);
        return _p;
    }
    friend Point operator+(Point &p1, Point &p2) {
        Point _p(p1.x + p2.x, p1.y + p2.y);
        return _p;
    }
    friend ostream &operator<<(ostream &out, Point p) {
        return out << '(' << p.get_x() << "," << p.get_y() << ')';
    }
    friend istream &operator>>(istream &in, Point &p) {
        return in >> p.x >> p.y;
    }
    friend bool operator==(Point &p1, Point &p2) {
        return (p1.x == p2.x) && (p1.y == p2.y);
    }
    friend T abs(Point &p) {
        return sqrt(pow(p.x, 2) + pow(p.y, 2));
    }

  private:
    T x, y;
    T get_x() {
        return this->x;
    }
    T get_y() {
        return this->y;
    }
};
int main() {
    Point<double> p1, p2;
    cin >> p1 >> p2;
    cout << boolalpha << (p1 == p2) << endl;
    cout << p1 / p2 << endl;
}